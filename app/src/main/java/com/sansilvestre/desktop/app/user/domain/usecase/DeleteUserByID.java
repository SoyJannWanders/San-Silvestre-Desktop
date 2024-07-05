package com.sansilvestre.desktop.app.user.domain.usecase;

import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class DeleteUserByID {

    private final UserRepository repository;

    public DeleteUserByID(UserRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(int id) {
        return repository.deleteUserByID(id);
    }

}