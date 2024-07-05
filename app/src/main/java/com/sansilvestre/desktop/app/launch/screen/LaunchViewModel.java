package com.sansilvestre.desktop.app.launch.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.shift.domain.usecase.GetShift;
import com.sansilvestre.desktop.app.shift.domain.usecase.GetShiftList;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;
import java.util.function.Consumer;

public class LaunchViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private LaunchViewController viewController;

    private final GetShift getShift;
    private final GetShiftList getShiftList;

    public LaunchViewModel(
            GetShift getShift,
            GetShiftList getShiftList
    ) {
        this.getShift = getShift;
        this.getShiftList = getShiftList;
    }

    public void setViewController(LaunchViewController view) {
        this.viewController = view;
    }

    public void onEvent(LaunchEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof LaunchEvent.GetCurrentShift) {
                    ResponseHandler.handleResponse(getShiftList.execute(), viewStateController, shifts -> {
                        viewController.setShiftList(shifts);
                    });
                } else if (event instanceof LaunchEvent.GetShiftList) {
                    ResponseHandler.handleResponse(getShift.execute(), viewStateController, shift -> {
                        viewController.setShift(shift);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}