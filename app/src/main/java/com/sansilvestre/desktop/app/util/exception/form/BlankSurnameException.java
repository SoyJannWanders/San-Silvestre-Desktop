package com.sansilvestre.desktop.app.util.exception.form;

public class BlankSurnameException extends Exception {

    public BlankSurnameException() {
        super("Campo de Apellido vacio. Campo Obligatorio");
    }

}