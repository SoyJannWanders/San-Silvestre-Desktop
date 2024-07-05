package com.sansilvestre.desktop.app.product.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class UpdateProductsPricesByCategoryID {

    private final ProductRepository repository;

    public UpdateProductsPricesByCategoryID(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(double percentage, int category) {
        return repository.updateProductsPricesByCategoryID(percentage, category);
    }

}