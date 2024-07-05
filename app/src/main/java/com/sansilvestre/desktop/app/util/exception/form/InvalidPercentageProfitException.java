package com.sansilvestre.desktop.app.util.exception.form;

public class InvalidPercentageProfitException extends Exception {

    public InvalidPercentageProfitException() {
        super("Porcentaje de Ganancia Invalido. Ingrese uno valido");
    }

}