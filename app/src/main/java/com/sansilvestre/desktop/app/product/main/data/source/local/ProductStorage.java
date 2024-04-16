package com.sansilvestre.desktop.app.product.main.data.source.local;

import com.sansilvestre.desktop.app.Storage;
import com.sansilvestre.desktop.app.product.main.data.parser.ProductListParser;
import com.sansilvestre.desktop.app.product.main.data.mapper.ProductMapper;
import com.sansilvestre.desktop.app.product.main.data.source.ProductQuery;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.util.Response;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class ProductStorage {

    public Response<List<Product>> searchProduct(String query) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCT_BY_LABEL_OR_BARCODE)) {
                statement.setString(1, "%" + query + "%");
                statement.setString(2, query + "%");
                return new Response.Success<>(ProductListParser.parse(statement.executeQuery()));
            }
        } catch (SQLException e) {
            return new Response.Failure<>(e.getMessage());
        }
    }

    public Response<Boolean> fetchProduct(String barcode) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_COUNT_BY_BARCODE)) {
                statement.setString(1, barcode);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        return new Response.Success<>(result.getInt(1) == 0);
                    } else {
                        return new Response.Failure<>("Error en Resultado");
                    }
                }
            }
        } catch (SQLException e) {
            return new Response.Failure<>(e.getMessage());
        }
    }

    public Response<List<Product>> getProductList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS)) {
                return new Response.Success<>(ProductListParser.parse(statement.executeQuery()));
            }
        } catch (SQLException e) {
            return new Response.Failure<>(e.getMessage());
        }
    }

    public Response<Void> insertProductList(List<Product> list) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            connection.setAutoCommit(true);
            for (Product product: list) {
                System.out.println("Producto: " + product.getLabel());
                Response<Boolean> response = fetchProduct(product.getBarcode());
                if (response instanceof Response.Success<Boolean>) {
                    if (((Response.Success<Boolean>) response).getObject()) {
                        try (PreparedStatement statement = connection.prepareStatement(ProductQuery.INSERT_PRODUCT)) {
                            ProductMapper.toStatement(product, statement);
                            statement.executeUpdate();
                            connection.commit();
                        }
                    }
                }
            }
            return new Response.Success<>(null);
        } catch (SQLException e) {
            return new Response.Failure<>(e.getMessage());
        }
    }

    public Response<Void> insertProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
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