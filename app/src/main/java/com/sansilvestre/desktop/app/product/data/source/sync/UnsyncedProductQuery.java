package com.sansilvestre.desktop.app.product.data.source.sync;

public class UnsyncedProductQuery {

    public static final String SELECT_UNSYNCED_PRODUCTS =
            "SELECT * FROM unsynced_products ORDER BY created_at ASC;";

    public static final String ADD_UNSYNCED_PRODUCT_IN_QUEUE =
            "INSERT INTO unsynced_products (barcode, type) VALUES (?, ?);";

    public static final String DELETE_UNSYNCED_PRODUCT_OF_QUEUE_BY_ID =
            "DELETE FROM unsynced_products WHERE id = ?;";

}