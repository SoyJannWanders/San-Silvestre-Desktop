package com.sansilvestre.desktop.app.user.data.parser;


import com.sansilvestre.desktop.app.user.data.source.UserDatabase;
import com.sansilvestre.desktop.app.user.domain.model.User;

import java.sql.ResultSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserMap {

    public static Map<Integer, User> of(ResultSet result) throws Exception {
        Map<Integer, User> map = new ConcurrentHashMap<>();
        while (result.next()) {
            map.put(result.getInt(UserDatabase.ID.getColumnName()), new User(result));
        }
        return map;
    }

}