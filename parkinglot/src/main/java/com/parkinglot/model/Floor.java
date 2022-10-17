/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkinglot.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author priyank
 */
public class Floor implements Serializable {
    
    private String parkingLotId;
    private Integer floorNo;
    private List<Slot> slots;

    public Floor() {
    }
    
    public Floor(String parkingLotId, Integer floorNo, List<Slot> slots) {
        this.parkingLotId = parkingLotId;
        this.floorNo = floorNo;
        this.slots = slots;
    }

    
    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "Floor{" + "parkingLotId=" + parkingLotId 
                + ", floorNo=" + floorNo 
                + ", slots=" + slots + '}';
    }
    
    
    
}
