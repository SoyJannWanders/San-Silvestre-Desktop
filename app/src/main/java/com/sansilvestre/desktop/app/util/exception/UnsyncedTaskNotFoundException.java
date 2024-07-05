package com.sansilvestre.desktop.app.util.exception;

public class UnsyncedTaskNotFoundException extends Exception {

    public UnsyncedTaskNotFoundException() {
        super("No hay una Tarea Pendiente con ese ID");
    }

}