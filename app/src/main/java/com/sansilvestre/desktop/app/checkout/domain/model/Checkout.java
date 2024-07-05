package com.sansilvestre.desktop.app.checkout.domain.model;

import com.sansilvestre.desktop.app.checkout.data.source.CheckoutDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Checkout {

    private int id;
    private String name;
    private int branchId;

    public Checkout() {}

    public Checkout(ResultSet result) throws SQLException {
        id = result.getInt(CheckoutDatabase.ID.getColumnName());
        name = result.getString(CheckoutDatabase.NAME.getColumnName());
        branchId = result.getInt(CheckoutDatabase.BRANCH_ID.getColumnName());
    }

    public void populateStatement(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setInt(2, branchId);
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

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

}