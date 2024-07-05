package com.sansilvestre.desktop.app.category.data.source;

import com.sansilvestre.desktop.app.util.exception.CategoryNotAddedException;
import com.sansilvestre.desktop.app.util.exception.CategoryNotUpdatedException;
import com.sansilvestre.desktop.app.category.domain.util.structure.CategoryMap;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.util.exception.CategoryNotFoundException;
import com.sansilvestre.desktop.app.product.data.source.ProductQuery;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.Api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class CategoryAPI {

    public Response<Map<Integer, Category>> getCategoryMap() {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS)) {
                try (ResultSet results = statement.executeQuery()) {
                    return new Response.Success<>(CategoryMap.of(results));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addCategory(Category category) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.INSERT_PRODUCT)) {
                category.populateStatement(statement);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new CategoryNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateCategory(Category category) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.UPDATE_PRODUCT)) {
                category.populateStatement(statement);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new CategoryNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> deleteCategoryByID(int ID) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.DELETE_PRODUCT)) {
                statement.setInt(1, ID);
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0)
                    return new Response.Success<>(null);
                else
                    throw new CategoryNotFoundException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}