package com.sansilvestre.desktop.app.user.domain.util;

import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;
import com.sansilvestre.desktop.app.user.screen.UserViewController;

public class SetUserViewController {

    private final UserRepository repository;

    public SetUserViewController(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(UserViewController viewController) {
        repository.setViewController(viewController);
    }

}