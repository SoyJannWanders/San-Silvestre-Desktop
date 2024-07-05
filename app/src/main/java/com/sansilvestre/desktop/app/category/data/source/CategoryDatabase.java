package com.sansilvestre.desktop.app.category.data.source;

public enum CategoryDatabase {

    ID(1, "id"),
    NAME(2, "name"),
    INCREASE(3, "increase"),
    ADDED_DATE(4, "added_date"),
    UPDATED_DATE(5, "updated_date");

    private final int index;
    private final String columnName;

    CategoryDatabase(int index, String columnName) {
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