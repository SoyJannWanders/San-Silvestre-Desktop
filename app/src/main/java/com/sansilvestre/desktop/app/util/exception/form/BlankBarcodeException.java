package com.sansilvestre.desktop.app.util.exception.form;

public class BlankBarcodeException extends Exception {

    public BlankBarcodeException() {
        super("Campo de Codigo de Barras vacio. Campo Obligatorio");
    }

}