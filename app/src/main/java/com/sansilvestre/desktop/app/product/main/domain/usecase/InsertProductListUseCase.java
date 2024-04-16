package com.sansilvestre.desktop.app.product.main.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.main.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.util.Response;

import java.util.List;

public class InsertProductListUseCase {

    private final ProductRepository repository;

    public InsertProductListUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(List<Product> list) {
        if (!list.isEmpty()) {
            return repository.addProductList(list);
        }
        return new Response.Failure<>("Error Lista Vacia");
    }

}