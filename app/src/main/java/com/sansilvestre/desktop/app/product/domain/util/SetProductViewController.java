package com.sansilvestre.desktop.app.product.domain.util;

import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.screen.ProductViewController;

public class SetProductViewController {

    private final ProductRepository repository;

    public SetProductViewController(ProductRepository repository) {
        this.repository = repository;
    }

    public void execute(ProductViewController controller) {
        repository.setViewController(controller);
    }

}