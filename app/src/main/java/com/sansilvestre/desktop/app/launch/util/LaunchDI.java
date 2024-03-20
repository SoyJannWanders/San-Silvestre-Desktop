package com.sansilvestre.desktop.app.launch.util;

import com.sansilvestre.desktop.app.launch.domain.usecases.GetSchedule;
import com.sansilvestre.desktop.app.launch.screens.viewmodels.LaunchViewModel;

public class LaunchDI {

    private static LaunchDI instance;

    private final GetSchedule getSchedule;

    private LaunchDI() {
        getSchedule = new GetSchedule();
    }

    public static LaunchDI getInstance() {
        if (instance == null)
            instance = new LaunchDI();
        return instance;
    }

    public LaunchViewModel provideLaunchViewModel() {
        return new LaunchViewModel(getSchedule);
    }

}