package com.sansilvestre.desktop.app.home.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchMap;
import com.sansilvestre.desktop.app.sale.domain.usecase.GetSaleList;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class HomeViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private HomeViewController viewController;

    private final GetBranchMap getBranchMap;
    private final GetSaleList getSaleList;

    public HomeViewModel(
            GetBranchMap getBranchMap,
            GetSaleList getSaleList
    ) {
        this.getBranchMap = getBranchMap;
        this.getSaleList = getSaleList;
    }

    public void setViewController(HomeViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(HomeEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof HomeEvent.GetMapBranchEvent) {
                    ResponseHandler.handleResponse(getBranchMap.execute(), viewStateController, branches -> {
                        viewController.setBranchMap(branches);
                    });
                } else if (event instanceof HomeEvent.GetSaleListEvent) {
                    ResponseHandler.handleResponse(getSaleList.execute(), viewStateController, sales -> {
                        viewController.setSaleList(sales);
                    });
                } else if (event instanceof HomeEvent.GetNoteListEvent) {

                }
                return null;
            }
        };
        worker.execute();
    }

}