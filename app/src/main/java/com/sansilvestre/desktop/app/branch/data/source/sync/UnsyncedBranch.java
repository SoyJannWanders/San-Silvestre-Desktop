package com.sansilvestre.desktop.app.branch.data.source.sync;

import com.sansilvestre.desktop.app.product.data.source.sync.UnsyncedProductDatabase;
import com.sansilvestre.desktop.app.util.data.sync.UnsyncedTaskType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UnsyncedBranch {

    private int id;
    private int branchId;
    private UnsyncedTaskType type;
    private LocalDateTime createdAt;

    public UnsyncedBranch(ResultSet result) throws SQLException {
        id = result.getInt(UnsyncedProductDatabase.ID.getColumnName());
        branchId = result.getInt(UnsyncedProductDatabase.BARCODE.getColumnName());
        type = UnsyncedTaskType.valueOf(result.getString(UnsyncedProductDatabase.TYPE.getColumnName()));
        createdAt = result.getTimestamp(UnsyncedProductDatabase.CREATED_AT.getColumnName()).toLocalDateTime();
    }

    public UnsyncedBranch(int id, UnsyncedTaskType type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBranchId() {
        return branchId;
    }

    public UnsyncedTaskType getType() {
        return type;
    }

}