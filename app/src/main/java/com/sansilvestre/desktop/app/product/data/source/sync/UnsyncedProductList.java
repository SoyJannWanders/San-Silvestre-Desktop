package com.sansilvestre.desktop.app.product.data.source.sync;

import com.sansilvestre.desktop.app.product.data.source.sync.UnsyncedProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnsyncedProductList {

    public static List<UnsyncedProduct> valueOf(ResultSet result) throws SQLException {
        final List<UnsyncedProduct> unsyncedProducts = new ArrayList<>();
        while (result.next()) {
            unsyncedProducts.add(new UnsyncedProduct(result));
        }
        return unsyncedProducts;
    }

}