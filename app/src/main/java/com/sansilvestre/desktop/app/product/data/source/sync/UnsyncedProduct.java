package com.sansilvestre.desktop.app.product.data.source.sync;

import com.sansilvestre.desktop.app.product.data.source.sync.UnsyncedProductDatabase;
import com.sansilvestre.desktop.app.util.data.sync.UnsyncedTaskType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UnsyncedProduct {

    int id;
    String barcode;
    UnsyncedTaskType type;
    LocalDateTime createdAt;

    public UnsyncedProduct(ResultSet result) throws SQLException {
        id = result.getInt(UnsyncedProductDatabase.ID.getColumnName());
        barcode = result.getString(UnsyncedProductDatabase.BARCODE.getColumnName());
        type = UnsyncedTaskType.valueOf(result.getString(UnsyncedProductDatabase.TYPE.getColumnName()));
        createdAt = result.getTimestamp(UnsyncedProductDatabase.CREATED_AT.getColumnName()).toLocalDateTime();
    }

    public UnsyncedProduct(String barcode, UnsyncedTaskType type) {
        this.barcode = barcode;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public UnsyncedTaskType getType() {
        return type;
    }

}