package com.sansilvestre.desktop.app.user.data.source;

import com.sansilvestre.desktop.app.util.exception.ProductNotUpdatedException;
import com.sansilvestre.desktop.app.product.data.source.ProductQuery;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.user.data.parser.UserMap;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotAddedException;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotFoundException;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotUpdatedException;
import com.sansilvestre.desktop.app.util.data.Api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class UserAPI {

    public Response<Map<Integer, User>> getUserMap() {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS)) {
                try (ResultSet results = statement.executeQuery()) {
                    return new Response.Success<>(UserMap.of(results));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addUser(User user) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.INSERT_PRODUCT)) {
                user.populateStatement(statement);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateUser(User user) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT)) {
                user.populateStatement(statement);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateUserSalaryByID(int ID, double increase) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT)) {
                statement.setInt(1, ID);
                statement.setDouble(2, increase);
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

    public Response<Void> updateUserSalariesByRole(int role, double increase) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT)) {
                statement.setInt(1, role);
                statement.setDouble(2, increase);
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

    public Response<Void> deleteUserByBarcode(int ID) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.DELETE_PRODUCT)) {
                statement.setInt(1, ID);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotFoundException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}