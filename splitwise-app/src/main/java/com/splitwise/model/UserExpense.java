/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.model;

/**
 *
 * @author priyank
 */
public class UserExpense {
    private String userExpenseId;
    private Expense expense;
    private Group group;
    private Double amountPaid;
    private Double oweAmount;
    private User user;

    public String getUserExpenseId() {
        return userExpenseId;
    }

    public void setUserExpenseId(String userExpenseId) {
        this.userExpenseId = userExpenseId;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Double getOweAmount() {
        return oweAmount;
    }

    public void setOweAmount(Double oweAmount) {
        this.oweAmount = oweAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserExpense{" + "userExpenseId=" + userExpenseId + ", expense=" + expense + ", group=" + group + ", amountPaid=" + amountPaid + ", oweAmount=" + oweAmount + ", user=" + user + '}';
    }
    
    
}
