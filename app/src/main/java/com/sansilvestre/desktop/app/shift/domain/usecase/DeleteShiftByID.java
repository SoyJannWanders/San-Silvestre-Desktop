package com.sansilvestre.desktop.app.shift.domain.usecase;

import com.sansilvestre.desktop.app.shift.domain.repository.ShiftRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class DeleteShiftByID {

    private final ShiftRepository repository;

    public DeleteShiftByID(ShiftRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(int id) {
        return repository.deleteShiftByID(id);
    }

}