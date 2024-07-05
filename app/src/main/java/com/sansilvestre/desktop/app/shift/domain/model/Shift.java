package com.sansilvestre.desktop.app.shift.domain.model;

import com.sansilvestre.desktop.app.shift.data.source.ShiftDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class Shift {

    private int id;
    private String name;
    private int checkoutId;
    private LocalTime startTime;
    private LocalTime endTime;

    public Shift() {}

    public Shift(int id, String name, int checkoutId, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.name = name;
        this.checkoutId = checkoutId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Shift of(ResultSet result) throws Exception {
        return new Shift(
                result.getInt(ShiftDatabase.ID.getColumnName()),
                result.getString(ShiftDatabase.NAME.getColumnName()),
                result.getInt(ShiftDatabase.CHECKOUT_ID.getColumnName()),
                result.getTime(ShiftDatabase.START_TIME.getColumnName()).toLocalTime(),
                result.getTime(ShiftDatabase.END_TIME.getColumnName()).toLocalTime()
        );
    }

    public void populateStatement(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setInt(2, checkoutId);
        statement.setObject(3, startTime);
        statement.setObject(4, endTime);
    }

    @Override
    public String toString() {
        return name + " - Caja " + checkoutId + ": " + startTime + " - " + endTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(int checkoutId) {
        this.checkoutId = checkoutId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

}