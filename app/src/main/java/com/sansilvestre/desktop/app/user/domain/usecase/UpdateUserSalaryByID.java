package com.sansilvestre.desktop.app.user.domain.usecase;

import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class UpdateUserSalaryByID {

    private final UserRepository repository;

    public UpdateUserSalaryByID(UserRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(double salary, int id) {
        return repository.updateUserSalaryByID(salary, id);
    }

}