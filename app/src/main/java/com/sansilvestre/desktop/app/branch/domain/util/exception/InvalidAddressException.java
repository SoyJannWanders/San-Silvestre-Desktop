package com.sansilvestre.desktop.app.branch.domain.util.exception;

public class InvalidAddressException extends Exception {

    public InvalidAddressException() {
        super("Direccion Invalida. Ingrese una valida");
    }

}