package com.sansilvestre.desktop.app.product.domain.util.structure;

import com.sansilvestre.desktop.app.product.domain.model.Product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductList {

    public static List<Product> of(ResultSet result) throws Exception {
        List<Product> list = new ArrayList<>();
        while (result.next()) {
            list.add(new Product(result));
        }
        return list;
    }

}