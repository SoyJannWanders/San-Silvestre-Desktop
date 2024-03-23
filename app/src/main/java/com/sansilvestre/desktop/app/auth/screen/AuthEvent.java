package com.sansilvestre.desktop.app.auth.screen;

public interface AuthEvent {

    void onSignInLoading();
    void onSignInSuccess();
    void onSignInFailure();

}