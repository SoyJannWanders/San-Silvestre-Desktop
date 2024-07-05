package com.sansilvestre.desktop.app.shift.domain.usecase;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.shift.domain.repository.ShiftRepository;

import java.util.List;

public class GetShiftList {

    private final ShiftRepository repository;

    public GetShiftList(ShiftRepository repository) {
        this.repository = repository;
    }

    public Response<List<Shift>> execute() {
        return repository.getShiftList();
    }

}