package com.sansilvestre.desktop.app.util.exception.form;

public class InvalidPercentageTaxException extends Exception {

    public InvalidPercentageTaxException() {
        super("Impuestos Invalidos. Ingrese uno valido");
    }

}