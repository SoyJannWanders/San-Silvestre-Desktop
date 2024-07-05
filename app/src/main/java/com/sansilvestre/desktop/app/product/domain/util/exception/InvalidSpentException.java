package com.sansilvestre.desktop.app.product.domain.util.exception;

public class InvalidSpentException extends Exception {

    public InvalidSpentException() {
        super("Costo Invalido. Ingrese uno valido");
    }

}