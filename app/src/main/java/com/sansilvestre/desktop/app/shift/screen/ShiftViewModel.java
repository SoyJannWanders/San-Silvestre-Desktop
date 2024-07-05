package com.sansilvestre.desktop.app.shift.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.checkout.domain.usecase.DeleteCheckoutByID;
import com.sansilvestre.desktop.app.checkout.domain.usecase.GetCheckoutList;
import com.sansilvestre.desktop.app.shift.domain.usecase.DeleteShiftByID;
import com.sansilvestre.desktop.app.shift.domain.usecase.GetShiftList;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class ShiftViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private ShiftViewController viewController;

    private final GetShiftList getShiftList;
    private final DeleteShiftByID deleteShiftByID;

    private final GetCheckoutList getCheckoutList;
    private final DeleteCheckoutByID deleteCheckoutByID;

    public ShiftViewModel(
            GetShiftList getShiftList,
            DeleteShiftByID deleteShiftByID,
            GetCheckoutList getCheckoutList,
            DeleteCheckoutByID deleteCheckoutByID
    ) {
        this.getShiftList = getShiftList;
        this.deleteShiftByID = deleteShiftByID;
        this.getCheckoutList = getCheckoutList;
        this.deleteCheckoutByID = deleteCheckoutByID;
    }

    public void setViewController(ShiftViewController viewController) {
        this.viewController = viewController;
    }
    public void onEvent(ShiftEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof ShiftEvent.GetShiftListEvent) {
                    ResponseHandler.handleResponse(getShiftList.execute(), viewStateController, shifts -> {
                        viewController.setShiftList(shifts);
                    });
                } else if (event instanceof ShiftEvent.DeleteShiftByIDEvent) {
                    int shiftId = ((ShiftEvent.DeleteShiftByIDEvent) event).getId();
                    ResponseHandler.handleResponse(deleteShiftByID.execute(shiftId), viewStateController, () -> {
                        int checkoutId = ((ShiftEvent.DeleteShiftByIDEvent) event).getCheckoutId();
                        ResponseHandler.handleResponse(deleteCheckoutByID.execute(checkoutId), viewStateController, () -> {
                            viewController.refresh();
                        });
                    });
                } else if (event instanceof ShiftEvent.GetCheckoutListEvent) {
                    ResponseHandler.handleResponse(getCheckoutList.execute(), viewStateController, checkouts -> {
                        viewController.setCheckoutList(checkouts);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}