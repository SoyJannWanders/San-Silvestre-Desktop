package com.sansilvestre.desktop.app.util.exception.form;

public class BlankAmountException extends Exception {

    public BlankAmountException() {
        super("Campo de Monto de Apertura vacio. Campo Obligatorio");
    }

}