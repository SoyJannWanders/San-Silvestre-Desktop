package com.sansilvestre.desktop.app.auth.data.source;

import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.sql.*;

public class SignInService {

    public Response<User> signIn(int id, String password) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SignInQuery.SIGN_IN)) {
                statement.setInt(1, id);
                statement.setString(2, password);
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        return new Response.Success<>(new User(rs));
                    } else {
                        throw new Exception();
                    }
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}