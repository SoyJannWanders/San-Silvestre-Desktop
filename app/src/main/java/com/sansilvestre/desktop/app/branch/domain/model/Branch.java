package com.sansilvestre.desktop.app.branch.domain.model;

import com.sansilvestre.desktop.app.branch.data.source.BranchDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Branch {

    private int id;
    private String name;
    private String address;
    private int userId;
    private LocalDateTime addedDate;
    private LocalDateTime updatedDate;

    public Branch(ResultSet result) throws SQLException {
        id = result.getInt(BranchDatabase.ID.getColumnName());
        name = result.getString(BranchDatabase.NAME.getColumnName());
        address = result.getString(BranchDatabase.ADDRESS.getColumnName());
        userId = result.getInt(BranchDatabase.USER_ID.getColumnName());
        addedDate = result.getTimestamp(BranchDatabase.ADDED_DATE.getColumnName()).toLocalDateTime();
        updatedDate = result.getTimestamp(BranchDatabase.UPDATED_DATE.getColumnName()).toLocalDateTime();
    }

    public Branch(String name, String address, int userId) {
        this.name = name;
        this.address = address;
        this.userId = userId;
    }

    public void populateStatementForAdd(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setString(2, address);
        statement.setInt(3, userId);
    }

    public void populateStatementForSyncAdd(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setString(2, address);
        statement.setInt(3, userId);
        statement.setObject(4, addedDate);
        statement.setObject(5, updatedDate);
    }

    public void populateStatementForUpdate(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setString(2, address);
        statement.setInt(3, userId);
        statement.setInt(4, id);
    }

    public void populateStatementForSyncUpdate(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setString(2, address);
        statement.setInt(3, userId);
        statement.setObject(4, updatedDate);
        statement.setInt(5, id);
    }

    @Override
    public String toString() {
        return name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

}