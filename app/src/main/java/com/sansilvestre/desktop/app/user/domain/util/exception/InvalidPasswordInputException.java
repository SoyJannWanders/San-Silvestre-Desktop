package com.sansilvestre.desktop.app.user.domain.util.exception;

public class InvalidPasswordInputException extends Exception {

    public InvalidPasswordInputException() {
        super("Contraseña Invalida.");
    }

}