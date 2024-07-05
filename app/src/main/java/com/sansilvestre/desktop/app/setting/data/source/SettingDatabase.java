package com.sansilvestre.desktop.app.setting.data.source;

public enum SettingDatabase {

    ID(1, "id"),
    BRANCH_ID(2, "branch_id"),
    BRANCH_NAME(-1, "branch_name"),
    PERCENTAGE_PROFIT(3, "percentage_profit"),
    PERCENTAGE_DISCOUNT_CASH(4, "percentage_discount_cash"),
    THEME(3, "theme");

    private final int index;
    private final String columnName;

    SettingDatabase(int index, String columnName) {
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