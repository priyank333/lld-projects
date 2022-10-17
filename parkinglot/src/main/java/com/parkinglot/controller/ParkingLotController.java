/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkinglot.controller;

import com.parkinglot.bean.Response;
import com.parkinglot.bean.SlotBooking;
import com.parkinglot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author priyank
 */
@RestController
@RequestMapping("parkinglot-service")
public class ParkingLotController {

    @Autowired
    public ParkingLotService parkingLotService;

    @PostMapping("create-parking-lot")
    public ResponseEntity<Response> createParkingLot(
            @RequestParam("totalFloors") Integer totalFloors,
            @RequestParam("perFloorSlots") Integer perFloorSlots) {
        Response response = parkingLotService.createParkingLot(
                totalFloors, perFloorSlots);
        return ResponseEntity.status(
                HttpStatus.valueOf(response.getStatusCode())).body(response);
    }

    @PostMapping("park-vehicle")
    public ResponseEntity parkVehicle(@RequestBody SlotBooking slotBooking) {
        Response response = parkingLotService.createTicket(slotBooking);
        return ResponseEntity.status(
                HttpStatus.valueOf(response.getStatusCode())).body(response);

    }

    @PostMapping("unpark-vehicle")
    public ResponseEntity unparkVehicle(
            @RequestParam("ticketId") String ticketId) {
        Response response = parkingLotService.unparkVehicle(ticketId);
        return ResponseEntity.status(
                HttpStatus.valueOf(response.getStatusCode())).body(response);
    }

}
