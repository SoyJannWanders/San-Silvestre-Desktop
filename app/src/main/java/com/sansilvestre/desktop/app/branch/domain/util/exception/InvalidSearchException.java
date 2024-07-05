package com.sansilvestre.desktop.app.branch.domain.util.exception;

public class InvalidSearchException extends Exception {

    public InvalidSearchException() {
        super("Valor de busqueda invalido. Intente nuevamente");
    }

}