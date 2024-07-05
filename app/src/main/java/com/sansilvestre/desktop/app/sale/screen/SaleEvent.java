package com.sansilvestre.desktop.app.sale.screen;

import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.transaction.domain.model.Transaction;

public abstract class SaleEvent {

    public static final class GetSaleListByBranchIDEvent extends SaleEvent {

        private final int branchId;

        public GetSaleListByBranchIDEvent(int branchId) {
            this.branchId = branchId;
        }

        public int getBranchId() {
            return branchId;
        }

    }

    public static final class GetSaleItemListBySaleIDEvent extends SaleEvent {

        private final int saleId;

        public GetSaleItemListBySaleIDEvent(int saleId) {
            this.saleId = saleId;
        }

        public int getSaleId() {
            return saleId;
        }

    }



    public static final class AddSaleEvent extends SaleEvent {

        private final Sale sale;
        private final Session session;

        public AddSaleEvent(Sale sale, Session session) {
            this.sale = sale;
            this.session = session;
        }

        public Sale getSale() {
            return sale;
        }

        public Session getSession() {
            return session;
        }

    }



    public static final class AddSaleItemListEvent extends SaleEvent {

        private final int saleId;

        public AddSaleItemListEvent(int saleId) {
            this.saleId = saleId;
        }

        public int getSaleId() {
            return saleId;
        }

    }



    public static final class GetClientListEvent extends SaleEvent {}

    public static final class GetPaymentMethodListEvent extends SaleEvent {}



    public static final class AddTransactionEvent extends SaleEvent {

        private final int sessionId;
        private final Transaction.Concept concept;
        private final Transaction.Type type;
        private final double amount;

        public AddTransactionEvent(int sessionId, Transaction.Concept concept, Transaction.Type type, double amount) {
            this.sessionId = sessionId;
            this.concept = concept;
            this.type = type;
            this.amount = amount;
        }

        public int getSessionId() {
            return sessionId;
        }

        public Transaction.Concept getConcept() {
            return concept;
        }

        public Transaction.Type getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }

    }

}