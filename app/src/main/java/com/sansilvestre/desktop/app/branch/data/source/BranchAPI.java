package com.sansilvestre.desktop.app.branch.data.source;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.domain.util.structure.BranchMap;
import com.sansilvestre.desktop.app.util.data.Api;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.exception.BranchNotAddedException;
import com.sansilvestre.desktop.app.util.exception.BranchNotFoundException;
import com.sansilvestre.desktop.app.util.exception.BranchNotUpdatedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Map;

public class BranchAPI {

    public Response<Map<Integer, Branch>> getBranchMap() {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.SELECT_BRANCHES)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(BranchMap.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addBranch(Branch branch) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.SYNC_INSERT_BRANCH)) {
                branch.populateStatementForSyncAdd(statement);
                if (statement.executeUpdate() > 0) {
                    return new Response.Success<>(null);
                } else {
                    throw new BranchNotAddedException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateBranch(Branch branch) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.SYNC_UPDATE_BRANCH)) {
                branch.populateStatementForSyncUpdate(statement);
                if (statement.executeUpdate() > 0) {
                    return new Response.Success<>(null);
                } else {
                    throw new BranchNotUpdatedException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> deleteBranchByID(int id) {
        try (Connection connection = DriverManager.getConnection(Api.URL, Api.USER, Api.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.DELETE_BRANCH_BY_ID)) {
                statement.setInt(1, id);
                if (statement.executeUpdate() > 0) {
                    return new Response.Success<>(null);
                } else {
                    throw new BranchNotFoundException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}