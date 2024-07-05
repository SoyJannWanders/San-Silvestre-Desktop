package com.sansilvestre.desktop.app.user.data.source;

import com.sansilvestre.desktop.app.util.exception.ProductNotUpdatedException;
import com.sansilvestre.desktop.app.product.data.source.ProductQuery;
import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotAddedException;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotFoundException;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotUpdatedException;
import com.sansilvestre.desktop.app.user.data.parser.UserList;
import com.sansilvestre.desktop.app.user.data.parser.UserMap;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.objects.IncreaseType;
import com.sansilvestre.desktop.app.util.parser.Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class UserStorage {

    public Response<User> getUserByID(int ID) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCT_BY_BARCODE)) {
                statement.setInt(1, ID);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next())
                        return new Response.Success<>(new User(result));
                    else
                        throw new UserNotFoundException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Map<Integer, User>> getProductMap() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ProductQuery.SELECT_PRODUCTS)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(UserMap.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<User>> getUserList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UserQuery.SELECT_USERS)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(UserList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<User>> getUserListBySearch(String search) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UserQuery.SELECT_USERS_BY_SEARCH)) {
                Search.ofProduct(statement, search);
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(UserList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<User>> getUserListByRole(Role role) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UserQuery.SELECT_USERS_BY_ROLE)) {
                statement.setString(1, role.name());
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(UserList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<User>> getUserListByBranch(int branchId) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UserQuery.SELECT_USERS_BY_BRANCH_ID)) {
                statement.setInt(1, branchId);
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(UserList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addUser(User user) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UserQuery.INSERT_USER)) {
                user.populateStatement(statement);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateUser(User user) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UserQuery.UPDATE_USER)) {
                user.populateStatement(statement);
                statement.setInt(8, user.getUserId());
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateUserSalaryByID(double salary, int id) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UserQuery.UPDATE_USER_SALARY_BY_ID)) {
                statement.setDouble(1, salary);
                statement.setInt(2, id);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateUsersSalariesByBranchID(IncreaseType increaseType, double increase, int branchId) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UserQuery.getUpdateUsersSalariesQuery(increaseType, branchId))) {
                statement.setDouble(1, increase);
                if (branchId != 1)
                    statement.setInt(2, branchId);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new ProductNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> deleteUserByID(int ID) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(UserQuery.DELETE_USER_BY_ID)) {
                statement.setInt(1, ID);
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