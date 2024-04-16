package com.sansilvestre.desktop.app.auth.data.source.remote;

import com.sansilvestre.desktop.app.Storage;
import com.sansilvestre.desktop.app.auth.screen.viewmodel.callback.SignInCallback;

import java.sql.*;
import java.util.logging.Logger;

public class SignInService {

    private final Logger logger = Logger.getLogger(SignInService.class.getName());

    public void signIn(String username, String password, SignInCallback callback) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            String query = "SELECT * FROM user WHERE Username = ? AND Password = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        callback.onSuccess();
                    } else {
                        System.out.println(username);
                        System.out.println(password);
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