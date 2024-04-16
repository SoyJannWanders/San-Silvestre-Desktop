package com.sansilvestre.desktop.app.product.domain.model;

import com.sansilvestre.desktop.app.product.add.domain.util.Currency;

import java.time.LocalDate;

public class Product {

    private String barcode;
    private String label;
    private LocalDate addedDate;
    private LocalDate updatedDate;
    private Category category;
    private int stock;
    private int UID;
    private int OID;
    private double cost;
    private boolean hasAdditionalTaxes;
    private boolean isActive = true;

    public String toString() {
        String product = "" +
                "Producto:" +
                "\nBarcode: " + barcode +
                "\nLabel: " + label +
                "\nCost: " + cost +
                "\nCategory: " + category +
                "\nStock: " + stock +
                "\nHas Additional Taxes: " + hasAdditionalTaxes +
                "\nUID: " + UID +
                "\nOID: " + OID +
                "\nAdded Date: " + addedDate +
                "\nUpdated Date: " + updatedDate +
                "\nIs Active: " + isActive;
        return product;
    }

    public Product setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }
    
    public String getBarcode() {
        return barcode;
    }
    
    public Product setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Product setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
        return this;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public Product setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public Product setCategory(String category) {
        if (category.equals(Category.FURNITURE.getValue()))
            this.category = Category.FURNITURE;
        if (category.equals(Category.APPLIANCES.getValue()))
            this.category = Category.APPLIANCES;
        if (category.equals(Category.ELECTRONICS.getValue()))
            this.category = Category.ELECTRONICS;
        if (category.equals(Category.FOOD.getValue()))
            this.category = Category.FOOD;
        if (category.equals(Category.TOYS.getValue()))
            this.category = Category.TOYS;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public Product setStock(String stock) {
        this.stock = Integer.parseInt(stock);
        return this;
    }

    public int getStock() {
        return stock;
    }

    public Product setUID(int UID) {
        this.UID = UID;
        return this;
    }

    public int getUID() {
        return UID;
    }

    public Product setOID(int OID) {
        this.OID = OID;
        return this;
    }

    public int getOID() {
        return OID;
    }

    public Product setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public Product setCost(String cost) {
        this.cost = Double.parseDouble(Currency.removeFormat(cost));
        return this;
    }

    public double getCost() {
        return cost;
    }

    public Product setAdditionalTaxes(boolean hasAdditionalTaxes) {
        this.hasAdditionalTaxes = hasAdditionalTaxes;
        return this;
    }

    public boolean hasAdditionalTaxes() {
        return hasAdditionalTaxes;
    }

    public boolean isActive() {
        return isActive;
    }

}