package com.sansilvestre.desktop.app.util.exception.form;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException() {
        super("Contraseña Invalida. Ingrese una valida");
    }

}