package com.sansilvestre.desktop.app.product.add.domain.util;

import com.sansilvestre.desktop.app.product.domain.model.Product;

public class VerifyProduct {

    public static boolean isValid(Product product) {
        return true;
    }

    private boolean isNotEmpty(String string) {
        return !string.isEmpty() || !string.isBlank();
    }

}