package com.sansilvestre.desktop.app.util.exception;

public class LowRoleException extends Exception {

    public LowRoleException() {
        super("Cargo de bajo rango. Seleccione otro Cargo u otra Sucursal");
    }

}