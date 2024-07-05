package com.sansilvestre.desktop.app.util.exception;

public class ProductNotAddedException extends Exception {

    public ProductNotAddedException() {
        super("Error al Guardar el Producto. Intentelo más tarde");
    }

}
