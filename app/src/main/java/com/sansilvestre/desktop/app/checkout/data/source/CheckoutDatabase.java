package com.sansilvestre.desktop.app.checkout.data.source;

public enum CheckoutDatabase {

    ID(1, "id"),
    NAME(2, "name"),
    BRANCH_ID(3, "branch_id");

    private final int index;
    private final String columnName;

    CheckoutDatabase(int index, String columnName) {
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