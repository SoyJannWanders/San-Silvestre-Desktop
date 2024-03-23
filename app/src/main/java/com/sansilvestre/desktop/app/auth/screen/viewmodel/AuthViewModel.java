package com.sansilvestre.desktop.app.auth.screen.viewmodel;

import com.sansilvestre.desktop.app.auth.domain.usecase.SignIn;
import com.sansilvestre.desktop.app.auth.screen.AuthEvent;
import com.sansilvestre.desktop.app.auth.screen.viewmodel.callback.SignInCallback;

public class AuthViewModel {

    private AuthEvent event;

    private final SignIn signIn;

    public AuthViewModel(SignIn signIn) {
        this.signIn = signIn;
    }

    public void setEvent(AuthEvent event) {
        this.event = event;
    }

    public void signIn(String username, String password) {
        signIn.execute(username, password, new SignInCallback() {
            @Override
            public void onLoading() {
                event.onSignInLoading();
            }
            @Override
            public void onSuccess() {
                event.onSignInSuccess();
            }
            @Override
            public void onFailure() {
                event.onSignInFailure();
            }
        });
    }

}