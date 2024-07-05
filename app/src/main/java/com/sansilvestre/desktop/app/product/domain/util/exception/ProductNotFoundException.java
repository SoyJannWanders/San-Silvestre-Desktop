package com.sansilvestre.desktop.app.product.domain.util.exception;

public class ProductNotFoundException extends Exception {

    private final String ID = "PRODUCT_NOT_FOUND";
    private final String cause = "";
    private final String message = "";

    public ProductNotFoundException() {
        super();
    }

}