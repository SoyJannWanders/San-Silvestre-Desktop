package com.sansilvestre.desktop.app.product.domain.model;

public enum Category {

    FURNITURE("Furniture"),
    APPLIANCES("Appliances"),
    ELECTRONICS("Electronics"),
    FOOD("Food"),
    TOYS("Toys");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}