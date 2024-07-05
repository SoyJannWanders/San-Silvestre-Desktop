package com.sansilvestre.desktop.app.product.data.source;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.domain.util.structure.ProductMap;
import com.sansilvestre.desktop.app.product.domain.util.exception.*;
import com.sansilvestre.desktop.app.util.data.Api;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.exception.ProductNotAddedException;
import com.sansilvestre.desktop.app.util.exception.ProductNotUpdatedException;

import java.sql.*;
import java.util.Map;

public class ProductAPI {

    public Response<Map<String, Product>> getProductMap() {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS)) {
                try (ResultSet results = statement.executeQuery()) {
                    Map<String, Product> database = ProductMap.of(results);
                    if (database != null)
                        return new Response.Success<>(database);
                    else
                        throw new ProductNotFoundException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SYNC_INSERT_PRODUCT)) {
                product.populateStatementForSyncAdd(statement);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SYNC_UPDATE_PRODUCT)) {
                product.populateStatementForSyncUpdate(statement);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateProductStockByBarcode(int stock, String barcode) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT)) {
                statement.setInt(1, stock);
                statement.setString(2, barcode);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateProductPrice(double percentage) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT_PRICES)) {
                statement.setDouble(1, percentage);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateProductPriceByCategory(double percentage, int category) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT_PRICES_BY_CATEGORY)) {
                statement.setDouble(1, percentage);
                statement.setInt(2, category);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new CategoryWithoutLinkedProductsException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateProductPriceByOffice(double percentage, int office) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT_PRICES_BY_OFFICE)) {
                statement.setDouble(1, percentage);
                statement.setInt(2, office);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new OfficeWithoutLinkedProductsException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> deleteProductByBarcode(String barcode) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.DELETE_PRODUCT)) {
                statement.setString(1, barcode);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotFoundException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}