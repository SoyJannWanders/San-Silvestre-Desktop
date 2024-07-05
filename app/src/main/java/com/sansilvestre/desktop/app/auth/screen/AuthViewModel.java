package com.sansilvestre.desktop.app.auth.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.auth.domain.usecase.SignIn;
import com.sansilvestre.desktop.app.auth.screen.AuthEvent;
import com.sansilvestre.desktop.app.auth.screen.AuthViewController;
import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class AuthViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private AuthViewController viewController;

    private final SignIn signIn;

    public AuthViewModel(
            SignIn signIn
    ) {
        this.signIn = signIn;
    }

    public void setViewController(AuthViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(AuthEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof AuthEvent.SignInEvent) {
                    int id = ((AuthEvent.SignInEvent) event).getId();
                    String password = ((AuthEvent.SignInEvent) event).getPassword();
                    ResponseHandler.handleResponse(signIn.execute(id, password), viewStateController, role -> {
                        viewController.setRole(Role.valueOf(role));
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}