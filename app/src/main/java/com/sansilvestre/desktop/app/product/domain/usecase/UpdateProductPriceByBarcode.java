package com.sansilvestre.desktop.app.product.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class UpdateProductPriceByBarcode {

    private final ProductRepository repository;

    public UpdateProductPriceByBarcode(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(double percentage) {
        return repository.updateProductPriceByBarcode(percentage, "");
    }

}