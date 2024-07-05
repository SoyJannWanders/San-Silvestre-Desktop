package com.sansilvestre.desktop.app.setting.data.source;

import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.util.data.Storage;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.exception.SettingNotAddedException;
import com.sansilvestre.desktop.app.util.exception.SettingNotUpdatedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SettingStorage {

    public Response<Void> getSetting() {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SettingQuery.GET_SETTING)) {
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        Setting.initializeInstance(result);
                    }
                    return new Response.Success<>(null);
                }
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> addSetting(Setting setting) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SettingQuery.INSERT_SETTING)) {
                setting.populateStatement(statement);
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new SettingNotAddedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

    public Response<Void> updateSetting(Setting setting) {
        try (Connection connection = DriverManager.getConnection(Storage.URL, Storage.USER, Storage.PASSWORD)) {
            try (PreparedStatement statement = connection.prepareStatement(SettingQuery.UPDATE_SETTING)) {
                setting.populateStatement(statement);
                statement.setInt(5, setting.getId());
                if (statement.executeUpdate() > 0)
                    return new Response.Success<>(null);
                else
                    throw new SettingNotUpdatedException();
            }
        } catch (Exception e) {
            return new Response.Failure<>(e);
        }
    }

}