package com.sansilvestre.desktop.app.user.domain.usecase;

import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetUserListByRole {

    private final UserRepository repository;

    public GetUserListByRole(UserRepository repository) {
        this.repository = repository;
    }

    public Response<List<User>> execute(Role role) {
        return repository.getUserListByRole(role);
    }

}