package com.sansilvestre.desktop.app.util.ui.window.develop.domain.exception;

public class IncorrectPasswordInputException extends Exception {

    public IncorrectPasswordInputException() {
        super("Clave incorrecta, se ha informado del intento de acceso.");
    }

}