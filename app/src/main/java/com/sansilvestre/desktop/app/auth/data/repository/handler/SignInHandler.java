package com.sansilvestre.desktop.app.auth.data.repository.handler;

import com.sansilvestre.desktop.app.auth.data.source.remote.SignInService;
import com.sansilvestre.desktop.app.auth.screen.viewmodel.callback.SignInCallback;

public class SignInHandler {

    private final SignInService signInService;

    public SignInHandler(SignInService signInService) {
        this.signInService = signInService;
    }

    public void signIn(String username, String password, SignInCallback callback) {
        signInService.signIn(username, password, callback);
    }

}