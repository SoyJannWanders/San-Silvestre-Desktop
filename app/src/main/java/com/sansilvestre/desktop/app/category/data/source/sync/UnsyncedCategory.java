package com.sansilvestre.desktop.app.category.data.source.sync;

import com.sansilvestre.desktop.app.product.data.source.sync.UnsyncedProductDatabase;
import com.sansilvestre.desktop.app.util.data.sync.UnsyncedTaskType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UnsyncedCategory {

    private int id;
    private int categoryId;
    private UnsyncedTaskType type;
    private LocalDateTime createdAt;

    public UnsyncedCategory(ResultSet result) throws SQLException {
        id = result.getInt(UnsyncedProductDatabase.ID.getColumnName());
        categoryId = result.getInt(UnsyncedProductDatabase.BARCODE.getColumnName());
        type = UnsyncedTaskType.valueOf(result.getString(UnsyncedProductDatabase.TYPE.getColumnName()));
        createdAt = result.getTimestamp(UnsyncedProductDatabase.CREATED_AT.getColumnName()).toLocalDateTime();
    }

    public UnsyncedCategory(int id, UnsyncedTaskType type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public UnsyncedTaskType getType() {
        return type;
    }

}