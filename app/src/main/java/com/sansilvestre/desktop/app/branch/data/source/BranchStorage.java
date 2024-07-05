package com.sansilvestre.desktop.app.branch.data.source;

import com.sansilvestre.desktop.app.branch.domain.util.structure.BranchList;
import com.sansilvestre.desktop.app.branch.domain.util.structure.BranchMap;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.util.exception.BranchNotAddedException;
import com.sansilvestre.desktop.app.product.data.source.ProductDatabase;
import com.sansilvestre.desktop.app.util.exception.BranchNotFoundException;
import com.sansilvestre.desktop.app.util.exception.BranchNotUpdatedException;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.parser.Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class BranchStorage {

    public Response<Branch> getBranchByID(int id) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.SELECT_BRANCH_BY_ID)) {
                statement.setInt(1, id);
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(new Branch(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Map<Integer, Branch>> getBranchMap() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.SELECT_BRANCHES)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(BranchMap.valueOf(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Branch>> getBranchList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.SELECT_BRANCHES)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(BranchList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Branch>> getBranchListBySearch(String search) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.SELECT_BRANCHES_BY_SEARCH)) {
                Search.ofBranch(statement, search);
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(BranchList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addBranch(Branch branch) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.INSERT_BRANCH)) {
                branch.populateStatementForAdd(statement);
                if (statement.executeUpdate() > 0) {
                    LocalDateTime timestamp = getGeneratedTimestampByID(branch.getId());
                    branch.setAddedDate(timestamp);
                    branch.setUpdatedDate(timestamp);
                    return new Response.Success<>(null);
                } else {
                    throw new BranchNotAddedException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> syncAddBranch(Branch branch) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
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
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.UPDATE_BRANCH)) {
                branch.populateStatementForUpdate(statement);
                if (statement.executeUpdate() > 0) {
                    LocalDateTime timestamp = getGeneratedTimestampByID(branch.getId());
                    branch.setUpdatedDate(timestamp);
                    return new Response.Success<>(null);
                } else {
                    throw new BranchNotUpdatedException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> syncUpdateBranch(Branch branch) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
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
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
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

    public LocalDateTime getGeneratedTimestampByID(int id) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(BranchQuery.SELECT_GENERATED_TIMESTAMP)) {
                statement.setInt(1, id);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        return result.getTimestamp(ProductDatabase.UPDATED_DATE.getColumnName()).toLocalDateTime();
                    } else {
                        throw new BranchNotFoundException();
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

}