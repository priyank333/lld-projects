/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkinglot.model;

import java.sql.Timestamp;

/**
 *
 * @author priyank
 */
public class Ticket {
    private String ticketId;
    private Slot slot;
    private Timestamp parkedTime;
    private Timestamp unparkedTime;
    private String registrationNo;
    private String color;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Timestamp getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(Timestamp parkedTime) {
        this.parkedTime = parkedTime;
    }

    public Timestamp getUnparkedTime() {
        return unparkedTime;
    }

    public void setUnparkedTime(Timestamp unparkedTime) {
        this.unparkedTime = unparkedTime;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketId=" + ticketId 
                + ", slot=" + slot 
                + ", parkedTime=" + parkedTime 
                + ", unparkedTime=" + unparkedTime 
                + ", registrationNo=" + registrationNo 
                + ", color=" + color + '}';
    }
    
}
