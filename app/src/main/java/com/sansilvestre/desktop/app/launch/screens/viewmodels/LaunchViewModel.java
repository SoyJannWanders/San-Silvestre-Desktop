package com.sansilvestre.desktop.app.launch.screens.viewmodels;

import com.sansilvestre.desktop.app.launch.domain.usecases.GetSchedule;
import com.sansilvestre.desktop.app.launch.domain.model.Schedule;
import com.sansilvestre.desktop.app.launch.screens.LaunchEvents;
import com.sansilvestre.desktop.app.launch.screens.viewmodels.callbacks.GetScheduleCallback;

import java.time.LocalTime;

public class LaunchViewModel {

    private LaunchEvents event;

    private final GetSchedule getSchedule;

    public LaunchViewModel(GetSchedule getSchedule) {
        this.getSchedule = getSchedule;
    }

    public void setEvent(LaunchEvents event) {
        this.event = event;
    }

    public void getSchedule(LocalTime time) {
        getSchedule.execute(time, new GetScheduleCallback() {
            @Override
            public void onSuccess(String schedule) {
                event.onGetSchedule(schedule);
            }
            @Override
            public void onFailure() {
                System.out.println("X");
            }
        });
    }

}