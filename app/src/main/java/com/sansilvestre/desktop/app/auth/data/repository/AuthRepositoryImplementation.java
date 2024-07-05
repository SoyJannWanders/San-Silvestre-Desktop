package com.sansilvestre.desktop.app.auth.data.repository;

import com.sansilvestre.desktop.app.auth.data.source.SignInService;
import com.sansilvestre.desktop.app.auth.domain.repository.AuthRepository;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;

public class AuthRepositoryImplementation implements AuthRepository {

    private final SignInService service;

    public AuthRepositoryImplementation(SignInService service) {
        this.service = service;
    }

    @Override
    public Response<User> signIn(int id, String password) {
        Response<User> signIn = service.signIn(id, password);
        signIn.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<User> success) {

            }

            @Override
            public void visitFailure(Response.Failure<User> failure) {

            }

        });
        return signIn;
    }

}