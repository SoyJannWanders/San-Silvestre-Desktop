package com.sansilvestre.desktop.app.sale.data.source;

public enum SaleDatabase {

    ID(1, "id"),
    CLIENT_ID(2, "client_id"),
    TOTAL(3, "total"),
    CASH_PAYMENT(4, "cash_payment"),
    TRANSFER_PAYMENT(5, "transfer_payment"),
    QR_CODE_PAYMENT(6, "qr_code_payment"),
    DEBIT_PAYMENT(7, "debit_payment"),
    CREDIT_PAYMENT(8, "credit_payment"),
    CHECKOUT_ID(9, "checkout_id"),
    BRANCH_ID(10, "branch_id"),
    CREATED_AT(11, "created_at");

    private final int index;
    private final String columnName;

    SaleDatabase(int index, String columnName) {
        this.index = index;
        this.columnName = columnName;
    }

    public int getIndex() {
        return index;
    }

    public String getColumnName() {
        return columnName;
    }

}