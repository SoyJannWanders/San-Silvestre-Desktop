package com.sansilvestre.desktop.app.transaction.data.source;

import com.sansilvestre.desktop.app.util.exception.ProductNotAddedException;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.transaction.domain.model.Transaction;
import com.sansilvestre.desktop.app.util.data.Storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionStorage {

    public Response<Void> addTransaction(Transaction transaction) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(TransactionQuery.ADD_TRANSACTION)) {
                transaction.putOnStatement(statement);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    return new Response.Success<>(null);
                }
                else
                    throw new ProductNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Double> getTotalAmountBySessionID(int sessionId) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(TransactionQuery.GET_TOTAL_AMOUNT_BY_SESSION_ID)) {
                statement.setInt(1, sessionId);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next())
                        return new Response.Success<>(result.getDouble(1));
                    else
                        throw new ProductNotAddedException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}