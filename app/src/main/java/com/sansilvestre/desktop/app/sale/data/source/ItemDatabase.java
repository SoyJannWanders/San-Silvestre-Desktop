package com.sansilvestre.desktop.app.sale.data.source;

public enum ItemDatabase {

    ID(1, "id"),
    NAME(2, "name"),
    BARCODE(3, "barcode"),
    UNITS(4, "units"),
    PRICE(5, "price"),
    SALE_ID(6, "sale_id");

    private final int index;
    private final String columnName;

    ItemDatabase(int index, String columnName) {
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