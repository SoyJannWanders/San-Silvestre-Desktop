package com.sansilvestre.desktop.app.auth.domain.usecase;

import com.sansilvestre.desktop.app.Input;
import com.sansilvestre.desktop.app.auth.domain.repository.IAuthRepository;
import com.sansilvestre.desktop.app.auth.screen.viewmodel.callback.SignInCallback;

public class SignIn {

    private final IAuthRepository repository;

    public SignIn(IAuthRepository repository) {
        this.repository = repository;
    }

    public void execute(String username, String password, SignInCallback callback) {
        if (Input.isValidInput(username) && Input.isValidInput(password)) {
            callback.onLoading();
            repository.signIn(username, password, callback);
        } else
            callback.onFailure();
    }

}