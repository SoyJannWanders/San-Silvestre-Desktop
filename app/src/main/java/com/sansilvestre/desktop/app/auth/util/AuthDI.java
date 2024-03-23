package com.sansilvestre.desktop.app.auth.util;

import com.sansilvestre.desktop.app.auth.data.repository.AuthRepository;
import com.sansilvestre.desktop.app.auth.data.repository.handler.SignInHandler;
import com.sansilvestre.desktop.app.auth.data.source.remote.SignInService;
import com.sansilvestre.desktop.app.auth.domain.usecase.SignIn;
import com.sansilvestre.desktop.app.auth.screen.viewmodel.AuthViewModel;

public class AuthDI {

    private static AuthDI instance;

    private final SignInService signInService;
    private final SignInHandler signInHandler;
    private final AuthRepository authRepository;
    private final SignIn signIn;

    private AuthDI() {
        signInService = new SignInService();
        signInHandler = new SignInHandler(signInService);
        authRepository = new AuthRepository(signInHandler);
        signIn = new SignIn(authRepository);
    }

    public static AuthDI getInstance() {
        if (instance == null)
            instance = new AuthDI();
        return instance;
    }

    public AuthViewModel provideAuthViewModel() {
        return new AuthViewModel(signIn);
    }

}