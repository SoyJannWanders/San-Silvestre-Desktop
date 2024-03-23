package com.sansilvestre.desktop.app.auth.data.repository;

import com.sansilvestre.desktop.app.auth.data.repository.handler.SignInHandler;
import com.sansilvestre.desktop.app.auth.domain.repository.IAuthRepository;
import com.sansilvestre.desktop.app.auth.screen.viewmodel.callback.SignInCallback;

public class AuthRepository implements IAuthRepository {

    private final SignInHandler signInHandler;

    public AuthRepository(SignInHandler signInHandler) {
        this.signInHandler = signInHandler;
    }

    @Override
    public void signIn(String username, String password, SignInCallback callback) {
        signInHandler.signIn(username, password, callback);
    }

}