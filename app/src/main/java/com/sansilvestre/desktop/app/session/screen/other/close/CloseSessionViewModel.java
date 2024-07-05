package com.sansilvestre.desktop.app.session.screen.other.close;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.session.domain.usecase.CloseSession;
import com.sansilvestre.desktop.app.session.screen.SessionEvent;
import com.sansilvestre.desktop.app.transaction.domain.model.Transaction;
import com.sansilvestre.desktop.app.transaction.domain.usecase.AddTransaction;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class CloseSessionViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private CloseSessionViewController viewController;

    private final CloseSession closeSession;

    private final AddTransaction addTransaction;

    public CloseSessionViewModel(
            CloseSession closeSession,
            AddTransaction addTransaction
    ) {
        this.closeSession = closeSession;
        this.addTransaction = addTransaction;
    }

    public void setViewController(CloseSessionViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(SessionEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof SessionEvent.CloseSessionEvent) {
                    int id = ((SessionEvent.CloseSessionEvent) event).getId();
                    double closeAmount = ((SessionEvent.CloseSessionEvent) event).getCloseAmount();
                    ResponseHandler.handleResponse(closeSession.execute(id), viewStateController, () -> {
                        Transaction transaction = new Transaction(id, Transaction.Concept.CLOSE_CHECKOUT, Transaction.Type.WITHDRAWAL, closeAmount * -1);
                        ResponseHandler.handleResponse(addTransaction.execute(transaction), viewStateController, () -> {
                            viewController.closeSession();
                        });
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}