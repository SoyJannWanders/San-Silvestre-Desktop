package com.sansilvestre.desktop.app.util.exception.form;

public class BlankPercentageDiscountCashException extends Exception {

    public BlankPercentageDiscountCashException() {
        super("Campo de Porcentaje de Descuento vacio. Campo Obligatorio");
    }

}