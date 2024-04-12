package com.sansilvestre.desktop.app.product.main.data.source;

public class ProductQuery {

    public static final String SELECT_PRODUCTS =
            "SELECT * FROM products";

    public static final String SELECT_PRODUCT_BY_LABEL_OR_BARCODE =
            "SELECT * FROM products WHERE label LIKE ? OR barcode LIKE ?";

    public static final String SELECT_PRODUCT_BY_BARCODE =
            "SELECT * FROM products WHERE barcode = ?";

    public static final String INSERT_PRODUCT =
            "INSERT INTO products (barcode, label, cost, category, stock, hasAdditionalTaxes, UID, OID, addedDate, updatedDate, isActive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

}