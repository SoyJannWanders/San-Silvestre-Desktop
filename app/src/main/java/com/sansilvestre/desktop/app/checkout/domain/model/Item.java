package com.sansilvestre.desktop.app.checkout.domain.model;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.util.formatter.Rounder;
import com.sansilvestre.desktop.app.sale.data.source.ItemDatabase;
import com.sansilvestre.desktop.app.setting.domain.model.Setting;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Item {

    private int id;
    private String name;
    private String barcode;
    private int units = 1;
    private double price;
    private int saleId;

    private int stock;

    public Item(ResultSet result) throws SQLException {
        id = result.getInt(ItemDatabase.ID.getColumnName());
        name = result.getString(ItemDatabase.NAME.getColumnName());
        barcode = result.getString(ItemDatabase.BARCODE.getColumnName());
        units = result.getInt(ItemDatabase.UNITS.getColumnName());
        price = result.getDouble(ItemDatabase.PRICE.getColumnName());
        saleId = result.getInt(ItemDatabase.SALE_ID.getColumnName());
    }

    public Item(Product product) {

        name = product.getName();
        barcode = product.getBarcode();
        price = calculateSalePrice(product.getSpent(), product.getUnits(), product.getTaxes());

        stock = product.getStock();

    }

    public void populateStatement(PreparedStatement statement) throws SQLException {
        statement.setString(1, name);
        statement.setString(2, barcode);
        statement.setInt(3, units);
        statement.setDouble(4, price);
        statement.setInt(5, saleId);
    }

    public double calculateSalePrice(double spent, int units, double taxes) {
        double unitPrice = spent / units;
        double totalTaxes = Setting.getInstance().getPercentageProfit() + taxes;
        double unitPriceWithTaxes = unitPrice * (1 + totalTaxes / 100);
        double price = Rounder.round(unitPriceWithTaxes);
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getPrice() {
        return price;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getStock() {
        return stock;
    }

}