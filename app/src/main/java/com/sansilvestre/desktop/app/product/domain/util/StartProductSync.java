package com.sansilvestre.desktop.app.product.domain.util;

import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;

public class StartProductSync {

    private final ProductRepository repository;

    public StartProductSync(ProductRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        repository.startSync();
    }

}