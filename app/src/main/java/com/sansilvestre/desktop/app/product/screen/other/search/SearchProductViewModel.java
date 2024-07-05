package com.sansilvestre.desktop.app.product.screen.other.search;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.product.domain.usecase.GetProductList;
import com.sansilvestre.desktop.app.product.domain.usecase.GetProductListBySearch;
import com.sansilvestre.desktop.app.product.screen.ProductEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class SearchProductViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private SearchProductViewController viewController;

    private final GetProductList getProductList;
    private final GetProductListBySearch getProductListBySearch;

    public SearchProductViewModel(
            GetProductList getProductList,
            GetProductListBySearch getProductListBySearch
    ) {
        this.getProductList = getProductList;
        this.getProductListBySearch = getProductListBySearch;
    }

    public void setViewController(SearchProductViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(ProductEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                if (event instanceof ProductEvent.GetProductListBySearchEvent) {
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
                    }
                }
                return null;
            }
        };
        worker.execute();
    }

}