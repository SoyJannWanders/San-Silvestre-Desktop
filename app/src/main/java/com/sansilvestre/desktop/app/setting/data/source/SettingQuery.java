package com.sansilvestre.desktop.app.setting.data.source;

public class SettingQuery {

    public static final String GET_SETTING =
            "SELECT s.id, s.branch_id, s.percentage_profit, s.percentage_discount_cash, s.theme, b.name AS branch_name FROM settings s JOIN branches b ON s.branch_id = b.id;";

    public static final String INSERT_SETTING =
            "INSERT INTO settings (branch_id, percentage_profit, percentage_discount_cash, theme) VALUES (?, ?, ?, ?);";

    public static final String UPDATE_SETTING =
            "";

}