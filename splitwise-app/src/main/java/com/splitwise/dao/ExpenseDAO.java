/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.dao;

import com.splitwise.dao.dto.ExpenseDTO;
import com.splitwise.dao.mapper.ExpenseDTOMapper;
import com.splitwise.requestbody.ExpenseReqBody;
import com.splitwise.requestbody.UserExpenseReqBody;
import com.splitwise.sql.SqlQueries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author priyank
 */
@Repository
public class ExpenseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SqlQueries sqlQueries;

    public String addExpense(ExpenseReqBody expenseReqBody) {
        String expenseId = UUID.randomUUID().toString();

        int rowAffected = jdbcTemplate.update(sqlQueries.addExpense, new Object[]{
            expenseId,
            expenseReqBody.getExpenseDetails().getDescription(),
            new Date()
        });
        if (rowAffected > 0) {
            List<UserExpenseReqBody> usersExpenseReqBody = expenseReqBody.getUsers();
            int[] result = jdbcTemplate.batchUpdate(sqlQueries.addUserExpense,
                    new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    UserExpenseReqBody userExpenseReqBody = usersExpenseReqBody.get(i);
                    ps.setString(1, UUID.randomUUID().toString());
                    ps.setString(2, expenseId);
                    ps.setString(3, userExpenseReqBody.getUserId());
                    ps.setString(4, expenseReqBody.getGroupId());
                    ps.setDouble(5, userExpenseReqBody.getAmountPaid());
                    ps.setDouble(6, userExpenseReqBody.getOweAmount());
                }

                @Override
                public int getBatchSize() {
                    return usersExpenseReqBody.size();
                }
            });
            int successCount = 0;
            for (int eachRowRes : result) {
                if (eachRowRes == 1) {
                    successCount++;
                }
            }
            return successCount == usersExpenseReqBody.size() ? expenseId : null;
        }
        return null;
    }

    public List<ExpenseDTO> listExpensesByGroup(String groupId) {
         List<ExpenseDTO> expenseList = jdbcTemplate.query(
                 sqlQueries.viewExpensesByGroup,
                new Object[]{groupId}, new ExpenseDTOMapper());
        return expenseList;
    }

}
