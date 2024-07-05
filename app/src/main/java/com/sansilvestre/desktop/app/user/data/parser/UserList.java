package com.sansilvestre.desktop.app.user.data.parser;

import com.sansilvestre.desktop.app.user.domain.model.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserList {

    public static List<User> of(ResultSet result) throws Exception {
        List<User> list = new ArrayList<>();
        while (result.next()) {
            list.add(new User(result));
        }
        return list;
    }

}