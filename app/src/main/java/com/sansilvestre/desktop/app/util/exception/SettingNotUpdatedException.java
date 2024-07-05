package com.sansilvestre.desktop.app.util.exception;

public class SettingNotUpdatedException extends Exception {

    public SettingNotUpdatedException() {
        super("Error al Actualizar la Configuración. Intentelo más tarde");
    }

}