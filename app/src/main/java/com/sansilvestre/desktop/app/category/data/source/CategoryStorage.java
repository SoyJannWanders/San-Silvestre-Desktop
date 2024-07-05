package com.sansilvestre.desktop.app.category.data.source;

import com.sansilvestre.desktop.app.util.exception.CategoryNotAddedException;
import com.sansilvestre.desktop.app.util.exception.CategoryNotUpdatedException;
import com.sansilvestre.desktop.app.category.domain.util.structure.CategoryList;
import com.sansilvestre.desktop.app.category.domain.util.structure.CategoryMap;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.util.exception.CategoryNotFoundException;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.parser.Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class CategoryStorage {

    public Response<Map<Integer, Category>> getCategoryMap() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(CategoryQuery.SELECT_CATEGORIES)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(CategoryMap.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Category>> getCategoryList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(CategoryQuery.SELECT_CATEGORIES)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(CategoryList.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Category>> getCategoryListBySearch(String search) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(CategoryQuery.SELECT_CATEGORIES_BY_SEARCH)) {
                Search.ofCategory(statement, search);
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(CategoryList.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addCategory(Category category) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(CategoryQuery.INSERT_PRODUCT)) {
                category.populateStatement(statement);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new CategoryNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateCategory(Category category) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(CategoryQuery.UPDATE_CATEGORY)) {
                category.populateStatement(statement);
                statement.setInt(3, category.getId());
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new CategoryNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> deleteCategoryByID(int id) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(CategoryQuery.DELETE_CATEGORY_BY_ID)) {
                statement.setInt(1, id);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new CategoryNotFoundException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}