package com.sansilvestre.desktop.app.category.domain.model;

import com.sansilvestre.desktop.app.category.data.source.CategoryDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Category {

    private int id;
    private String name;
    private double increase;
    private LocalDateTime addedDate;
    private LocalDateTime updatedDate;

    public Category(ResultSet result) throws SQLException {
        id = result.getInt(CategoryDatabase.ID.getColumnName());
        name = result.getString(CategoryDatabase.NAME.getColumnName());
        increase = result.getDouble(CategoryDatabase.INCREASE.getColumnName());
        addedDate = result.getTimestamp(CategoryDatabase.ADDED_DATE.getColumnName()).toLocalDateTime();
        updatedDate = result.getTimestamp(CategoryDatabase.UPDATED_DATE.getColumnName()).toLocalDateTime();
    }

    public Category(String name, double increase) {
        this.name = name;
        this.increase = increase;
    }

    public void populateStatement(PreparedStatement statement) throws Exception {
        statement.setString(1, name);
        statement.setDouble(2, increase);
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

    public double getIncrease() {
        return increase;
    }

    public void setIncrease(double increase) {
        this.increase = increase;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

}