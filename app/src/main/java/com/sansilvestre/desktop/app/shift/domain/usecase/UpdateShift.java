package com.sansilvestre.desktop.app.shift.domain.usecase;

import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.shift.domain.repository.ShiftRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class UpdateShift {

    private final ShiftRepository repository;

    public UpdateShift(ShiftRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(Shift shift) {
        return repository.updateShift(shift);
    }

}