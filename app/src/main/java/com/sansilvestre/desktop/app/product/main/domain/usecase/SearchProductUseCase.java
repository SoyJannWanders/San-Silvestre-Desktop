package com.sansilvestre.desktop.app.product.main.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.main.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.util.Response;

import java.util.List;

public class SearchProductUseCase {

    private final ProductRepository repository;

    public SearchProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<List<Product>> execute(String query) {
        return repository.searchProduct(query);
    }

}