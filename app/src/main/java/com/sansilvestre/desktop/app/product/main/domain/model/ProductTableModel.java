package com.sansilvestre.desktop.app.product.main.domain.model;

public class ProductTableModel {

    private String barcode;
    private String name;
    private String cost;
    private String profit;
    private String price;
    private String roundedPrice;
    private String category;
    private String stock;

    public ProductTableModel setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public String getBarcode() {
        return barcode;
    }

    public ProductTableModel setName(String name) {
        this.name = name;
        return this;
    }
    public String getName() {
        return name;
    }

    public ProductTableModel setCost(String cost) {
        this.cost = cost;
        return this;
    }

    public String getCost() {
        return cost;
    }

    public ProductTableModel setProfit(String profit) {
        this.profit = profit;
        return this;
    }

    public String getProfit() {
        return profit;
    }

    public ProductTableModel setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public ProductTableModel setRoundedPrice(String roundedPrice) {
        this.roundedPrice = roundedPrice;
        return this;
    }

    public String getRoundedPrice() {
        return roundedPrice;
    }

    public ProductTableModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductTableModel setStock(int stock) {
        this.stock = String.valueOf(stock);
        return this;
    }

    public String getStock() {
        return stock;
    }

}