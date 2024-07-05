package com.sansilvestre.desktop.app.user.domain.util;

import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;

public class StartUserSync {

    private final UserRepository repository;

    public StartUserSync(UserRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        repository.startSync();
    }

}