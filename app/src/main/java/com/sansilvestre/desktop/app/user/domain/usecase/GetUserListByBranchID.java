package com.sansilvestre.desktop.app.user.domain.usecase;

import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetUserListByBranchID {

    private final UserRepository repository;

    public GetUserListByBranchID(UserRepository repository) {
        this.repository = repository;
    }

    public Response<List<User>> execute(int branchId) {
        return repository.getUserListByBranch(branchId);
    }

}