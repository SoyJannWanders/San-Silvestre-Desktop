package com.sansilvestre.desktop.app.util.exception.form;

public class InvalidPercentageDiscountCashException extends Exception {

    public InvalidPercentageDiscountCashException() {
        super("Porcentaje de Descuento Invalido. Ingrese uno valido");
    }

}