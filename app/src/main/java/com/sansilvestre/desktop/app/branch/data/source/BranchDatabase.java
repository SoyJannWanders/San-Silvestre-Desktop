package com.sansilvestre.desktop.app.branch.data.source;

public enum BranchDatabase {

    ID(1, "id"),
    NAME(2, "name"),
    ADDRESS(3, "address"),
    USER_ID(4, "user_id"),
    ADDED_DATE(5, "added_date"),
    UPDATED_DATE(6, "updated_date");

    private final int index;
    private final String columnName;

    BranchDatabase(int index, String columnName) {
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