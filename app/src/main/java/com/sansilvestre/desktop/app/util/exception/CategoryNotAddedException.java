package com.sansilvestre.desktop.app.util.exception;

public class CategoryNotAddedException extends Exception {

    public CategoryNotAddedException() {
        super("Error al Guardar la Categoria. Intentelo más tarde");
    }

}