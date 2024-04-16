package com.sansilvestre.desktop.app.product.main.data.mapper;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.main.domain.model.ProductTableModel;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductMapper {

    public static void toStatement(Product product, PreparedStatement statement) throws SQLException {
        statement.setString(1, product.getBarcode());
        statement.setString(2, product.getLabel());
        statement.setDouble(3, product.getCost());
        statement.setString(4, product.getCategory().getValue());
        statement.setInt(5, product.getStock());
        statement.setBoolean(6, product.hasAdditionalTaxes());
        statement.setInt(7, product.getUID());
        statement.setInt(8, product.getOID());
        statement.setDate(9, Date.valueOf(product.getAddedDate()));
        statement.setDate(10, Date.valueOf(product.getUpdatedDate()));
        statement.setBoolean(11, product.isActive());
    }

    public static Object[] toObject(ProductTableModel product) {
        System.out.println(product.getName());
        return new Object[]{
                product.getStock(),
                product.getName(),
                product.getBarcode(),
                product.getCost(),
                product.getRoundedPrice(),
                product.getCategory()
        };
    }

}