/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkinglot.dao;

import com.parkinglot.bean.Slot;
import com.parkinglot.bean.Ticket;
import com.parkinglot.bean.VehicleType;
import com.parkinglot.sql.SqlQueries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author priyank
 */
@Repository
public class ParkingLotDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SqlQueries sqlQueries;

    @Transactional
    public boolean addParkingLot(String parkingLotId) {
        return jdbcTemplate.update(sqlQueries.addParkingLot, parkingLotId) == 1;
    }

    @Transactional
    public boolean addSlots(List<Slot> slots) {
        int[] result = jdbcTemplate.batchUpdate(sqlQueries.addSlot, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Slot slot = slots.get(i);
                ps.setString(1, slot.getSlotId());
                ps.setString(2, slot.getParkingLotId());
                ps.setInt(3, slot.getSlotSeqNo());
                ps.setInt(4, slot.getFloorNo());
                ps.setString(5, slot.getVehicleType().name());
                ps.setBoolean(6, slot.getIsOccupied());
            }

            @Override
            public int getBatchSize() {
                return slots.size();
            }
        });
        int successCount = 0;
        for (int eachRowRes : result) {
            if (eachRowRes == 1) {
                successCount++;
            }
        }
        return successCount == slots.size();
    }

    @Transactional
    public boolean addTicket(Ticket ticket) {
        return jdbcTemplate.update(sqlQueries.addTicket, new Object[]{
            ticket.getTicketId(),
            ticket.getSlot().getSlotId(),
            ticket.getParkedTime(),
            ticket.getUnparkedTime(),
            ticket.getRegistrationNo(),
            ticket.getColor()}) == 1;

    }

    public void updateUnParkedTime(String ticketId, Timestamp unparkedTime) {

    }

    @Transactional
    public boolean updateSlotOccupancy(String slotId, boolean isOccupied) {
        return jdbcTemplate.update(
                sqlQueries.updateSlotOccupancy,
                isOccupied,
                slotId) == 1;
    }

    public Slot retrieveSlotForBooking(String parkingPlotId, VehicleType vehicleType) {
        return jdbcTemplate.query(sqlQueries.retrieveSlotForBooking,
                new Object[]{parkingPlotId, vehicleType.toString()}, (ResultSet rs) -> {

            if (rs.next()) {
                Slot slot = new Slot();
                slot.setSlotId(rs.getString(1));
                slot.setFloorNo(rs.getInt(2));
                slot.setIsOccupied(rs.getBoolean(3));
                slot.setParkingLotId(rs.getString(4));
                slot.setSlotSeqNo(rs.getInt(5));
                slot.setVehicleType(VehicleType.valueOf(rs.getString(6)));
                return slot;
            } else {
                return null;
            }
        });
    }

    public Slot retrieveSlotById(String slotId) {
        return jdbcTemplate.query(sqlQueries.retrieveSlotBySlotId,
                new Object[]{slotId}, (ResultSet rs) -> {

                    if (rs.next()) {
                        Slot slot = new Slot();
                        slot.setSlotId(rs.getString(1));
                        slot.setFloorNo(rs.getInt(2));
                        slot.setIsOccupied(rs.getBoolean(3));
                        slot.setParkingLotId(rs.getString(4));
                        slot.setSlotSeqNo(rs.getInt(5));
                        slot.setVehicleType(VehicleType.valueOf(rs.getString(6)));
                        return slot;
                    } else {
                        return null;
                    }
                });
    }

    public String retrieveSlotIdByTicketId(String ticketId) {
        return jdbcTemplate.queryForObject(
                sqlQueries.getSlotIdByTicketId,
                new Object[]{ticketId}, String.class);
    }

    @Transactional
    public boolean updateTicketUnparkedTime(String ticketId) {
        return jdbcTemplate.update(
                sqlQueries.updateTicketUnparkedTime,
                Timestamp.from(Instant.now()), ticketId) == 1;
    }

}
