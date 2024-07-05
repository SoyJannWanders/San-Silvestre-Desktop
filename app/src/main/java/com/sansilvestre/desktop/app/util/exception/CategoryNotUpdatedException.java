package com.sansilvestre.desktop.app.util.exception;

public class CategoryNotUpdatedException extends Exception {

    public CategoryNotUpdatedException() {
        super("Error al Actualizar la Categoria. Intentelo más tarde");
    }

}