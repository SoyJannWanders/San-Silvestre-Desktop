package com.sansilvestre.desktop.app.shift.domain.util;

import com.sansilvestre.desktop.app.shift.domain.repository.ShiftRepository;
import com.sansilvestre.desktop.app.shift.screen.ShiftViewController;

public class SetShiftViewController {

    private final ShiftRepository repository;

    public SetShiftViewController(ShiftRepository repository) {
        this.repository = repository;
    }

    public void execute(ShiftViewController viewController) {
        repository.setViewController(viewController);
    }

}