package com.sansilvestre.desktop.app.user.screen.update;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.user.domain.usecase.UpdateUserSalaryByID;
import com.sansilvestre.desktop.app.user.screen.UserEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class UpdateUserSalaryViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private UpdateUserSalaryViewController viewController;

    private final UpdateUserSalaryByID updateUserSalaryByID;

    public UpdateUserSalaryViewModel(
            UpdateUserSalaryByID updateUserSalaryByID
    ) {
        this.updateUserSalaryByID = updateUserSalaryByID;
    }

    public void setViewController(UpdateUserSalaryViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(UserEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof UserEvent.UpdateUserSalaryByIDEvent) {

                    double salary = ((UserEvent.UpdateUserSalaryByIDEvent) event).getSalary();
                    int id = ((UserEvent.UpdateUserSalaryByIDEvent) event).getId();

                    ResponseHandler.handleResponse(updateUserSalaryByID.execute(salary, id), viewStateController, () -> {
                        viewController.dispose();
                    });

                }
                return null;
            }
        };
        worker.execute();
    }

}