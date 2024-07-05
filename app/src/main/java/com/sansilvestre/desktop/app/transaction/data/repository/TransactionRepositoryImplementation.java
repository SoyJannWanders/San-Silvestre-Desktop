package com.sansilvestre.desktop.app.transaction.data.repository;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.transaction.data.source.TransactionStorage;
import com.sansilvestre.desktop.app.transaction.domain.model.Transaction;
import com.sansilvestre.desktop.app.transaction.domain.repository.TransactionRepository;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.log.Console;

public class TransactionRepositoryImplementation implements TransactionRepository {

    private final TransactionStorage storage;

    public TransactionRepositoryImplementation(TransactionStorage storage) {
        this.storage = storage;
    }

    @Override
    public Response<Void> addTransaction(Transaction transaction) {
        Response<Void> addTransaction = storage.addTransaction(transaction);
        addTransaction.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: AddTransaction");
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: AddTransaction");
            }

        });
        return addTransaction;
    }

    @Override
    public Response<Double> getTotalAmountBySessionID(int sessionId) {
        Response<Double> getTotalAmount = storage.getTotalAmountBySessionID(sessionId);
        getTotalAmount.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Double> success) {
                Console.info(Console.InfoCode.I001, "OK: GetTotalAmount");
            }

            @Override
            public void visitFailure(Response.Failure<Double> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: GetTotalAmount");
            }

        });
        return getTotalAmount;
    }

}