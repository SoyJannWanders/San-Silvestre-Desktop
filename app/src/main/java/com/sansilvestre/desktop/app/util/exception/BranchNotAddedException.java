package com.sansilvestre.desktop.app.util.exception;

public class BranchNotAddedException extends Exception {

    public BranchNotAddedException() {
        super("Error al Guardar la Sucursal. Intentelo más tarde");
    }

}