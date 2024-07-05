package com.sansilvestre.desktop.app.shift.domain.repository;

import com.sansilvestre.desktop.app.shift.screen.ShiftViewController;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;

import java.util.List;

public interface ShiftRepository {

    void setViewController(ShiftViewController viewController);

    Response<Shift> getShift();

    Response<List<Shift>> getShiftList();

    Response<Void> addShift(Shift shift);

    Response<Void> updateShift(Shift shift);

    Response<Void> deleteShiftByID(int id);

}