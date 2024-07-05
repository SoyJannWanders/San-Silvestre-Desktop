package com.sansilvestre.desktop.app.product.domain.util;

import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;

public class StopProductSync {

    private final ProductRepository repository;

    public StopProductSync(ProductRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        repository.stopSync();
    }

}