package com.sansilvestre.desktop.app.user.domain.util;

import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;

public class StopUserSync {

    private final UserRepository repository;

    public StopUserSync(UserRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        repository.stopSync();
    }

}