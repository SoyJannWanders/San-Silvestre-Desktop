package com.sansilvestre.desktop.app.auth.domain.usecase;

import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.auth.domain.repository.AuthRepository;

public class SignIn {

    private final AuthRepository repository;

    public SignIn(AuthRepository repository) {
        this.repository = repository;
    }

    public Response<User> execute(int id, String password) {
        return repository.signIn(id, password);
    }

}