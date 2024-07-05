package com.sansilvestre.desktop.app.util.objects;

public enum Stock {

    ALL("Todos"),
    WITH_STOCK("Con Stock"),
    WITHOUT_STOCK("Sin Stock");

    private final String name;

    Stock(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

}