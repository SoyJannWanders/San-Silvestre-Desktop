package com.sansilvestre.desktop.app.sale.domain.model;

public enum PaymentMethod {

    CASH("Efectivo"),
    TRANSFER("Transferencia"),
    QR_CODE("Codigo QR"),
    DEBIT("Debito"),
    CREDIT("Credito");

    private final String name;

    PaymentMethod(String name) {
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