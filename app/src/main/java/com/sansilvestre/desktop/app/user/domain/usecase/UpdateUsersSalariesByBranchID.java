package com.sansilvestre.desktop.app.user.domain.usecase;

import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.objects.IncreaseType;

public class UpdateUsersSalariesByBranchID {

    private final UserRepository repository;

    public UpdateUsersSalariesByBranchID(UserRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(IncreaseType increaseType, double increase, int branchId) {
        return repository.updateUsersSalaries(increaseType, increase, branchId);
    }

}