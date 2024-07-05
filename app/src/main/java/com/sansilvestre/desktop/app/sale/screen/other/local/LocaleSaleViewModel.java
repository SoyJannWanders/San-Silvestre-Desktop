package com.sansilvestre.desktop.app.sale.screen.other.local;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.sale.domain.usecase.GetSaleItemListBySaleID;
import com.sansilvestre.desktop.app.sale.domain.usecase.GetSaleListByBranchID;
import com.sansilvestre.desktop.app.sale.screen.SaleEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class LocaleSaleViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private LocaleSaleViewController viewController;

    private final GetSaleListByBranchID getSaleListByBranchID;
    private final GetSaleItemListBySaleID getSaleItemListBySaleID;

    public LocaleSaleViewModel(
            GetSaleListByBranchID getSaleListByBranchID,
            GetSaleItemListBySaleID getSaleItemListBySaleID
    ) {
        this.getSaleListByBranchID = getSaleListByBranchID;
        this.getSaleItemListBySaleID = getSaleItemListBySaleID;
    }

    public void setViewController(LocaleSaleViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(SaleEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof SaleEvent.GetSaleListByBranchIDEvent) {
                    int branchId = ((SaleEvent.GetSaleListByBranchIDEvent) event).getBranchId();
                    ResponseHandler.handleResponse(getSaleListByBranchID.execute(branchId), viewStateController, sales -> {
                        viewController.setSaleList(sales);
                    });
                } else if (event instanceof SaleEvent.GetSaleItemListBySaleIDEvent) {
                    int saleId = ((SaleEvent.GetSaleItemListBySaleIDEvent) event).getSaleId();
                    ResponseHandler.handleResponse(getSaleItemListBySaleID.execute(saleId), viewStateController, items -> {
                        viewController.setItemList(items);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}