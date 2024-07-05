package com.sansilvestre.desktop.app.util.exception;

public class BranchNotUpdatedException extends Exception {

    public BranchNotUpdatedException() {
        super("Error al Actualizar la Sucursal. Intentelo más tarde");
    }

}