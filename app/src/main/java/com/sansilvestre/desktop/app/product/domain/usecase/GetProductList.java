package com.sansilvestre.desktop.app.product.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetProductList {

    private final ProductRepository repository;

    public GetProductList(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<List<Product>> execute() {
        return repository.getProductList();
    }

}