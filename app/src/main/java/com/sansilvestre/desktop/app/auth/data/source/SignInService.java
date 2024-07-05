package com.sansilvestre.desktop.app.auth.data.source;

import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.sql.*;

public class SignInService {

    public Response<String> signIn(int id, String password) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SignInQuery.SIGN_IN)) {
                statement.setInt(1, id);
                statement.setString(2, password);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        return new Response.Success<>(result.getString(1));
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