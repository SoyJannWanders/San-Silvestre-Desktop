package com.sansilvestre.desktop.app.user.domain.usecase;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;

public class AddUser {

    private final UserRepository repository;

    public AddUser(UserRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(User user) {
        return repository.addUser(user);
    }

}