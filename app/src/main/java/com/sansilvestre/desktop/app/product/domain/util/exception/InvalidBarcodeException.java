package com.sansilvestre.desktop.app.product.domain.util.exception;

public class InvalidBarcodeException extends Exception {

    public InvalidBarcodeException() {
        super("Codigo de Barras Invalido. Ingrese uno valido");
    }

}