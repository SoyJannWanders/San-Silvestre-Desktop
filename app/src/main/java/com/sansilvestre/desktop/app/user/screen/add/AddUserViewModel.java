package com.sansilvestre.desktop.app.user.screen.add;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.user.screen.UserEvent;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.domain.usecase.AddUser;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class AddUserViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private AddUserViewController viewController;

    private final AddUser addUser;

    public AddUserViewModel(
            AddUser addUser
    ) {
        this.addUser = addUser;
    }

    public void setViewController(AddUserViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(UserEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof UserEvent.AddUserEvent) {
                    User user = ((UserEvent.AddUserEvent) event).getUser();
                    ResponseHandler.handleResponse(addUser.execute(user), viewStateController, () -> {
                        viewController.dispose();
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}