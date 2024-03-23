package com.sansilvestre.desktop.app.launch.screen.viewmodel;

import com.sansilvestre.desktop.app.launch.domain.usecases.GetSchedule;
import com.sansilvestre.desktop.app.launch.screen.LaunchEvent;
import com.sansilvestre.desktop.app.launch.screen.viewmodel.callback.GetScheduleCallback;

import java.time.LocalTime;

public class LaunchViewModel {

    private LaunchEvent event;

    private final GetSchedule getSchedule;

    public LaunchViewModel(GetSchedule getSchedule) {
        this.getSchedule = getSchedule;
    }

    public void setEvent(LaunchEvent event) {
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