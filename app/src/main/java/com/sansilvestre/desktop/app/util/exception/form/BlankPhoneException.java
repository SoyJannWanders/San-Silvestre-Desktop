package com.sansilvestre.desktop.app.util.exception.form;

public class BlankPhoneException extends Exception {

    public BlankPhoneException() {
        super("Campo de Telefono vacio. Campo Obligatorio");
    }

}