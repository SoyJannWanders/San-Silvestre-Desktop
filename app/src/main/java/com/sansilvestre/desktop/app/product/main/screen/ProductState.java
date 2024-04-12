package com.sansilvestre.desktop.app.product.main.screen;

import com.sansilvestre.desktop.app.product.domain.model.Product;

import java.util.List;

public interface ProductState {

    void fetchProductList(List<Product> list);

}