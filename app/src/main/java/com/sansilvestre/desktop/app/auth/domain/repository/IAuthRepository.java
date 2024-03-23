package com.sansilvestre.desktop.app.auth.domain.repository;

import com.sansilvestre.desktop.app.auth.screen.viewmodel.callback.SignInCallback;

public interface IAuthRepository {

    void signIn(String username, String password, SignInCallback callback);

}