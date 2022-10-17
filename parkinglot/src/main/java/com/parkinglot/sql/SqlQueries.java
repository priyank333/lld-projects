/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkinglot.sql;

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

    @Value("${add-parking-lot}")
    public String addParkingLot;

    @Value("${add-slot}")
    public String addSlot;

    @Value("${add-ticket}")
    public String addTicket;

    @Value("${retrieve-slot-for-booking}")
    public String retrieveSlotForBooking;

    @Value("${update-slot-occupancy}")
    public String updateSlotOccupancy;

    @Value("${retrieve-slot-by-slot-id}")
    public String retrieveSlotBySlotId;

    @Value("${get-slot-id-by-ticket-id}")
    public String getSlotIdByTicketId;

    @Value("${update-ticket-unparked-time}")
    public String updateTicketUnparkedTime;
}
