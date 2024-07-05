package com.sansilvestre.desktop.app.user.screen.update;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.user.domain.usecase.UpdateUsersSalariesByBranchID;
import com.sansilvestre.desktop.app.user.screen.UserEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;
import com.sansilvestre.desktop.app.util.objects.IncreaseType;

import javax.swing.*;

public class UpdateUsersSalariesViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private UpdateUsersSalariesViewController viewController;

    private final UpdateUsersSalariesByBranchID updateUsersSalariesByBranchID;

    public UpdateUsersSalariesViewModel(
            UpdateUsersSalariesByBranchID updateUsersSalariesByBranchID
    ) {
        this.updateUsersSalariesByBranchID = updateUsersSalariesByBranchID;
    }

    public void setViewController(UpdateUsersSalariesViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(UserEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof UserEvent.UpdateUsersSalariesByBranchIDEvent) {

                    IncreaseType increaseType = ((UserEvent.UpdateUsersSalariesByBranchIDEvent) event).getIncreaseType();
                    double increase = ((UserEvent.UpdateUsersSalariesByBranchIDEvent) event).getIncrease();
                    int branchId = ((UserEvent.UpdateUsersSalariesByBranchIDEvent) event).getBranchId();

                    ResponseHandler.handleResponse(updateUsersSalariesByBranchID.execute(increaseType, increase, branchId), viewStateController, () -> {
                        viewController.dispose();
                    });

                }
                return null;
            }
        };
        worker.execute();
    }

}