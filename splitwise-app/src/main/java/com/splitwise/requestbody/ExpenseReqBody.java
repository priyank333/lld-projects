/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.requestbody;

import java.util.List;

/**
 *
 * @author priyank
 */
public class ExpenseReqBody {

    private String groupId;
    private List<UserExpenseReqBody> users;
    private ExpenseDetailsReqBody expenseDetails;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<UserExpenseReqBody> getUsers() {
        return users;
    }

    public void setUsers(List<UserExpenseReqBody> users) {
        this.users = users;
    }

    public ExpenseDetailsReqBody getExpenseDetails() {
        return expenseDetails;
    }

    public void setExpenseDetails(ExpenseDetailsReqBody expenseDetails) {
        this.expenseDetails = expenseDetails;
    }

    @Override
    public String toString() {
        return "ExpenseReqBody{" + "groupId=" + groupId + ", users=" + users + ", expenseDetails=" + expenseDetails + '}';
    }

}
