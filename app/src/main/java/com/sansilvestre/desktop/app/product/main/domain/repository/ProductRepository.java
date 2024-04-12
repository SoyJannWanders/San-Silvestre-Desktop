package com.sansilvestre.desktop.app.product.main.domain.repository;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.util.Response;

import java.util.List;

public interface ProductRepository {

    Response<List<Product>> searchProduct(String query);

    Response<List<Product>> getProductList();
    Response<List<Product>> getProductListByOffice(int OID);

    Response<Void> addProduct(Product product);

}