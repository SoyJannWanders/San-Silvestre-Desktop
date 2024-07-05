package com.sansilvestre.desktop.app.product.data.source.sync;

public enum UnsyncedProductDatabase {

    ID(1, "id"),
    BARCODE(2, "barcode"),
    TYPE(3, "type"),
    CREATED_AT(4, "created_at");

    private final int index;
    private final String columnName;

    UnsyncedProductDatabase(int index, String columnName) {
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