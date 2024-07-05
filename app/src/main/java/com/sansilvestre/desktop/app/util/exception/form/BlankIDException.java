package com.sansilvestre.desktop.app.util.exception.form;

public class BlankIDException extends Exception {

    public BlankIDException() {
        super("Campo de ID vacio. Campo Obligatorio");
    }

}