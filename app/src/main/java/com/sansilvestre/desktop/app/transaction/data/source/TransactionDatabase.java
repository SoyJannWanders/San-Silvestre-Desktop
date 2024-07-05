package com.sansilvestre.desktop.app.transaction.data.source;

public enum TransactionDatabase {

    ID(1, "id"),
    SESSION_ID(2, "session_id"),
    CREATED_AT(3, "created_at"),
    CONCEPT(4, "concept"),
    TYPE(5, "type"),
    AMOUNT(6, "amount");

    private final int index;
    private final String columnName;

    TransactionDatabase(int index, String columnName) {
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