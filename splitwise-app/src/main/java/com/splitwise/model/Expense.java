/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.model;

import java.util.List;

/**
 *
 * @author priyank
 */
public class Expense {
    private String expenseId;
    private String description;
    private List<UserShare> userShares;

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserShare> getUserShares() {
        return userShares;
    }

    public void setUserShares(List<UserShare> userShares) {
        this.userShares = userShares;
    }

    @Override
    public String toString() {
        return "Expense{" + "expenseId=" + expenseId + ", description=" + description + ", userShares=" + userShares + '}';
    }
    
}
