package com.sansilvestre.desktop.app.launch.domain.model;

import com.sansilvestre.desktop.app.launch.screens.resources.LaunchStrings;

public enum Schedule {

    FIRST(LaunchStrings.getFirstScheduleOption()),
    SECOND(LaunchStrings.getSecondScheduleOption()),
    THIRD(LaunchStrings.getThirdScheduleOption());

    private final String schedule;

    Schedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

}