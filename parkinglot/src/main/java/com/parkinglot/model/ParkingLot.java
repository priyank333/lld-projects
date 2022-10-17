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

public class ParkingLot implements Serializable {
    

    private String parkingLotId;
    private List<Floor> floors;

    public ParkingLot() {
    }
    public ParkingLot(String parkingLotId, List<Floor> floors) {
        this.parkingLotId = parkingLotId;
        this.floors = floors;
    }
    
    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "ParkingLot{" + "parkingLotId=" + parkingLotId 
                + ", floors=" + floors + '}';
    }
    
    
    
}
