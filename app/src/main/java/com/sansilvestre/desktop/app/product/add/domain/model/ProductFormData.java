package com.sansilvestre.desktop.app.product.add.domain.model;

public class ProductFormData {

    private String barcode;
    private String label;
    private String cost;
    private String stock;
    private String category;
    private boolean hasAdditionalTaxes;

    public ProductFormData setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public String getBarcode() {
        return barcode;
    }

    public ProductFormData setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public ProductFormData setCost(String cost) {
        this.cost = cost;
        return this;
    }

    public String getCost() {
        return cost;
    }

    public ProductFormData setStock(String stock) {
        this.stock = stock;
        return this;
    }

    public String getStock() {
        return stock;
    }

    public ProductFormData setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductFormData setAdditionalTaxes(boolean hasAdditionalTaxes) {
        this.hasAdditionalTaxes = hasAdditionalTaxes;
        return this;
    }

    public boolean hasAdditionalTaxes() {
        return hasAdditionalTaxes;
    }

}