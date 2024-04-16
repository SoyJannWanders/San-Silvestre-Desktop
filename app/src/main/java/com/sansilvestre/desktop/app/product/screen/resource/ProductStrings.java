package com.sansilvestre.desktop.app.product.screen.resource;

import com.sansilvestre.desktop.app.Language;

import java.util.ResourceBundle;

public class ProductStrings {

    private static final String FILE = "Product.ProductStrings";
    private static final String ROUTE = Language.getStringLanguage() + FILE;

    private static final ResourceBundle RESOURCES = ResourceBundle.getBundle(ROUTE);

    private static final String ACTIVE_ITEM_FILTER = "activeItemFilter";
    private static final String INACTIVE_ITEM_FILTER = "inactiveItemFilter";

    private static final String CATEGORY_ITEM_FILTER = "categoryItemFilter";

    private static final String OFFICE_ITEM_FILTER = "officeItemFilter";

    private static final String UPDATE_PRICE_BUTTON = "updatePrice";
    private static final String UPDATE_STOCK_BUTTON = "updateStock";

    public static String getSentence() {
        return RESOURCES.getString("sentence");
    }

    public static String getSection() {
        return RESOURCES.getString("section");
    }

    public static String getSearchPlaceholder() {
        return RESOURCES.getString("searchPlaceholder");
    }

    public static String getActiveItemFilter() {
        return RESOURCES.getString(ACTIVE_ITEM_FILTER);
    }

    public static String getInactiveItemFilter() {
        return RESOURCES.getString(INACTIVE_ITEM_FILTER);
    }

    public static String getCategoryItemFilter() {
        return RESOURCES.getString(CATEGORY_ITEM_FILTER);
    }

    public static String getOfficeItemFilter() {
        return RESOURCES.getString(OFFICE_ITEM_FILTER);
    }

    public static String getUpdateStockButton() {
        return RESOURCES.getString(UPDATE_STOCK_BUTTON);
    }

    public static String getUpdatePriceButton() {
        return RESOURCES.getString(UPDATE_PRICE_BUTTON);
    }

}