package com.sansilvestre.desktop.app.product.screen.resource;

import com.sansilvestre.desktop.app.Language;

import java.util.ResourceBundle;

public class ProductStrings {

    private static final String PRODUCT_FILE = "Product.ProductStrings";
    private static final String PRODUCT_ROUTE = Language.getStringLanguage() + PRODUCT_FILE;

    private static final ResourceBundle PRODUCT_STRINGS = ResourceBundle.getBundle(PRODUCT_ROUTE);

    private static final String UPDATE_PRICE_BUTTON = "updatePrice";
    private static final String UPDATE_STOCK_BUTTON = "updateStock";

    public static String getSentence() {
        return PRODUCT_STRINGS.getString("sentence");
    }

    public static String getSection() {
        return PRODUCT_STRINGS.getString("section");
    }

    public static String getSearchPlaceholder() {
        return PRODUCT_STRINGS.getString("searchPlaceholder");
    }

    public static String getUpdateStockButton() {
        return PRODUCT_STRINGS.getString(UPDATE_STOCK_BUTTON);
    }

    public static String getUpdatePriceButton() {
        return PRODUCT_STRINGS.getString(UPDATE_PRICE_BUTTON);
    }

}