package com.sansilvestre.desktop.app.category.data.source.sync;

import com.sansilvestre.desktop.app.branch.data.source.sync.UnsyncedBranch;
import com.sansilvestre.desktop.app.branch.data.source.sync.UnsyncedBranchList;
import com.sansilvestre.desktop.app.branch.data.source.sync.UnsyncedBranchQuery;
import com.sansilvestre.desktop.app.product.data.source.sync.UnsyncedProductQuery;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.exception.UnsyncedTaskNotAddedException;
import com.sansilvestre.desktop.app.util.exception.UnsyncedTaskNotFoundException;

import java.sql.*;
import java.util.List;

public class UnsyncedCategoryStorage {

    public Response<List<UnsyncedCategory>> getUnsyncedCategoriesList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UnsyncedCategoryQuery.SELECT_UNSYNCED_CATEGORIES)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(UnsyncedCategoryList.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addUnsyncedCategoriesInQueue(UnsyncedCategory unsyncedCategory) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UnsyncedCategoryQuery.ADD_UNSYNCED_CATEGORIES_IN_QUEUE, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, unsyncedCategory.getId());
                statement.setString(2, unsyncedCategory.getType().name());
                if (statement.executeUpdate() > 0){
                    try (ResultSet result = statement.getGeneratedKeys()) {
                        if (result.next()) {
                            unsyncedCategory.setId(result.getInt(1));
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

    public Response<Void> deleteUnsyncedCategoriesOfQueueByID(int id) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UnsyncedCategoryQuery.DELETE_UNSYNCED_CATEGORIES_OF_QUEUE_BY_ID)) {
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