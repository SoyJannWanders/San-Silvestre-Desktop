package com.sansilvestre.desktop.app.product.main.data.parser;

import com.sansilvestre.desktop.app.product.domain.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductListParser {

    public static List<Product> parse(ResultSet results) throws SQLException {
        List<Product> list = new ArrayList<>();
        while (results.next()) {
            list.add(ProductParser.parse(results));
        }
        return list;
    }

}