package com.sansilvestre.desktop.app.product.main.screen;

import com.sansilvestre.desktop.app.product.main.domain.model.ProductTableModel;

import java.util.List;

public interface ProductState {

    void onGetProductList(List<ProductTableModel> list);
    void onProductSelected(ProductTableModel data);

}