package com.sansilvestre.desktop.app.product.data.source;

public enum ProductDatabase {

    BARCODE(1, "barcode"),
    NAME(2, "name"),
    SPENT(3, "spent"),
    UNITS(4, "units"),
    TAXES(5, "taxes"),
    STOCK(6, "stock"),
    CATEGORY_ID(7, "category_id"),
    USER_ID(8, "user_id"),
    BRANCH_ID(9, "branch_id"),
    ADDED_DATE(10, "added_date"),
    UPDATED_DATE(11, "updated_date");

    private final int index;
    private final String columnName;

    ProductDatabase(int index, String columnName) {
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