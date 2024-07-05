package com.sansilvestre.desktop.app.setting.domain.model;

import com.sansilvestre.desktop.app.setting.data.source.SettingDatabase;
import com.sansilvestre.desktop.app.util.ui.Theme;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Setting {

    private static Setting instance;

    private int id;
    private int branchId;
    private String branchName;
    private double percentageProfit;
    private double percentageDiscountCash;
    private Theme theme;

    public Setting(ResultSet result) throws SQLException {
        id = result.getInt(SettingDatabase.ID.getColumnName());
        branchId = result.getInt(SettingDatabase.BRANCH_ID.getColumnName());
        branchName = result.getString(SettingDatabase.BRANCH_NAME.getColumnName());
        percentageProfit = result.getDouble(SettingDatabase.PERCENTAGE_PROFIT.getColumnName());
        percentageDiscountCash = result.getDouble(SettingDatabase.PERCENTAGE_DISCOUNT_CASH.getColumnName());
        theme = Theme.valueOf(result.getString(SettingDatabase.THEME.getColumnName()));
    }

    public Setting(int branchId, double percentageProfit, double percentageDiscountCash, Theme theme) {
        this.branchId = branchId;
        this.percentageProfit = percentageProfit;
        this.percentageDiscountCash = percentageDiscountCash;
        this.theme = theme;
    }

    public static void initializeInstance(ResultSet result) throws SQLException {
        instance = new Setting(result);
    }

    public static Setting getInstance() {
        return instance;
    }

    public void populateStatement(PreparedStatement statement) throws SQLException {
        statement.setInt(1, branchId);
        statement.setDouble(2, percentageProfit);
        statement.setDouble(3, percentageDiscountCash);
        statement.setString(4, theme.name());
    }

    public int getId() {
        return id;
    }

    public int getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public double getPercentageProfit() {
        return percentageProfit;
    }

    public double getPercentageDiscountCash() {
        return percentageDiscountCash;
    }

    public Theme getTheme() {
        return theme;
    }

}