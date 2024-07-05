package com.sansilvestre.desktop.app.checkout.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.product.domain.usecase.GetProductByBarcode;
import com.sansilvestre.desktop.app.session.domain.usecase.GetSession;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class CheckoutViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private CheckoutViewController viewController;

    private final GetProductByBarcode getProductByBarcode;

    private final GetSession getSession;

    public CheckoutViewModel(
            GetProductByBarcode getProductByBarcode,
            GetSession getSession
    ) {
        this.getProductByBarcode = getProductByBarcode;
        this.getSession = getSession;
    }

    public void setViewController(CheckoutViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(CheckoutEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof CheckoutEvent.GetProductByBarcodeEvent) {
                    String barcode = ((CheckoutEvent.GetProductByBarcodeEvent) event).getBarcode();
                    ResponseHandler.handleResponse(getProductByBarcode.execute(barcode), viewStateController, product -> {
                        viewController.setItem(new Item(product));
                    });
                } else if (event instanceof CheckoutEvent.GetLastActiveSessionEvent) {
                    ResponseHandler.handleResponse(getSession.execute(), viewStateController, session -> {
                        viewController.setSession(session);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}