package com.sansilvestre.desktop.app.shift.data.source;

public enum ShiftDatabase {

    ID(1, "id"),
    NAME(2, "name"),
    CHECKOUT_ID(3, "checkout_id"),
    START_TIME(4, "start_time"),
    END_TIME(5, "end_time");

    private final int index;
    private final String columnName;

    ShiftDatabase(int index, String columnName) {
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