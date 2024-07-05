package com.sansilvestre.desktop.app.util.exception.form;

public class InvalidAmountException extends Exception {

    public InvalidAmountException() {
        super("Monto Invalido. Ingrese uno valido");
    }

}