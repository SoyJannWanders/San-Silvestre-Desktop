package com.sansilvestre.desktop.app.branch.domain.util;

import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.branch.screen.BranchViewController;

public class SetBranchViewController {

    private final BranchRepository repository;

    public SetBranchViewController(BranchRepository repository) {
        this.repository = repository;
    }

    public void execute(BranchViewController viewController) {
        repository.setBranchViewController(viewController);
    }

}