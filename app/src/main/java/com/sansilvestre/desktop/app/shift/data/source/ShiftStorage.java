package com.sansilvestre.desktop.app.shift.data.source;

import com.sansilvestre.desktop.app.exception.ShiftNotFoundException;
import com.sansilvestre.desktop.app.user.data.source.UserQuery;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotAddedException;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotFoundException;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotUpdatedException;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.shift.data.parser.ShiftList;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.util.data.Storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ShiftStorage {

    public Response<Shift> getShift() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ShiftQuery.GET_SHIFT)) {
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next())
                        return new Response.Success<>(Shift.of(result));
                    else
                        throw new ShiftNotFoundException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Shift> getShiftByID(int shiftId) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ShiftQuery.GET_SHIFT_BY_ID)) {
                statement.setInt(1, shiftId);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next())
                        return new Response.Success<>(Shift.of(result));
                    else
                        throw new ShiftNotFoundException();
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<List<Shift>> getShiftList() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ShiftQuery.GET_SHIFTS)) {
                try (ResultSet result = statement.executeQuery()) {
                    return new Response.Success<>(ShiftList.of(result));
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addShift(Shift shift) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ShiftQuery.INSERT_SHIFT)) {
                shift.populateStatement(statement);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateShift(Shift shift) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ShiftQuery.UPDATE_SHIFT)) {
                shift.populateStatement(statement);
                statement.setInt(5, shift.getId());
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> deleteShiftByID(int id) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(ShiftQuery.DELETE_SHIFT_BY_ID)) {
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