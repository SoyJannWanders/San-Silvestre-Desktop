package com.sansilvestre.desktop.app.util.exception;

public class SettingNotAddedException extends Exception {

    public SettingNotAddedException() {
        super("Error al Guardar la Configuración. Intentelo más tarde");
    }

}