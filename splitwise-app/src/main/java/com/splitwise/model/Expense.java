/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.model;

import java.util.Date;

/**
 *
 * @author priyank
 */
public class Expense {
    private String expenseId;
    private String description;
    private Date expenseOn;

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

    public Date getExpenseOn() {
        return expenseOn;
    }

    public void setExpenseOn(Date expenseOn) {
        this.expenseOn = expenseOn;
    }

    @Override
    public String toString() {
        return "Expense{" + "expenseId=" + expenseId + ", description=" + description + ", expenseOn=" + expenseOn + '}';
    }
    
    
}
