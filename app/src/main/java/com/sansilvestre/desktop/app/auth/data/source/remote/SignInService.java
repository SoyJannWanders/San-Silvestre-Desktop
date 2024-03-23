package com.sansilvestre.desktop.app.auth.data.source.remote;

import com.sansilvestre.desktop.app.Database;
import com.sansilvestre.desktop.app.auth.screen.viewmodel.callback.SignInCallback;

import java.sql.*;
import java.util.logging.Logger;

public class SignInService {

    private final Logger logger = Logger.getLogger(SignInService.class.getName());

    public void signIn(String username, String password, SignInCallback callback) {
        try (Connection connection = DriverManager.getConnection(Database.LOCAL_URL, Database.LOCAL_USER, Database.LOCAL_PASSWORD)) {
            String query = "SELECT * FROM user WHERE Username = ? AND Password = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        callback.onSuccess();
                    } else {
                        callback.onFailure();
                    }
                }
            }
        } catch (SQLException e) {
            logger.severe(e.toString());
            callback.onFailure();
        }
    }

}