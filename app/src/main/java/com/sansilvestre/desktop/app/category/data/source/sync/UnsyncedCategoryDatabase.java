package com.sansilvestre.desktop.app.category.data.source.sync;

public enum UnsyncedCategoryDatabase {

    ID(1, "id"),
    BRANCH_ID(2, "category_id"),
    TYPE(3, "type"),
    CREATED_AT(4, "created_at");

    private final int index;
    private final String columnName;

    UnsyncedCategoryDatabase(int index, String columnName) {
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