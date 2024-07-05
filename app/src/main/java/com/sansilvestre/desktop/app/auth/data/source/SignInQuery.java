package com.sansilvestre.desktop.app.auth.data.source;

public class SignInQuery {

    public static final String SIGN_IN =
            "SELECT role FROM users WHERE id = ? AND password = ?;";

}