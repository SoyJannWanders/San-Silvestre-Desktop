package com.sansilvestre.desktop.app.product.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetProductListByCategoryID {

    private final ProductRepository repository;

    public GetProductListByCategoryID(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<List<Product>> execute(int categoryId) {
        return repository.getProductListByCategoryID(categoryId);
    }

}