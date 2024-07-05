package com.sansilvestre.desktop.app.util.exception;

public class CategoryNotFoundException extends Exception {

    public CategoryNotFoundException() {
        super("No hay una Categoria con ese ID. Ingrese otro ID");
    }

}