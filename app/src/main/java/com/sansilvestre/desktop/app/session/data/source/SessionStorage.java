package com.sansilvestre.desktop.app.session.data.source;

import com.sansilvestre.desktop.app.util.exception.ProductNotAddedException;
import com.sansilvestre.desktop.app.user.domain.util.exception.UserNotUpdatedException;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.log.Console;

import java.sql.*;

public class SessionStorage {

    public Response<Integer> openSession(int checkoutId) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SessionQuery.OPEN_SESSION, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, checkoutId);
                if (statement.executeUpdate() > 0)
                    try (ResultSet result = statement.getGeneratedKeys()) {
                        if (result.next())
                            return new Response.Success<>(result.getInt(1));
                        else
                            throw new ProductNotAddedException();
                    }
                else
                    throw new ProductNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> closeSession(int id) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SessionQuery.CLOSE_SESSION)) {
                statement.setInt(1, id);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new UserNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Session> getLastActiveSession() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SessionQuery.GET_LAST_ACTIVE_SESSION)) {
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        return new Response.Success<>(new Session(result));
                    } else {
                        Console.info(Console.InfoCode.I001, "No hay ninguna sesión abierta.");
                        return new Response.Success<>(null);
                    }
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}