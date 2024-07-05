package com.sansilvestre.desktop.app.product.screen.add;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.domain.usecase.AddProduct;
import com.sansilvestre.desktop.app.product.screen.ProductEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class AddProductViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private AddProductViewController viewController;

    private final AddProduct addProduct;

    public AddProductViewModel(AddProduct addProduct) {
        this.addProduct = addProduct;
    }

    public void setViewController(AddProductViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(ProductEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof ProductEvent.AddProductEvent) {
                    Product product = ((ProductEvent.AddProductEvent) event).getProduct();
                    ResponseHandler.handleResponse(addProduct.execute(product), viewStateController, () -> {
                        viewController.dispose();
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}