package com.sansilvestre.desktop.app.product.main.data.repository;

import com.sansilvestre.desktop.app.product.main.data.source.local.ProductStorage;
import com.sansilvestre.desktop.app.product.main.data.source.remote.ProductApi;
import com.sansilvestre.desktop.app.product.main.data.source.remote.SyncTask;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.main.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.util.Response;

import java.util.List;

public class ProductRepositoryImplementation implements ProductRepository {

    private final ProductStorage storage;
    private final ProductApi api;

    public ProductRepositoryImplementation(ProductStorage storage, ProductApi api) {
        this.storage = storage;
        this.api = api;
    }

    @Override
    public Response<List<Product>> searchProduct(String query) {
        Response<List<Product>> response = api.searchProduct(query);
        if (response instanceof Response.Failure<List<Product>>) {
            response = storage.searchProduct(query);
            if (response instanceof Response.Failure<List<Product>>) {
                return new Response.Failure<>("Code 302: ");
            }
        }
        return response;
    }

    @Override
    public Response<List<Product>> getProductList() {
        Response<List<Product>> response = api.getProductList();
        if (response instanceof Response.Failure<List<Product>>) {
            response = storage.getProductList();
            if (response instanceof Response.Failure<List<Product>>) {
                return new Response.Failure<>("Code 301: ");
            }
        }
        return response;
    }

    @Override
    public Response<List<Product>> getProductListByOffice(int OID) {
        return null;
    }

    @Override
    public Response<Void> addProduct(Product product) {
        Response<Void> storageResponse = storage.insertProduct(product);
        if (storageResponse instanceof Response.Success<Void>) {
            SyncTask.getInstance().execute(() -> {
                Response<Void> apiResponse = api.insert(product);
                if (apiResponse instanceof Response.Failure<Void>) {
                }
            });
            return storageResponse;
        }
        return storageResponse; // storageResponse instanceOf Response.Failure<Void>
    }

}