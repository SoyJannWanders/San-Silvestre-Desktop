package com.sansilvestre.desktop.app.session.screen.other.open;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.session.screen.SessionEvent;
import com.sansilvestre.desktop.app.session.domain.usecase.OpenSession;
import com.sansilvestre.desktop.app.transaction.domain.model.Transaction;
import com.sansilvestre.desktop.app.transaction.domain.usecase.AddTransaction;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class OpenSessionViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private OpenSessionViewController viewController;

    private final OpenSession openSession;

    private final AddTransaction addTransaction;

    public OpenSessionViewModel(OpenSession openSession, AddTransaction addTransaction) {
        this.openSession = openSession;
        this.addTransaction = addTransaction;
    }

    public void setViewController(OpenSessionViewController controller) {
        this.viewController = controller;
    }

    public void onEvent(SessionEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof SessionEvent.OpenSessionEvent) {
                    double amount = ((SessionEvent.OpenSessionEvent) event).getOpenAmount();
                    int checkoutId = ((SessionEvent.OpenSessionEvent) event).getCheckoutId();
                    ResponseHandler.handleResponse(openSession.execute(checkoutId), viewStateController, id -> {
                        Transaction transaction = new Transaction(id, Transaction.Concept.OPEN_CHECKOUT, Transaction.Type.INCOME, amount);
                        ResponseHandler.handleResponse(addTransaction.execute(transaction), viewStateController, () -> {
                            viewController.openSession();
                        });
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}