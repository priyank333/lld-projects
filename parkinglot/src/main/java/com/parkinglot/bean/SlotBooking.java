/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkinglot.bean;

/**
 *
 * @author priyank
 */
public class SlotBooking {

    private VehicleType vehicleType;
    private String color;
    private String registrationNo;
    private String parkingLotId;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    @Override
    public String toString() {
        return "SlotBooking{" + "vehicleType=" + vehicleType 
                + ", color=" + color 
                + ", registrationNo=" + registrationNo 
                + ", parkingLotId=" + parkingLotId + '}';
    }
    
    

}
