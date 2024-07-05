package com.sansilvestre.desktop.app.product.domain.util.structure;

import com.sansilvestre.desktop.app.product.data.source.ProductDatabase;
import com.sansilvestre.desktop.app.product.domain.model.Product;

import java.sql.ResultSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductMap {

    public static Map<String, Product> of(ResultSet result) throws Exception {
        Map<String, Product> map = new ConcurrentHashMap<>();
        while (result.next()) {
            map.put(result.getString(ProductDatabase.BARCODE.getColumnName()), new Product(result));
        }
        return map;
    }

}