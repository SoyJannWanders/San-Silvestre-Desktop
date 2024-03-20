package com.sansilvestre.desktop.app.launch.domain.usecases;

import com.sansilvestre.desktop.app.launch.domain.model.Schedule;
import com.sansilvestre.desktop.app.launch.screens.viewmodels.callbacks.GetScheduleCallback;

import java.time.LocalTime;

public class GetSchedule {

    private final LocalTime START_OF_FIRST_SCHEDULE = LocalTime.of(22, 30);
    private final LocalTime START_OF_SECOND_SCHEDULE = LocalTime.of(7, 0);
    private final LocalTime START_OF_THIRD_SCHEDULE = LocalTime.of(14, 0);

    public void execute(LocalTime time, GetScheduleCallback callback) {
        if (isFirstSchedule(time))
            callback.onSuccess(Schedule.FIRST.getSchedule());
        if (isSecondSchedule(time))
            callback.onSuccess(Schedule.SECOND.getSchedule());
        if (isThirdSchedule(time))
            callback.onSuccess(Schedule.THIRD.getSchedule());
    }

    private boolean isFirstSchedule(LocalTime time) {
        return (time.equals(START_OF_FIRST_SCHEDULE) || time.isAfter(START_OF_FIRST_SCHEDULE))
                && (time.isBefore(LocalTime.MAX) || time.equals(LocalTime.MAX)) || (time.isAfter(LocalTime.MIN) && time.isBefore(START_OF_SECOND_SCHEDULE));
    }

    private boolean isSecondSchedule(LocalTime time) {
        return (time.equals(START_OF_SECOND_SCHEDULE) || time.isAfter(START_OF_SECOND_SCHEDULE))
                && time.isBefore(START_OF_THIRD_SCHEDULE);
    }

    private boolean isThirdSchedule(LocalTime time) {
        return (time.equals(START_OF_THIRD_SCHEDULE) || time.isAfter(START_OF_THIRD_SCHEDULE))
                && time.isBefore(START_OF_FIRST_SCHEDULE);
    }

}