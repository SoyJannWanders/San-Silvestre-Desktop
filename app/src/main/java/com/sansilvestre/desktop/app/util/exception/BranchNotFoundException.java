package com.sansilvestre.desktop.app.util.exception;

public class BranchNotFoundException extends Exception {

    public BranchNotFoundException() {
        super("No hay una Sucursal con ese ID. Ingrese otro ID");
    }

}