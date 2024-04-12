package com.sansilvestre.desktop.app.product.screen.resource;

import com.sansilvestre.desktop.app.Language;

import java.util.ResourceBundle;

public class NewProductScreenStrings {

    private static final String STRINGS_FILE = "Product/New";
    private static final String STRINGS_FILE_ROUTE = Language.getStringLanguage() + STRINGS_FILE;

    private  static final ResourceBundle STRINGS = ResourceBundle.getBundle(STRINGS_FILE_ROUTE);

    private static final String HEADLINE = "headline";

    private static final String OFFICE_LABEL = "officeLabel";
    private static final String DATE_LABEL = "dateLabel";

    private static final String PRODUCT_LABEL = "productLabel";
    private static final String PRODUCT_PLACEHOLDER = "productPlaceholder";
    private static final String BARCODE_LABEL = "barcodeLabel";
    private static final String BARCODE_PLACEHOLDER = "barcodePlaceholder";
    private static final String CATEGORY_LABEL = "categoryLabel";
    private static final String PURCHASE_COST_LABEL = "purchaseCostLabel";
    private static final String PURCHASE_COST_PLACEHOLDER = "purchaseCostPlaceholder";
    private static final String STOCK_LABEL = "stockLabel";
    private static final String STOCK_PLACEHOLDER = "stockPlaceholder";
    private static final String TAX_LABEL = "taxLabel";

    private static final String BASE_PRICE_LABEL = "basePriceLabel";
    private static final String UTILITIES_LABEL = "utilitiesLabel";
    private static final String FINAL_PRICE_LABEL = "finalPriceLabel";

    public static String getHeadline() {
        return STRINGS.getString(HEADLINE);
    }

    public static String getOfficeLabel() {
        return STRINGS.getString(OFFICE_LABEL);
    }

    public static String getDateLabel() {
        return STRINGS.getString(DATE_LABEL);
    }

    public static String getProductLabel() {
        return STRINGS.getString(PRODUCT_LABEL);
    }

    public static String getProductPlaceholder() {
        return STRINGS.getString(PRODUCT_PLACEHOLDER);
    }

    public static String getBarcodeLabel() {
        return STRINGS.getString(BARCODE_LABEL);
    }

    public static String getBarcodePlaceholder() {
        return STRINGS.getString(BARCODE_PLACEHOLDER);
    }

    public static String getCategoryLabel() {
        return STRINGS.getString(CATEGORY_LABEL);
    }

    public static String getPurchaseCostLabel() {
        return STRINGS.getString(PURCHASE_COST_LABEL);
    }

    public static String getPurchaseCostPlaceholder() {
        return STRINGS.getString(PURCHASE_COST_PLACEHOLDER);
    }

    public static String getStockLabel() {
        return STRINGS.getString(STOCK_LABEL);
    }

    public static String getStockPlaceholder() {
        return STRINGS.getString(STOCK_PLACEHOLDER);
    }

    public static String getTaxLabel() {
        return STRINGS.getString(TAX_LABEL);
    }

    public static String getBasePriceLabel() {
        return STRINGS.getString(BASE_PRICE_LABEL);
    }

    public static String getUtilitiesLabel() {
        return STRINGS.getString(UTILITIES_LABEL);
    }

    public static String getFinalPriceLabel() {
        return STRINGS.getString(FINAL_PRICE_LABEL);
    }

}