package com.sansilvestre.desktop.app.transaction.domain.usecase;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.transaction.domain.model.Transaction;
import com.sansilvestre.desktop.app.transaction.domain.repository.TransactionRepository;

public class AddTransaction {

    private final TransactionRepository repository;

    public AddTransaction(TransactionRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(Transaction transaction) {
        return repository.addTransaction(transaction);
    }

}