package com.sansilvestre.desktop.app.user.domain.util.exception;

public class LowRoleInputException extends Exception {

    public LowRoleInputException() {
        super("Cargo con pocos permisos para esta configuracion.");
    }

}