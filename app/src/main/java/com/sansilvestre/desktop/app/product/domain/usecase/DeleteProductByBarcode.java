package com.sansilvestre.desktop.app.product.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class DeleteProductByBarcode {

    private final ProductRepository repository;

    public DeleteProductByBarcode(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(String barcode) {
        return repository.deleteProductByBarcode(barcode);
    }

}