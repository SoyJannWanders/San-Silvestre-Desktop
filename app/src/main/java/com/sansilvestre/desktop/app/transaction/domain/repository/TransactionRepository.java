package com.sansilvestre.desktop.app.transaction.domain.repository;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.transaction.domain.model.Transaction;

public interface TransactionRepository {

    Response<Void> addTransaction(Transaction transaction);

    Response<Double> getTotalAmountBySessionID(int sessionId);

}