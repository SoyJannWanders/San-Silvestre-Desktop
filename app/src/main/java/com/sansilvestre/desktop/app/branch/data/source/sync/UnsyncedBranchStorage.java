package com.sansilvestre.desktop.app.branch.data.source.sync;

import com.sansilvestre.desktop.app.product.data.source.sync.UnsyncedProductQuery;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.exception.UnsyncedTaskNotAddedException;
import com.sansilvestre.desktop.app.util.exception.UnsyncedTaskNotFoundException;

import java.sql.*;
import java.util.List;

public class UnsyncedBranchStorage {

    public Response<List<UnsyncedBranch>> getUnsyncedBranchList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UnsyncedBranchQuery.SELECT_UNSYNCED_BRANCHES)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(UnsyncedBranchList.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addUnsyncedBranchInQueue(UnsyncedBranch unsyncedBranch) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UnsyncedProductQuery.ADD_UNSYNCED_PRODUCT_IN_QUEUE, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, unsyncedBranch.getId());
                statement.setString(2, unsyncedBranch.getType().name());
                if (statement.executeUpdate() > 0){
                    try (ResultSet result = statement.getGeneratedKeys()) {
                        if (result.next()) {
                            unsyncedBranch.setId(result.getInt(1));
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

    public Response<Void> deleteUnsyncedBranchOfQueueByID(int id) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UnsyncedBranchQuery.DELETE_UNSYNCED_BRANCH_OF_QUEUE_BY_ID)) {
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