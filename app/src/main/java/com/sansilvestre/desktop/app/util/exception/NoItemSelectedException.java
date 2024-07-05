package com.sansilvestre.desktop.app.util.exception;

public class NoItemSelectedException extends Exception {

    public NoItemSelectedException() {
        super("No hay un elemento Seleccionado. Seleccione uno primero");
    }

}