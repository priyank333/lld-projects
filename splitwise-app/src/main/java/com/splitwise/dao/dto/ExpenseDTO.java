/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.dao.dto;

import java.util.Date;

/**
 *
 * @author priyank
 */
public class ExpenseDTO {
    private String userExpenseId;
    private String expenseId;
    private String userId;
    private String groupId;
    private Double amountPaid;
    private Double oweAmount;
    private Double balance;
    private String description;
    private Date expenseOn;
    private String userName;
    private String groupName;

    public String getUserExpenseId() {
        return userExpenseId;
    }

    public void setUserExpenseId(String userExpenseId) {
        this.userExpenseId = userExpenseId;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Expense{" + "userExpenseId=" + userExpenseId + ", expenseId=" + expenseId + ", userId=" + userId + ", groupId=" + groupId + ", amountPaid=" + amountPaid + ", oweAmount=" + oweAmount + ", balance=" + balance + ", description=" + description + ", expenseOn=" + expenseOn + ", userName=" + userName + ", groupName=" + groupName + '}';
    }
    
    
}
