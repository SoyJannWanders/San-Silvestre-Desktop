package com.sansilvestre.desktop.app.sale.domain.model;

import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.sale.data.source.SaleDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class Sale {

    private int id;
    private List<Item> items;
    private int clientId;
    private double total;
    private double cash;
    private double transfer;
    private double qrCode;
    private double debit;
    private double credit;
    private int checkoutId;
    private int branchId;
    private LocalDateTime createdAt;

    public Sale(ResultSet result) throws SQLException {
        id = result.getInt(SaleDatabase.ID.getColumnName());
        clientId = result.getInt(SaleDatabase.CLIENT_ID.getColumnName());
        total = result.getDouble(SaleDatabase.TOTAL.getColumnName());
        cash = result.getDouble(SaleDatabase.CASH_PAYMENT.getColumnName());
        transfer = result.getDouble(SaleDatabase.TRANSFER_PAYMENT.getColumnName());
        qrCode = result.getDouble(SaleDatabase.QR_CODE_PAYMENT.getColumnName());
        debit = result.getDouble(SaleDatabase.DEBIT_PAYMENT.getColumnName());
        credit = result.getDouble(SaleDatabase.CREDIT_PAYMENT.getColumnName());
        checkoutId = result.getInt(SaleDatabase.CHECKOUT_ID.getColumnName());
        branchId = result.getInt(SaleDatabase.BRANCH_ID.getColumnName());
        createdAt = result.getTimestamp(SaleDatabase.CREATED_AT.getColumnName()).toLocalDateTime();
    }

    public Sale(int clientId, List<Item> items, double total, double cash, double transfer, double qrCode, double debit, double credit, int checkoutId, int branchId) {
        this.clientId = clientId;
        this.items = items;
        this.total = total;
        this.cash = cash;
        this.transfer = transfer;
        this.qrCode = qrCode;
        this.debit = debit;
        this.credit = credit;
        this.checkoutId = checkoutId;
        this.branchId = branchId;
    }

    public void populateStatement(PreparedStatement statement) throws SQLException {
        statement.setInt(1, clientId);
        statement.setDouble(2, total);
        statement.setDouble(3, cash);
        statement.setDouble(4, transfer);
        statement.setDouble(5, qrCode);
        statement.setDouble(6, debit);
        statement.setDouble(7, credit);
        statement.setInt(8, checkoutId);
        statement.setInt(9, branchId);
    }

    public double getTotalWithDiscount() {
        return total * 0.9;
    }

    public boolean hasDiscount() {
        if (cash != 0) {
            if (cash >= getTotalWithDiscount())
                return true;
            return cash + transfer + qrCode + debit + credit == getTotalWithDiscount();
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItemList() {
        return items;
    }

    public void setItemList(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public double getCash() {
        return cash;
    }

    public double getTransfer() {
        return transfer;
    }

    public double getQrCode() {
        return qrCode;
    }

    public double getDebit() {
        return debit;
    }

    public double getCredit() {
        return credit;
    }

    public int getBranchId() {
        return branchId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}