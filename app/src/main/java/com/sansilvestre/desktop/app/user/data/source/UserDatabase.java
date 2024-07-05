package com.sansilvestre.desktop.app.user.data.source;

public enum UserDatabase {
    ID(1, "id"),
    NAME(2, "name"),
    SURNAME(3, "surname"),
    PASSWORD(4, "password"),
    PHONE(5, "phone"),
    SALARY(6, "salary"),
    ROLE(7, "role"),
    OFFICE(8, "branch_id"),
    ADDED_DATE(9, "added_date"),
    UPDATED_DATE(10, "updated_date");

    private final int index;
    private final String columnName;

    UserDatabase(int index, String columnName) {
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