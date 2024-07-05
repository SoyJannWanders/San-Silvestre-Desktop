package com.sansilvestre.desktop.app.util.exception;

public class ProductNotUpdatedException extends Exception {

    public ProductNotUpdatedException() {
        super("Error al Actualizar el Producto. Intentelo más tarde");
    }

}
