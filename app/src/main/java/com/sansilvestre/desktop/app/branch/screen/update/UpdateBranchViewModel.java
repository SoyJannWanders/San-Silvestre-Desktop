package com.sansilvestre.desktop.app.branch.screen.update;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.domain.usecase.UpdateBranch;
import com.sansilvestre.desktop.app.branch.screen.BranchEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class UpdateBranchViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private UpdateBranchViewController viewController;

    private final UpdateBranch updateBranch;

    public UpdateBranchViewModel(
            UpdateBranch updateBranch
    ) {
        this.updateBranch = updateBranch;
    }

    public void setViewController(UpdateBranchViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(BranchEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof BranchEvent.UpdateBranchEvent) {
                    Branch branch = ((BranchEvent.UpdateBranchEvent) event).getBranch();
                    ResponseHandler.handleResponse(updateBranch.execute(branch), viewStateController, () -> {
                        viewController.dispose();
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}