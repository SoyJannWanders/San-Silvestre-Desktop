package com.sansilvestre.desktop.app.session.data.source;

public enum SessionDatabase {

    ID(1, "id"),
    ID_CHECKOUT(2, "checkout_id"),
    OPEN_TIME(3, "open_time"),
    CLOSE_TIME(4, "close_time"),
    STATUS(5, "status");

    private final int index;
    private final String columnName;

    SessionDatabase(int index, String columnName) {
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