package com.sansilvestre.desktop.app.shift.screen.add;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchList;
import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.checkout.domain.usecase.AddCheckout;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.shift.domain.usecase.AddShift;
import com.sansilvestre.desktop.app.shift.screen.ShiftEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class AddShiftViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private AddShiftViewController viewController;

    private final AddShift addShift;

    private final AddCheckout addCheckout;

    private final GetBranchList getBranchList;

    public AddShiftViewModel(
            AddShift addShift,
            AddCheckout addCheckout,
            GetBranchList getBranchList
    ) {
        this.addShift = addShift;
        this.addCheckout = addCheckout;
        this.getBranchList = getBranchList;
    }

    public void setViewController(AddShiftViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(ShiftEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof ShiftEvent.AddShiftEvent) {
                    Checkout checkout = ((ShiftEvent.AddShiftEvent) event).getCheckout();
                    ResponseHandler.handleResponse(addCheckout.execute(checkout), viewStateController, id -> {
                        Shift shift = ((ShiftEvent.AddShiftEvent) event).getShift();
                        shift.setCheckoutId(id);
                        ResponseHandler.handleResponse(addShift.execute(shift), viewStateController, () -> {
                            viewController.dispose();
                        });
                    });
                } else if (event instanceof ShiftEvent.GetBranchListEvent) {
                    ResponseHandler.handleResponse(getBranchList.execute(), viewStateController, branches -> {
                        viewController.setBranchList(branches);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}