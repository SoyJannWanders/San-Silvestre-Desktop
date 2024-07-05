package com.sansilvestre.desktop.app.shift.domain.usecase;

import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.shift.domain.repository.ShiftRepository;

public class GetShift {

    private final ShiftRepository repository;

    public GetShift(ShiftRepository repository) {
        this.repository = repository;
    }

    public Response<Shift> execute() {
        return repository.getShift();
    }

}