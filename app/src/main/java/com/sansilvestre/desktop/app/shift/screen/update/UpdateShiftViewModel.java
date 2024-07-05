package com.sansilvestre.desktop.app.shift.screen.update;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchMap;
import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.checkout.domain.usecase.UpdateCheckout;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.shift.domain.usecase.UpdateShift;
import com.sansilvestre.desktop.app.shift.screen.ShiftEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class UpdateShiftViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private UpdateShiftViewController viewController;

    private final UpdateShift updateShift;

    private final UpdateCheckout updateCheckout;

    private final GetBranchMap getBranchMap;

    public UpdateShiftViewModel(
            UpdateShift updateShift,
            UpdateCheckout updateCheckout,
            GetBranchMap getBranchMap
    ) {
        this.updateShift = updateShift;
        this.updateCheckout = updateCheckout;
        this.getBranchMap = getBranchMap;
    }

    public void setViewController(UpdateShiftViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(ShiftEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof ShiftEvent.UpdateShiftEvent) {
                    Checkout checkout = ((ShiftEvent.UpdateShiftEvent) event).getCheckout();
                    ResponseHandler.handleResponse(updateCheckout.execute(checkout), viewStateController, () -> {
                        Shift shift = ((ShiftEvent.UpdateShiftEvent) event).getShift();
                        ResponseHandler.handleResponse(updateShift.execute(shift), viewStateController, () -> {
                            viewController.dispose();
                        });
                    });
                } else if (event instanceof ShiftEvent.GetBranchMapEvent) {
                    ResponseHandler.handleResponse(getBranchMap.execute(), viewStateController, branches -> {
                        viewController.setBranchMap(branches);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}