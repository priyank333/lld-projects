/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.sql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @author priyank
 */
@Component
@PropertySource("classpath:queries.properties")
public class SqlQueries {

    @Value("${add-user}")
    public String addUser;

    @Value("${add-group}")
    public String addGroup;

    @Value("${add-group-user}")
    public String addGroupUser;

    @Value("${add-expense}")
    public String addExpense;

    @Value("${add-user-expense}")
    public String addUserExpense;

    @Value("${view-expenses-by-group}")
    public String viewExpensesByGroup;
}
