/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkinglot.service;

import com.parkinglot.bean.Floor;
import com.parkinglot.bean.ParkingLot;
import com.parkinglot.bean.Response;
import com.parkinglot.bean.Slot;
import com.parkinglot.bean.SlotBooking;
import com.parkinglot.bean.Ticket;
import com.parkinglot.bean.VehicleType;
import com.parkinglot.dao.ParkingLotDAO;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author priyank
 */
@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotDAO parkingLotDAO;

    @Transactional
    public Response createParkingLot(int totalFloors, int slotsPerFloor) {
        ParkingLot parkingLot = formParkingLot(totalFloors, slotsPerFloor);
        boolean isAdded = parkingLotDAO.addParkingLot(parkingLot.getParkingLotId());
        System.out.println("ParkingLot insertion response : " + isAdded);
        for (Floor f : parkingLot.getFloors()) {
            isAdded = parkingLotDAO.addSlots(f.getSlots());
            System.out.println("Slot insertion response : " + isAdded);
        }
        return new Response(HttpStatus.CREATED.value(), parkingLot);
    }

    @Transactional
    public Response createTicket(SlotBooking slotBooking) {
        Slot slot;
        boolean isUpdated;
        int iteration = 1;
        do {
            slot = parkingLotDAO.retrieveSlotForBooking(
                    slotBooking.getParkingLotId(),
                    slotBooking.getVehicleType());
            if (slot == null) {
                return new Response(HttpStatus.OK.value(), "No slots available");
            }
            isUpdated = parkingLotDAO.updateSlotOccupancy(slot.getSlotId(), true);
            System.out.println("Is Occupancy Updated : " + isUpdated);
        } while ((iteration <= 3) && (!isUpdated));
        if (!isUpdated) {
            return new Response(HttpStatus.OK.value(), "No slots available");
        }
        Ticket ticket = createTicket(slotBooking, slot);
        isUpdated = parkingLotDAO.addTicket(ticket);
        System.out.println("Is Ticket added : " + isUpdated);
        return new Response(HttpStatus.OK.value(), ticket);
    }

    private Ticket createTicket(SlotBooking slotBooking, Slot slot) {
        Ticket ticket = new Ticket();
        ticket.setColor(slotBooking.getColor());
        ticket.setParkedTime(Timestamp.from(Instant.now()));
        ticket.setRegistrationNo(slotBooking.getRegistrationNo());
        ticket.setSlot(slot);
        ticket.setTicketId(UUID.randomUUID().toString());
        ticket.setUnparkedTime(null);
        return ticket;
    }

    private ParkingLot formParkingLot(int totalFloors, int slotsPerFloor) {
        String parkingLotId = UUID.randomUUID().toString();
        List<Floor> floors = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot(parkingLotId, floors);
        int totalSlots = totalFloors * slotsPerFloor;
        int slotCount = 1, floorCount = 1;
        Floor floor;
        Slot slot;
        List<Slot> slots = null;
        for (int iter = 1; iter <= totalSlots; iter++) {

            if (slotCount == 1) {
                slots = new ArrayList<>();
                floor = new Floor(parkingLotId, floorCount, slots);
                floors.add(floor);
            }

            slot = createSlot(floorCount, parkingLotId, slotCount);

            if (slots != null && slot != null) {
                slots.add(slot);
                slotCount++;
            }

            if (slotCount > slotsPerFloor) {
                floorCount++;
                slotCount = 1;
            }
        }
        return parkingLot;
    }

    private Slot createSlot(int floorCount, String parkingLotId, int slotCount) {
        Slot slot = new Slot();
        slot.setSlotId(UUID.randomUUID().toString());
        slot.setFloorNo(floorCount);
        slot.setIsOccupied(Boolean.FALSE);
        slot.setParkingLotId(parkingLotId);
        slot.setSlotSeqNo(slotCount);
        if (slotCount == 1) {
            slot.setVehicleType(VehicleType.TRUCK);
        } else if (slotCount > 1 && slotCount < 4) {
            slot.setVehicleType(VehicleType.BIKE);
        } else {
            slot.setVehicleType(VehicleType.CAR);
        }
        return slot;

    }

    @Transactional
    public Response unparkVehicle(String ticketId) {
        String slotId = parkingLotDAO.retrieveSlotIdByTicketId(ticketId);
        System.out.println("SlotId : " +slotId);
        if (slotId != null) {
            boolean isSuccess = parkingLotDAO.updateTicketUnparkedTime(
                    ticketId);
            if (isSuccess) {

                isSuccess = parkingLotDAO.updateSlotOccupancy(
                        slotId, 
                        false);
                if (isSuccess) {
                    return new Response(
                            HttpStatus.OK.value(),
                            "Vehicle is unparked");
                } else {
                    return new Response(
                            HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "Something went wrong");
                }

            } else {
                return new Response(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Something went wrong");
            }
        } else {
            return new Response(HttpStatus.OK.value(),
                    "Booking is not exist");
        }
    }

}
