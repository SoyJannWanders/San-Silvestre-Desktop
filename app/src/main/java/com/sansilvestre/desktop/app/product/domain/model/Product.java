package com.sansilvestre.desktop.app.product.domain.model;

import com.sansilvestre.desktop.app.product.data.source.ProductDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Product {

    private String barcode;
    private String name;
    private double spent;
    private int units;
    private double taxes;
    private int stock;
    private int categoryId;
    private int userId;
    private int branchId;
    private LocalDateTime addedDate;
    private LocalDateTime updatedDate;

    public Product(ResultSet result) throws SQLException {
        barcode = result.getString(ProductDatabase.BARCODE.getColumnName());
        name = result.getString(ProductDatabase.NAME.getColumnName());
        spent = result.getDouble(ProductDatabase.SPENT.getColumnName());
        units = result.getInt(ProductDatabase.UNITS.getColumnName());
        taxes = result.getDouble(ProductDatabase.TAXES.getColumnName());
        stock = result.getInt(ProductDatabase.STOCK.getColumnName());
        categoryId = result.getInt(ProductDatabase.CATEGORY_ID.getColumnName());
        userId = result.getInt(ProductDatabase.USER_ID.getColumnName());
        branchId = result.getInt(ProductDatabase.BRANCH_ID.getColumnName());
        addedDate = result.getTimestamp(ProductDatabase.ADDED_DATE.getColumnName()).toLocalDateTime();
        updatedDate = result.getTimestamp(ProductDatabase.UPDATED_DATE.getColumnName()).toLocalDateTime();
    }

    public Product(String barcode, String name, double spent, int units, double taxes, int stock, int categoryId, int userId, int branchId) {
        this.barcode = barcode;
        this.name = name;
        this.spent = spent;
        this.units = units;
        this.taxes = taxes;
        this.stock = stock;
        this.categoryId = categoryId;
        this.userId = userId;
        this.branchId = branchId;
    }

    public void populateStatementForAdd(PreparedStatement statement) throws SQLException {
        statement.setString(1, barcode);
        statement.setString(2, name);
        statement.setDouble(3, spent);
        statement.setDouble(4, units);
        statement.setDouble(5, taxes);
        statement.setInt(6, stock);
        statement.setInt(7, categoryId);
        statement.setInt(8, userId);
        statement.setInt(9, branchId);
    }

    public void populateStatementForSyncAdd(PreparedStatement statement) throws SQLException {
        statement.setString(1, barcode);
        statement.setString(2, name);
        statement.setDouble(3, spent);
        statement.setDouble(4, units);
        statement.setDouble(5, taxes);
        statement.setInt(6, stock);
        statement.setInt(7, categoryId);
        statement.setInt(8, userId);
        statement.setInt(9, branchId);
        statement.setObject(10, addedDate);
        statement.setObject(11, updatedDate);
    }

    public void populateStatementForUpdate(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setDouble(2, spent);
        statement.setDouble(3, units);
        statement.setDouble(4, taxes);
        statement.setInt(5, stock);
        statement.setInt(6, categoryId);
        statement.setInt(7, userId);
        statement.setString(8, barcode);
    }

    public void populateStatementForSyncUpdate(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setDouble(2, spent);
        statement.setDouble(3, units);
        statement.setDouble(4, taxes);
        statement.setInt(5, stock);
        statement.setInt(6, categoryId);
        statement.setInt(7, userId);
        statement.setObject(8, updatedDate);
        statement.setString(9, barcode);
    }
    
    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpent() {
        return spent;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
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