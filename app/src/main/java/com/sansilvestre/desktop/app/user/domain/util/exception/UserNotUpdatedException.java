package com.sansilvestre.desktop.app.user.domain.util.exception;

public class UserNotUpdatedException extends Exception {

    public UserNotUpdatedException() {
        super("No se ha actualizado el usuario");
    }

}