package com.sansilvestre.desktop.app.product.main.module;

import com.sansilvestre.desktop.app.product.main.data.repository.ProductRepositoryImplementation;
import com.sansilvestre.desktop.app.product.main.data.source.local.ProductStorage;
import com.sansilvestre.desktop.app.product.main.data.source.remote.ProductApi;
import com.sansilvestre.desktop.app.product.main.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.add.domain.usecase.InsertProductUseCase;
import com.sansilvestre.desktop.app.product.add.screen.AddProductViewModel;
import com.sansilvestre.desktop.app.product.main.domain.usecase.GetProductListUseCase;
import com.sansilvestre.desktop.app.product.main.domain.usecase.SearchProductUseCase;
import com.sansilvestre.desktop.app.product.main.screen.ProductViewModel;

public class ProductModule {

    private static ProductModule instance;

    private ProductModule() {}

    public static ProductModule getInstance() {
        if (instance == null) {
            instance = new ProductModule();
        }
        return instance;
    }

    public AddProductViewModel provideAddProductViewModel() {
        return new AddProductViewModel(provideInsertProduct());
    }

    public ProductViewModel provideProductViewModel() {
        return new ProductViewModel(provideSearchProductUseCase(), provideGetProductListUseCase());
    }

    public SearchProductUseCase provideSearchProductUseCase() {
        return new SearchProductUseCase(provideProductRepository());
    }

    public GetProductListUseCase provideGetProductListUseCase() {
        return new GetProductListUseCase(provideProductRepository());
    }

    public InsertProductUseCase provideInsertProduct() {
        return new InsertProductUseCase(provideProductRepository());
    }

    public ProductRepository provideProductRepository() {
        return new ProductRepositoryImplementation(provideProductStorage(), provideProductApi());
    }

    public ProductStorage provideProductStorage() {
        return new ProductStorage();
    }

    public ProductApi provideProductApi() {
        return new ProductApi();
    }

}