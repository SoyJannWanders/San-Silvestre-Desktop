package com.sansilvestre.desktop.app.branch.data.source.sync;

public enum UnsyncedBranchDatabase {

    ID(1, "id"),
    BRANCH_ID(2, "branch_id"),
    TYPE(3, "type"),
    CREATED_AT(4, "created_at");

    private final int index;
    private final String columnName;

    UnsyncedBranchDatabase(int index, String columnName) {
        this.index = index;
        this.columnName = columnName;
    }

    public int getIndex() {
        return index;
    }

    public String getColumnName() {
        return columnName;
    }

}