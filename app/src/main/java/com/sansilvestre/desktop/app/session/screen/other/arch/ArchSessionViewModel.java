package com.sansilvestre.desktop.app.session.screen.other.arch;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.session.domain.usecase.CloseSession;
import com.sansilvestre.desktop.app.session.domain.usecase.OpenSession;
import com.sansilvestre.desktop.app.session.screen.SessionEvent;
import com.sansilvestre.desktop.app.transaction.domain.model.Transaction;
import com.sansilvestre.desktop.app.transaction.domain.usecase.AddTransaction;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class ArchSessionViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private ArchSessionViewController viewController;

    private final OpenSession openSession;
    private final CloseSession closeSession;

    private final AddTransaction addTransaction;

    public ArchSessionViewModel(
            OpenSession openSession,
            CloseSession closeSession,
            AddTransaction addTransaction
    ) {
        this.openSession = openSession;
        this.closeSession = closeSession;
        this.addTransaction = addTransaction;
    }

    public void setViewController(ArchSessionViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(SessionEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof SessionEvent.ArchSessionEvent) {
                    int sessionId = ((SessionEvent.ArchSessionEvent) event).getId();
                    int checkoutId = ((SessionEvent.ArchSessionEvent) event).getCheckoutId();
                    double openAmount = ((SessionEvent.ArchSessionEvent) event).getOpenAmount();
                    double closeAmount = ((SessionEvent.ArchSessionEvent) event).getCloseAmount();
                    ResponseHandler.handleResponse(closeSession.execute(sessionId), viewStateController, () -> {
                        Transaction closeTransaction = new Transaction(sessionId, Transaction.Concept.CLOSE_CHECKOUT, Transaction.Type.WITHDRAWAL, closeAmount * -1);
                        ResponseHandler.handleResponse(addTransaction.execute(closeTransaction), viewStateController, () -> {
                            ResponseHandler.handleResponse(openSession.execute(checkoutId), viewStateController, id -> {
                                Transaction openTransaction = new Transaction(id, Transaction.Concept.OPEN_CHECKOUT, Transaction.Type.INCOME, openAmount);
                                ResponseHandler.handleResponse(addTransaction.execute(openTransaction), viewStateController, () -> {
                                    viewController.archSession();
                                });
                            });
                        });
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}