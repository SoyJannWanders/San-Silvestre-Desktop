package com.sansilvestre.desktop.app.auth.util;

import com.sansilvestre.desktop.app.auth.data.repository.AuthRepositoryImplementation;
import com.sansilvestre.desktop.app.auth.data.source.SignInService;
import com.sansilvestre.desktop.app.auth.domain.repository.AuthRepository;
import com.sansilvestre.desktop.app.auth.domain.usecase.SignIn;
import com.sansilvestre.desktop.app.auth.screen.AuthViewModel;

public class AuthModule {

    private static AuthModule instance;

    private final AuthRepository authRepository;

    private AuthModule() {
        authRepository = new AuthRepositoryImplementation(new SignInService());
    }

    public static AuthModule getInstance() {
        if (instance == null)
            instance = new AuthModule();
        return instance;
    }

    public AuthViewModel provideAuthViewModel() {
        return new AuthViewModel(
                provideSignInUseCase()
        );
    }

    private SignIn provideSignInUseCase() {
        return new SignIn(authRepository);
    }

}