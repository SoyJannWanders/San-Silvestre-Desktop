package com.sansilvestre.desktop.app.user.domain.usecase;

import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetUserListBySearch {

    private final UserRepository repository;

    public GetUserListBySearch(UserRepository repository) {
        this.repository = repository;
    }

    public Response<List<User>> execute(String search) {
        return repository.getUserListBySearch(search);
    }

}