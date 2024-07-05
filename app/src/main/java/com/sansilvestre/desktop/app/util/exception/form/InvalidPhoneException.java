package com.sansilvestre.desktop.app.util.exception.form;

public class InvalidPhoneException extends Exception {

    public InvalidPhoneException() {
        super("Telefono Invalido. Ingrese uno valido");
    }

}