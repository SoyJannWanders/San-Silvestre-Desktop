package com.sansilvestre.desktop.app.util.exception.form;

public class BlankPasswordException extends Exception {

    public BlankPasswordException() {
        super("Campo de Contraseña vacio. Campo Obligatorio");
    }

}