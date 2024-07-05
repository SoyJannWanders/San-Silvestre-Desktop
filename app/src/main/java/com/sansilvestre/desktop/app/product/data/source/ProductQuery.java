package com.sansilvestre.desktop.app.product.data.source;

import com.sansilvestre.desktop.app.util.objects.Stock;

public class ProductQuery {

    public static final String SELECT_DATABASE_TIMESTAMP =
            "SELECT updated_date FROM products WHERE barcode = ?;";

    public static final String SELECT_PRODUCTS =
            "SELECT * FROM products ORDER BY name;";

    public static final String SELECT_PRODUCTS_BY_SEARCH =
            "SELECT * FROM products WHERE name LIKE ? OR barcode LIKE ? ORDER BY CASE " +
                    "WHEN name = ? THEN 1 " + // '?'
                    "WHEN barcode = ? THEN 2 " + // '?'
                    "WHEN name LIKE ? THEN 3 " + // '?%'
                    "WHEN barcode LIKE ? THEN 4 " + // '?%'
                    "ELSE 5 END, name;";

    public static final String SELECT_PRODUCTS_WITHOUT_STOCK =
            "SELECT * FROM products WHERE stock = 0 ORDER BY name;";

    public static final String SELECT_PRODUCTS_WITH_STOCK =
            "SELECT * FROM products WHERE stock > 0 ORDER BY name;";

    public static final String SELECT_PRODUCTS_BY_CATEGORY_ID =
            "SELECT * FROM products WHERE category_id = ? ORDER BY name;";

    public static final String SELECT_PRODUCTS_BY_OFFICE_ID =
            "SELECT * FROM products WHERE branch_id = ? ORDER BY name;";

    public static final String SELECT_PRODUCT_BY_BARCODE =
            "SELECT * FROM products WHERE barcode = ?;";

    public static final String INSERT_PRODUCT =
            "INSERT INTO products (barcode, name, spent, units, taxes, stock, category_id, user_id, branch_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public static final String SYNC_INSERT_PRODUCT =
            "INSERT INTO products (barcode, name, spent, units, taxes, stock, category_id, user_id, branch_id, added_date, updated_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public static final String UPDATE_PRODUCT =
            "UPDATE products SET name = ?, spent = ?, units = ?, taxes = ?, stock = ?, category_id = ?, user_id = ? WHERE barcode = ?;";

    public static final String SYNC_UPDATE_PRODUCT =
            "UPDATE products SET name = ?, spent = ?, units = ?, taxes = ?, stock = ?, category_id = ?, user_id = ?, updated_date = ? WHERE barcode = ?;";

    public static final String UPDATE_PRODUCT_PRICES =
            "UPDATE products SET spent = spent * ?;";

    public static final String UPDATE_PRODUCT_STOCK_BY_ITEM_UNITS =
            "UPDATE products SET stock = stock - ? WHERE barcode = ?;";

    public static final String UPDATE_PRODUCT_PRICES_BY_CATEGORY =
            "UPDATE products SET spent = spent * ? WHERE category_id = ?;";

    public static final String UPDATE_PRODUCT_PRICES_BY_OFFICE =
            "UPDATE products SET spent = spent * ? WHERE branch_id = ?;";

    public static final String DELETE_PRODUCT =
            "DELETE FROM products WHERE barcode = ?;";

    public static String getGetProductListByStockQuery(Stock stock) {
        switch (stock) {
            case WITH_STOCK -> {
                return SELECT_PRODUCTS_WITH_STOCK;
            }
            case WITHOUT_STOCK -> {
                return SELECT_PRODUCTS_WITHOUT_STOCK;
            }
            default -> {
                return SELECT_PRODUCTS;
            }
        }
    }

}