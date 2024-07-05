package com.sansilvestre.desktop.app.util.exception.form;

public class InvalidTimeException extends Exception {

    public InvalidTimeException() {
        super("Tiempo de Inicio Invalido. Ingrese uno valido");
    }

}