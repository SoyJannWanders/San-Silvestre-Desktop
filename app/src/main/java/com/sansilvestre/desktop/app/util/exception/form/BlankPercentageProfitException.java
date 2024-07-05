package com.sansilvestre.desktop.app.util.exception.form;

public class BlankPercentageProfitException extends Exception {

    public BlankPercentageProfitException() {
        super("Campo de Porcentaje de Ganancia vacio. Campo Obligatorio");
    }

}