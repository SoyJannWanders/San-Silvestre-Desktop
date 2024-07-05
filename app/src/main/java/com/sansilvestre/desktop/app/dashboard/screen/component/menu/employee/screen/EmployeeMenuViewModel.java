package com.sansilvestre.desktop.app.dashboard.screen.component.menu.employee.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.session.domain.usecase.GetSession;
import com.sansilvestre.desktop.app.shift.domain.usecase.GetShift;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class EmployeeMenuViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private EmployeeMenuViewController viewController;

    private final GetShift getShift;
    private final GetSession getSession;

    public EmployeeMenuViewModel(
            GetSession getSession,
            GetShift getShift
    ) {
        this.getSession = getSession;
        this.getShift = getShift;
    }

    public void setViewController(EmployeeMenuViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(EmployeeMenuEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                if (event instanceof EmployeeMenuEvent.GetSessionEvent) {
                    ResponseHandler.handleResponse(getSession.execute(), viewStateController, session -> {
                        viewController.setSession(session);
                    });
                } else if (event instanceof EmployeeMenuEvent.GetShiftEvent) {
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