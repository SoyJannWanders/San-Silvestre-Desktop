package com.sansilvestre.desktop.app.util.exception.form;

public class BlankAddressException extends Exception {

    public BlankAddressException() {
        super("Campo de Dirección vacio. Campo Obligatorio");
    }

}