package com.sansilvestre.desktop.app.util.exception.form;

public class InvalidNameException extends Exception {

    public InvalidNameException() {
        super("Nombre Invalido. Ingrese uno valido");
    }

}