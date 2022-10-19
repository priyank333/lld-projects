/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.dao;

import com.splitwise.model.User;
import com.splitwise.sql.SqlQueries;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author priyank
 */
@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SqlQueries sqlQueries;

    @Transactional
    public String addUser(User user) {
        String userId = UUID.randomUUID().toString();;
        user.setUserId(userId);
        int rowsAffected = jdbcTemplate.update(sqlQueries.addUser, new Object[]{
            user.getUserId(),
            user.getUserName(),
            user.getEmailId()});
        return rowsAffected > 0 ? userId : null;
    }

}
