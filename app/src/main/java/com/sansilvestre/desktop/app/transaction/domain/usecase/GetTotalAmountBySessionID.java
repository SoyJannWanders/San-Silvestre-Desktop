package com.sansilvestre.desktop.app.transaction.domain.usecase;

import com.sansilvestre.desktop.app.transaction.domain.repository.TransactionRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class GetTotalAmountBySessionID {

    private final TransactionRepository repository;

    public GetTotalAmountBySessionID(TransactionRepository repository) {
        this.repository = repository;
    }

    public Response<Double> execute(int sessionId) {
        return repository.getTotalAmountBySessionID(sessionId);
    }

}