package com.sansilvestre.desktop.app.util.exception;

public class UnsyncedTaskNotAddedException extends Exception {

    public UnsyncedTaskNotAddedException() {
        super("Error al Insertar la tarea pendiente en la Cola de Tareas");
    }

}