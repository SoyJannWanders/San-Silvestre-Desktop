package com.sansilvestre.desktop.app.branch.screen.add;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.domain.usecase.AddBranch;
import com.sansilvestre.desktop.app.branch.screen.BranchEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class AddBranchViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private AddBranchViewController viewController;

    private final AddBranch addBranch;

    public AddBranchViewModel(
            AddBranch addBranch
    ) {
        this.addBranch = addBranch;
    }

    public void setViewController(AddBranchViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(BranchEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof BranchEvent.AddBranchEvent) {
                    Branch branch = ((BranchEvent.AddBranchEvent) event).getBranch();
                    ResponseHandler.handleResponse(addBranch.execute(branch), viewStateController, () -> {
                        viewController.dispose();
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}