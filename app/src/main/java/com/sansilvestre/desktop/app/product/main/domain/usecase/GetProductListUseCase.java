package com.sansilvestre.desktop.app.product.main.domain.usecase;

import com.sansilvestre.desktop.app.product.main.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.util.Response;

import java.util.List;

public class GetProductListUseCase {

    private final ProductRepository repository;

    public GetProductListUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<List<Product>> execute() {
        return repository.getProductList();
    }

}