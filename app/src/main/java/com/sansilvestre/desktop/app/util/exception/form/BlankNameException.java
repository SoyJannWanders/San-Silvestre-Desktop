package com.sansilvestre.desktop.app.util.exception.form;

public class BlankNameException extends Exception {

    public BlankNameException() {
        super("Campo de Nombre vacio. Campo Obligatorio");
    }

}