package com.sansilvestre.desktop.app.auth.screen.viewmodel.callback;

public interface SignInCallback {

    void onLoading();
    void onSuccess();
    void onFailure();

}