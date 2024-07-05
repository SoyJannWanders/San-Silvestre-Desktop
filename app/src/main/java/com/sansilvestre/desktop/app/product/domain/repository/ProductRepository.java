package com.sansilvestre.desktop.app.product.domain.repository;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.screen.ProductViewController;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.objects.Stock;

import java.util.List;

public interface ProductRepository {

    void setViewController(ProductViewController viewController);

    void startSync();
    void stopSync();

    Response<Product> getProductByBarcode(String barcode);

    Response<List<Product>> getProductList();
    Response<List<Product>> getProductListBySearch(String query);
    Response<List<Product>> getProductListByStock(Stock stock);
    Response<List<Product>> getProductListByCategoryID(int categoryId);
    Response<List<Product>> getProductListByBranchID(int branchId);

    Response<Void> addProduct(Product product);

    Response<Void> updateProduct(Product product);
    Response<Void> updateProductStockByBarcode(int stock, String barcode);
    Response<Void> updateProductPriceByBarcode(double increase, String barcode);
    Response<Void> updateProductsPricesByCategoryID(double increase, int categoryId);
    Response<Void> updateProductsPricesByBranchID(double increase, int branchId);

    Response<Void> deleteProductByBarcode(String barcode);

}