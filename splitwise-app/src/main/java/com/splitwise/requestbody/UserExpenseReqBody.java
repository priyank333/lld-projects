/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.requestbody;

/**
 *
 * @author priyank
 */
public class UserExpenseReqBody {

    private String userId;
    private Double amountPaid;
    private Double oweAmount;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserExpenseReqBody{" + "userId=" + userId + ", amountPaid=" + amountPaid + ", oweAmount=" + oweAmount + '}';
    }

}
