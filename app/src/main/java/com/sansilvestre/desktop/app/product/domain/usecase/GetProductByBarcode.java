package com.sansilvestre.desktop.app.product.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class GetProductByBarcode {

    private final ProductRepository repository;

    public GetProductByBarcode(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<Product> execute(String barcode) {
        return repository.getProductByBarcode(barcode);
    }

}