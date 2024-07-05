package com.sansilvestre.desktop.app.product.data.source.sync;

import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.exception.UnsyncedTaskNotAddedException;
import com.sansilvestre.desktop.app.util.exception.UnsyncedTaskNotFoundException;

import java.sql.*;
import java.util.List;

public class UnsyncedProductStorage {

    public Response<List<UnsyncedProduct>> getUnsyncedProductList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UnsyncedProductQuery.SELECT_UNSYNCED_PRODUCTS)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(UnsyncedProductList.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addUnsyncedProductInQueue(UnsyncedProduct unsyncedProduct) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UnsyncedProductQuery.ADD_UNSYNCED_PRODUCT_IN_QUEUE, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, unsyncedProduct.getBarcode());
                statement.setString(2, unsyncedProduct.getType().name());
                if (statement.executeUpdate() > 0){
                    try (ResultSet result = statement.getGeneratedKeys()) {
                        if (result.next()) {
                            unsyncedProduct.setId(result.getInt(1));
                        }
                    }
                    return new Response.Success<>(null);
                } else {
                    throw new UnsyncedTaskNotAddedException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> deleteUnsyncedProductOfQueueByID(int id) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UnsyncedProductQuery.DELETE_UNSYNCED_PRODUCT_OF_QUEUE_BY_ID)) {
                statement.setInt(1, id);
                if (statement.executeUpdate() > 0) {
                    return new Response.Success<>(null);
                } else {
                    throw new UnsyncedTaskNotFoundException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}