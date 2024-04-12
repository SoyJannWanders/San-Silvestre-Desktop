package com.sansilvestre.desktop.app.product.main.data.parser;

import com.sansilvestre.desktop.app.product.domain.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductParser {

    public static Product parse(ResultSet resultSet) throws SQLException {
        return new Product()
                .setBarcode(resultSet.getString("barcode"))
                .setLabel(resultSet.getString("label"))
                .setAddedDate(resultSet.getDate("addedDate").toLocalDate())
                .setUpdatedDate(resultSet.getDate("updatedDate").toLocalDate())
                .setCategory(resultSet.getString("category"))
                .setStock(resultSet.getInt("stock"))
                .setUID(resultSet.getInt("UID"))
                .setOID(resultSet.getInt("OID"))
                .setCost(resultSet.getDouble("cost"))
                .setAdditionalTaxes(resultSet.getBoolean("hasAdditionalTaxes"));
    }

}