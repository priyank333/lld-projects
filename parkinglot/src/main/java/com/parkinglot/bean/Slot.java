/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkinglot.bean;

import java.io.Serializable;

/**
 *
 * @author priyank
 */
public class Slot implements Serializable {

    private String slotId;
    private String parkingLotId;
    private Integer floorNo;
    private Integer slotSeqNo;
    private VehicleType vehicleType;
    private Boolean isOccupied;

    public Slot() {
    }

    
    public Slot(String slotId) {
        this.slotId = slotId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
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

    public Integer getSlotSeqNo() {
        return slotSeqNo;
    }

    public void setSlotSeqNo(Integer slotSeqNo) {
        this.slotSeqNo = slotSeqNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(Boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    @Override
    public String toString() {
        return "Slot{" + "slotId=" + slotId 
                + ", parkingLotId=" + parkingLotId 
                + ", floorNo=" + floorNo 
                + ", slotSeqNo=" + slotSeqNo 
                + ", vehicleType=" + vehicleType 
                + ", isOccupied=" + isOccupied + '}';
    }
    
    

}
