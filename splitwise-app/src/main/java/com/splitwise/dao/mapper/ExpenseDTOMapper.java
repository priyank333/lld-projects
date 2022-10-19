/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.dao.mapper;

import com.splitwise.dao.dto.ExpenseDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author priyank
 */
public class ExpenseDTOMapper implements RowMapper<ExpenseDTO> {

    @Override
    public ExpenseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setUserExpenseId(rs.getString(1));
        expenseDTO.setExpenseId(rs.getString(2));
        expenseDTO.setUserId(rs.getString(3));
        expenseDTO.setGroupId(rs.getString(4));
        expenseDTO.setAmountPaid(rs.getDouble(5));
        expenseDTO.setOweAmount(rs.getDouble(6));
        expenseDTO.setBalance(rs.getDouble(7));
        expenseDTO.setDescription(rs.getString(8));
        expenseDTO.setExpenseOn(rs.getDate(9));
        expenseDTO.setUserName(rs.getString(10));
        expenseDTO.setGroupName(rs.getString(11));
        return expenseDTO;
    }

}
