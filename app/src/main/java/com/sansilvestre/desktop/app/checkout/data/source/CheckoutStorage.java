package com.sansilvestre.desktop.app.checkout.data.source;

import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.checkout.domain.util.structure.CheckoutList;
import com.sansilvestre.desktop.app.shift.data.source.ShiftQuery;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotAddedException;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotFoundException;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotUpdatedException;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.sql.*;
import java.util.List;

public class CheckoutStorage {

    public Response<List<Checkout>> getCheckoutList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(CheckoutQuery.GET_CHECKOUTS)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(CheckoutList.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Integer> addCheckout(Checkout checkout) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(CheckoutQuery.INSERT_CHECKOUT, Statement.RETURN_GENERATED_KEYS)) {
                checkout.populateStatement(statement);
                if (statement.executeUpdate() > 0)
                    try (ResultSet result = statement.getGeneratedKeys()) {
                        if (result.next()) {
                            return new Response.Success<>(result.getInt(1));
                        } else {
                            throw new UserNotAddedException();
                        }
                    }
                else
                    throw new UserNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateCheckout(Checkout checkout) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(CheckoutQuery.UPDATE_CHECKOUT)) {
                statement.setString(1, checkout.getName());
                statement.setInt(2, checkout.getId());
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> deleteCheckoutByID(int id) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(CheckoutQuery.DELETE_CHECKOUT_BY_ID)) {
                statement.setInt(1, id);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotFoundException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}