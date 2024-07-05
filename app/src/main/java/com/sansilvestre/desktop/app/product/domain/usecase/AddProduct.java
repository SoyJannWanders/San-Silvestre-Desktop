package com.sansilvestre.desktop.app.product.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class AddProduct {

    private final ProductRepository repository;

    public AddProduct(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(Product product) {
        return repository.addProduct(product);
    }

}