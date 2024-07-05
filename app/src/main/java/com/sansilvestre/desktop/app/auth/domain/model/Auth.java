package com.sansilvestre.desktop.app.auth.domain.model;

import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.user.domain.model.User;

public class Auth {

    private static Auth instance;

    private final User user;

    public Auth(User user) {
        this.user = user;
    }

    public static void init(User user) {
        instance = new Auth(user);
    }

    public static Auth getInstance() {
        return instance;
    }

    public int getId() {
        return user.getUserId();
    }

    public Role getRole() {
        return user.getRole();
    }

}