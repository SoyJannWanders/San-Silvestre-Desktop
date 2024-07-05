package com.sansilvestre.desktop.app.session.screen.other.swap;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.session.screen.SessionEvent;
import com.sansilvestre.desktop.app.transaction.domain.usecase.GetTotalAmountBySessionID;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class SwapSessionViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private SwapSessionViewController viewController;

    private final GetTotalAmountBySessionID getTotalAmountBySessionID;

    public SwapSessionViewModel(
            GetTotalAmountBySessionID getTotalAmountBySessionID
    ) {
        this.getTotalAmountBySessionID = getTotalAmountBySessionID;
    }

    public void setViewController(SwapSessionViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(SessionEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof SessionEvent.GetTotalAmountBySessionIDEvent) {
                    int id = ((SessionEvent.GetTotalAmountBySessionIDEvent) event).getId();
                    ResponseHandler.handleResponse(getTotalAmountBySessionID.execute(id), viewStateController, closeAmount -> {
                        viewController.setCloseAmount(closeAmount);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}