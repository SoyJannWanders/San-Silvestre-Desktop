package com.sansilvestre.desktop.app.util.exception.form;

public class InvalidPercentageException extends Exception {

    public InvalidPercentageException() {
        super("Porcentaje Invalido. Ingrese uno valido");
    }

}