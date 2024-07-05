package com.sansilvestre.desktop.app.product.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class UpdateProductStockByBarcode {

    private final ProductRepository repository;

    public UpdateProductStockByBarcode(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(String barcode) {
        return repository.updateProductStockByBarcode(1, barcode);
    }

}