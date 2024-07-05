package com.sansilvestre.desktop.app.branch.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.usecase.DeleteBranchByID;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchList;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchListBySearch;
import com.sansilvestre.desktop.app.branch.domain.util.SetBranchViewController;
import com.sansilvestre.desktop.app.sale.domain.usecase.GetSaleList;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class BranchViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private BranchViewController viewController;

    private final SetBranchViewController setBranchViewController;

    private final GetBranchList getBranchList;
    private final GetBranchListBySearch getBranchListBySearch;

    private final DeleteBranchByID deleteBranchByID;

    public BranchViewModel(
            SetBranchViewController setBranchViewController,
            GetBranchList getBranchList,
            GetBranchListBySearch getBranchListBySearch,
            DeleteBranchByID deleteBranchByID
    ) {
        this.setBranchViewController = setBranchViewController;
        this.getBranchList = getBranchList;
        this.getBranchListBySearch = getBranchListBySearch;
        this.deleteBranchByID = deleteBranchByID;
    }

    public void setViewController(BranchViewController viewController) {
        this.viewController = viewController;
        setBranchViewController.execute(viewController);
    }

    public void onEvent(BranchEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                if (event instanceof BranchEvent.GetBranchListBySearchEvent) {
                    String search = ((BranchEvent.GetBranchListBySearchEvent) event).getSearch();
                    ResponseHandler.handleResponse(getBranchListBySearch.execute(search), viewStateController, branches -> {
                        viewController.setBranchList(branches);
                    });
                } else {
                    viewStateController.isLoading();
                    if (event instanceof BranchEvent.GetBranchListEvent) {
                        ResponseHandler.handleResponse(getBranchList.execute(), viewStateController, branches -> {
                            viewController.setBranchList(branches);
                        });
                    } else if (event instanceof BranchEvent.DeleteBranchByIDEvent) {
                        int id = ((BranchEvent.DeleteBranchByIDEvent) event).getId();
                        ResponseHandler.handleResponse(deleteBranchByID.execute(id), viewStateController, (Runnable) null);
                    }
                }
                return null;
            }
        };
        worker.execute();
    }

}