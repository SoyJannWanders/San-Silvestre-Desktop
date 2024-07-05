package com.sansilvestre.desktop.app.util.exception;

public class UserActionNotAllowedException extends Exception {

    public UserActionNotAllowedException() {
        super("Acción no permitida para este Usuario");
    }

}