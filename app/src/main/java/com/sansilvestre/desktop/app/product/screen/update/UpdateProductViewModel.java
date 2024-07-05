package com.sansilvestre.desktop.app.product.screen.update;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.domain.usecase.UpdateProduct;
import com.sansilvestre.desktop.app.product.screen.ProductEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class UpdateProductViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private UpdateProductViewController viewController;

    private final UpdateProduct updateProduct;

    public UpdateProductViewModel(
            UpdateProduct updateProduct
    ) {
        this.updateProduct = updateProduct;
    }

    public void setViewController(UpdateProductViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(ProductEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof ProductEvent.UpdateProductEvent) {
                    Product product = ((ProductEvent.UpdateProductEvent) event).getProduct();
                    ResponseHandler.handleResponse(updateProduct.execute(product), viewStateController, () -> {
                        viewController.dispose();
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}