package com.sansilvestre.desktop.app.transaction.domain.model;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;

public class Transaction {

    public enum Concept {

        OPEN_CHECKOUT("Open Checkout"),
        CLOSE_CHECKOUT("Close Checkout"),
        CASH_INCOME("Cash Income"),
        CASH_WITHDRAWAL("Cash Withdrawal"),
        CASH_SALE("Cash Sale"),
        CASH_ADJUSTMENT("Cash Adjustment"),
        CUSTOMER_REFUND("Customer Refund"),
        PURCHASE_MERCHANDISE("Purchase of Merchandise");

        private final String description;

        Concept(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

    }

    public enum Type {
        INCOME,
        WITHDRAWAL;

        @Override
        public String toString() {
            return this.name().substring(0, 1) + this.name().substring(1).toLowerCase();
        }

    }

    private int id;
    private final int sessionId;
    private LocalDateTime dateTime;
    private final Concept concept;
    private final Type type;
    private double amount;

    public Transaction(int sessionId, Concept concept, Type type) {
        this.sessionId = sessionId;
        this.concept = concept;
        this.type = type;
    }

    public Transaction(int sessionId, Concept concept, Type type, double amount) {
        this.sessionId = sessionId;
        this.concept = concept;
        this.type = type;
        this.amount = amount;
    }

    public void putOnStatement(PreparedStatement statement) throws Exception {
        statement.setInt(1, sessionId);
        statement.setObject(2, LocalDateTime.now());
        statement.setString(3, concept.name());
        statement.setString(4, type.name());
        statement.setDouble(5, amount);
    }

    public double getAmount() {
        return amount;
    }

}