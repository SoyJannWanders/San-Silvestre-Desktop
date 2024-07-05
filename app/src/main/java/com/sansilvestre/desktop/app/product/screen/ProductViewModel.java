package com.sansilvestre.desktop.app.product.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchMap;
import com.sansilvestre.desktop.app.category.domain.usecase.GetCategoryMap;
import com.sansilvestre.desktop.app.product.domain.usecase.DeleteProductByBarcode;
import com.sansilvestre.desktop.app.product.domain.usecase.*;
import com.sansilvestre.desktop.app.product.domain.util.SetProductViewController;
import com.sansilvestre.desktop.app.product.domain.util.StartProductSync;
import com.sansilvestre.desktop.app.product.domain.util.StopProductSync;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class ProductViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private ProductViewController viewController;

    private final SetProductViewController setProductViewController;

    private final StartProductSync startProductSync;
    private final StopProductSync stopProductSync;

    private final GetProductList getProductList;
    private final GetProductListBySearch getProductListBySearch;
    private final GetProductListByCategoryID getProductListByCategoryID;
    private final GetProductListByBranchID getProductListByBranchID;

    private final DeleteProductByBarcode deleteProductByBarcode;

    private final GetCategoryMap getCategoryMap;
    private final GetBranchMap getBranchMap;

    public ProductViewModel(
            SetProductViewController setProductViewController,
            StartProductSync startProductSync,
            StopProductSync stopProductSync,
            GetProductList getProductList,
            GetProductListBySearch getProductListBySearch,
            GetProductListByCategoryID getProductListByCategoryID,
            GetProductListByBranchID getProductListByBranchID,
            DeleteProductByBarcode deleteProductByBarcode,
            GetCategoryMap getCategoryMap,
            GetBranchMap getBranchMap
    ) {
        this.setProductViewController = setProductViewController;
        this.startProductSync = startProductSync;
        this.stopProductSync = stopProductSync;
        this.getProductList = getProductList;
        this.getProductListBySearch = getProductListBySearch;
        this.getProductListByCategoryID = getProductListByCategoryID;
        this.getProductListByBranchID = getProductListByBranchID;
        this.deleteProductByBarcode = deleteProductByBarcode;
        this.getCategoryMap = getCategoryMap;
        this.getBranchMap = getBranchMap;
    }

    public void setViewController(ProductViewController controller) {
        this.viewController = controller;
        setProductViewController.execute(controller);
    }

    public void onEvent(ProductEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                if (event instanceof ProductEvent.InitializeListenersEvent) {
                    viewController.initializeListeners();
                } else if (event instanceof ProductEvent.GetProductListBySearchEvent) {
                    String search = ((ProductEvent.GetProductListBySearchEvent) event).getSearch();
                    ResponseHandler.handleResponse(getProductListBySearch.execute(search), viewStateController, products -> {
                        viewController.setProductList(products);
                    });
                } else {
                    viewStateController.isLoading();
                    if (event instanceof ProductEvent.GetProductListEvent) {
                        ResponseHandler.handleResponse(getProductList.execute(), viewStateController, products -> {
                            viewController.setProductList(products);
                        });
                    } else if (event instanceof ProductEvent.GetProductListByCategoryIDEvent) {
                        int categoryId = ((ProductEvent.GetProductListByCategoryIDEvent) event).getCategoryId();
                        ResponseHandler.handleResponse(getProductListByCategoryID.execute(categoryId), viewStateController, products -> {
                            viewController.setProductList(products);
                        });
                    } else if (event instanceof ProductEvent.GetProductListByBranchIDEvent) {
                        int branchId = ((ProductEvent.GetProductListByBranchIDEvent) event).getBranchId();
                        ResponseHandler.handleResponse(getProductListByBranchID.execute(branchId), viewStateController, products -> {
                            viewController.setProductList(products);
                        });
                    } else if (event instanceof ProductEvent.DeleteProductByBarcodeEvent) {
                        String barcode = ((ProductEvent.DeleteProductByBarcodeEvent) event).getBarcode();
                        ResponseHandler.handleResponse(deleteProductByBarcode.execute(barcode), viewStateController, (Runnable) null);
                    } else if (event instanceof ProductEvent.GetStockListEvent) {

                    } else if (event instanceof ProductEvent.GetCategoryMapEvent) {
                        ResponseHandler.handleResponse(getCategoryMap.execute(), viewStateController, categories -> {
                            viewController.setCategoryMap(categories);
                        });
                    } else if (event instanceof ProductEvent.GetBranchMapEvent) {
                        ResponseHandler.handleResponse(getBranchMap.execute(), viewStateController, branches -> {
                            viewController.setBranchMap(branches);
                        });
                    }
                }
                return null;
            }
        };
        worker.execute();
    }

    private Sync syncInstance;

    public Sync getSyncInstance() {
        if (syncInstance == null)
            syncInstance = new Sync();
        return syncInstance;
    }

    public class Sync {

        public void start() {
            startProductSync.execute();
        }

        public void stop() {
            stopProductSync.execute();
        }

    }

}