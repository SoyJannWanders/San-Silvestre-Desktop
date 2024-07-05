package com.sansilvestre.desktop.app.transaction.data.source;

public class TransactionQuery {

    public static final String ADD_TRANSACTION =
            "INSERT INTO transactions (session_id, created_at, concept, type, amount) VALUES (?, ?, ?, ?, ?);";

    public static final String GET_TOTAL_AMOUNT_BY_SESSION_ID =
            "SELECT SUM(amount) AS total_amount FROM transactions WHERE session_id = ?;";

}