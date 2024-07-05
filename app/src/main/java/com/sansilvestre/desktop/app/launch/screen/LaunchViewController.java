package com.sansilvestre.desktop.app.launch.screen;

import com.sansilvestre.desktop.app.shift.domain.model.Shift;

import java.util.List;

public interface LaunchViewController {

    void setShiftList(List<Shift> shifts);
    void setShift(Shift shift);

}