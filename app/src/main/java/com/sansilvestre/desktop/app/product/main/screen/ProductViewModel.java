package com.sansilvestre.desktop.app.product.main.screen;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.main.domain.model.ProductTableModel;
import com.sansilvestre.desktop.app.product.main.domain.model.ProductTableModelList;
import com.sansilvestre.desktop.app.product.main.domain.usecase.GetProductListUseCase;
import com.sansilvestre.desktop.app.product.main.domain.usecase.SearchProductUseCase;
import com.sansilvestre.desktop.app.product.util.Billing;
import com.sansilvestre.desktop.app.product.util.Response;

import java.util.ArrayList;
import java.util.List;

public class ProductViewModel {

    private ProductState state;

    private final SearchProductUseCase searchProductUseCase;

    private final GetProductListUseCase getProductListUseCase;

    private final Billing billing = new Billing();

    public ProductViewModel(
            SearchProductUseCase searchProductUseCase,
            GetProductListUseCase getProductListUseCase) {
        this.searchProductUseCase = searchProductUseCase;
        this.getProductListUseCase = getProductListUseCase;
    }

    public void setState(ProductState state) {
        this.state = state;
    }

    public void onEvent(ProductEvent event) {
        if (event instanceof ProductEvent.GetProductList) {
            Response<List<Product>> response = getProductListUseCase.execute();
            if (response instanceof Response.Success<List<Product>>) {
                List<Product> products = ((Response.Success<List<Product>>) response).getObject();
                state.onGetProductList(ProductTableModelList.valueOf(products));
            }
            if (response instanceof Response.Failure<List<Product>>) {
                System.out.println(((Response.Failure<List<Product>>) response).getException());
            }
        }
        if (event instanceof ProductEvent.GetProductWithQuery) {
            Response<List<Product>> response = searchProductUseCase.execute(((ProductEvent.GetProductWithQuery) event).getQuery());
            if (response instanceof Response.Success<List<Product>>) {
                List<Product> products = ((Response.Success<List<Product>>) response).getObject();
                state.onGetProductList(ProductTableModelList.valueOf(products));
            }
            if (response instanceof Response.Failure<List<Product>>) {
                System.out.println(((Response.Failure<List<Product>>) response).getException());
            }
        }
    }

}