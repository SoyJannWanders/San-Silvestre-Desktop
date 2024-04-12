package com.sansilvestre.desktop.app.product.main.data.source.remote;

import com.sansilvestre.desktop.app.Api;
import com.sansilvestre.desktop.app.Storage;
import com.sansilvestre.desktop.app.product.main.data.parser.ProductListParser;
import com.sansilvestre.desktop.app.product.main.data.source.ProductQuery;
import com.sansilvestre.desktop.app.product.main.data.mapper.ProductMapper;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.util.Response;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductApi {

    public Response<List<Product>> searchProduct(String query) {
        try (Connection connection = DriverManager.getConnection(Storage.STORAGE_URL, Storage.STORAGE_USER, Storage.STORAGE_PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCT_BY_LABEL_OR_BARCODE)) {
                statement.setString(1, "%" + query + "%");
                statement.setString(2, query + "%");
                return new Response.Success<>(ProductListParser.parse(statement.executeQuery()));
            }
        } catch (SQLException e) {
            return new Response.Failure<>(e.getMessage());
        }
    }

    public Response<List<Product>> getProductList() {
        try (Connection connection = DriverManager.getConnection(Api.API_URL, Api.API_USER, Api.API_PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS)) {
                return new Response.Success<>(ProductListParser.parse(statement.executeQuery()));
            }
        } catch (SQLException e) {
            return new Response.Failure<>(e.getMessage());
        }
    }

    public Response<Void> insert(Product product) {
        try (Connection connection = DriverManager.getConnection(Api.API_URL, Api.API_USER, Api.API_PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.INSERT_PRODUCT)) {
                ProductMapper.toStatement(product, statement);
                statement.executeUpdate();
                return new Response.Success<>(null);
            }
        } catch (SQLException e) {
            return new Response.Failure<>(e.getMessage());
        }
    }

}