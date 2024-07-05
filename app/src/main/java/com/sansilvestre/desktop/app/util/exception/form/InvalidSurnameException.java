package com.sansilvestre.desktop.app.util.exception.form;

public class InvalidSurnameException extends Exception {

    public InvalidSurnameException() {
        super("Apellido Invalido. Ingrese uno valido");
    }

}