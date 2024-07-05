package com.sansilvestre.desktop.app.user.screen.update;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.domain.usecase.UpdateUser;
import com.sansilvestre.desktop.app.user.screen.UserEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class UpdateUserViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private UpdateUserViewController viewController;

    private final UpdateUser updateUser;

    public UpdateUserViewModel(
            UpdateUser updateUser
    ) {
        this.updateUser = updateUser;
    }

    public void setViewController(UpdateUserViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(UserEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof UserEvent.UpdateUserEvent) {
                    User user = ((UserEvent.UpdateUserEvent) event).getUser();
                    ResponseHandler.handleResponse(updateUser.execute(user), viewStateController, () ->
                        viewController.dispose()
                    );
                }
                return null;
            }
        };
        worker.execute();
    }

}