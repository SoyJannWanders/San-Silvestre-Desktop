package com.sansilvestre.desktop.app.auth.domain.model;

public class User {

    public enum Type {
        MANAGER,
        ADMINISTRATOR
    }

    private int ID;
    private Type type;
    private String user;
    private String password;

    public User(int ID, Type type, String user, String password) {
        this.ID = ID;
        this.type = type;
        this.user = user;
        this.password = password;
    }

    public Type getType() {
        return type;
    }

}