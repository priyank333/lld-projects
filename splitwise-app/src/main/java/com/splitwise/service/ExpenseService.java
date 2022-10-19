/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.service;

import com.splitwise.dao.ExpenseDAO;
import com.splitwise.dao.dto.ExpenseDTO;
import com.splitwise.model.Expense;
import com.splitwise.model.Group;
import com.splitwise.model.Response;
import com.splitwise.model.User;
import com.splitwise.model.UserShare;
import com.splitwise.requestbody.ExpenseReqBody;
import com.splitwise.requestbody.UserExpenseReqBody;
import com.splitwise.util.Utility;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.stream.Collectors.groupingBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author priyank
 */
@Service
public class ExpenseService {

    @Autowired
    private ExpenseDAO expenseDAO;

    public Response addExpense(ExpenseReqBody expenseReqBody) {
        boolean isValid = validateExpense(expenseReqBody.getUsers());

        Response response = new Response(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
        if (isValid) {
            String expenseId = expenseDAO.addExpense(expenseReqBody);
            if (expenseId != null) {
                response.setStatusCode(HttpStatus.CREATED.value());
                response.setResponse(Map.of("expenseId", expenseId));
            } else {
                response.setResponse("Unavilable to add expense");
            }
        } else {
            response.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
            response.setResponse("Expense is not valid");
        }
        return response;
    }

    public Response listGroupExpense(String groupId) {
        List<ExpenseDTO> expenses = expenseDAO.listExpensesByGroup(groupId);
        Group group = prepareResponse(expenses);
        if(group == null) {
            return new Response(HttpStatus.NO_CONTENT.value(), "No data");
        }else {
            return new Response(HttpStatus.OK.value(), group);
        }
    }

    private Group prepareResponse(List<ExpenseDTO> expensesDTO) {
        Optional<ExpenseDTO> firstEleGlo = expensesDTO.stream().findFirst();

        if (firstEleGlo.isPresent()) {
            Group group = new Group();
            Map<String, List<ExpenseDTO>> groupByExpense = expensesDTO.stream().collect(
                    groupingBy(ExpenseDTO::getExpenseId));
            List<Expense> expenses = new ArrayList<>();
            group.setExpenses(expenses);
            group.setGroupId(firstEleGlo.get().getGroupId());
            group.setGroupName(firstEleGlo.get().getGroupName());
            for (Map.Entry<String, List<ExpenseDTO>> entry : groupByExpense.entrySet()) {
                List<ExpenseDTO> value = entry.getValue();
                Optional<ExpenseDTO> firstEle = value.stream().findFirst();
                if (firstEle.isPresent()) {
                    Expense expense = new Expense();
                    expense.setDescription(firstEle.get().getDescription());
                    expense.setExpenseId(firstEle.get().getExpenseId());
                    List<UserShare> userShares = new ArrayList<>();
                    expense.setUserShares(userShares);
                    expenses.add(expense);
                    for (ExpenseDTO expenseDTO : value) {
                        UserShare userShare = new UserShare();
                        userShare.setAmount(expenseDTO.getBalance());
                        userShare.setUser(new User(
                                expenseDTO.getUserId(),
                                expenseDTO.getUserName(),
                                null));
                        userShares.add(userShare);
                    }
                }

            }
            return group;
        }
        return null;
    }

    private boolean validateExpense(List<UserExpenseReqBody> userExpense) {

        double amountPaid = 0.00, oweAmount = 0.00;

        for (UserExpenseReqBody userExpenseReqBody : userExpense) {
            amountPaid += userExpenseReqBody.getAmountPaid();
            oweAmount += userExpenseReqBody.getOweAmount();
        }
        return Utility.compareDouble(amountPaid + oweAmount, 0.00);
    }
}
