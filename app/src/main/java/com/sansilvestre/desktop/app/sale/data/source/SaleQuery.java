package com.sansilvestre.desktop.app.sale.data.source;

public class SaleQuery {

    public static final String GET_SALES =
            "SELECT * FROM sales ORDER BY created_at DESC;";

    public static final String GET_SALES_BY_BRANCH_ID =
            "SELECT * FROM sales WHERE branch_id = ?;";

    public static final String GET_SALE_ITEMS_BY_SALE_ID =
            "SELECT * FROM items WHERE sale_id = ?;";

    public static final String ADD_SALE =
            "INSERT INTO sales (client_id, total, cash_payment, transfer_payment, qr_code_payment, debit_payment, credit_payment, checkout_id, branch_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public static final String ADD_SALE_ITEM =
            "INSERT INTO items (name, barcode, units, price, sale_id) VALUES (?, ?, ?, ?, ?);";

}