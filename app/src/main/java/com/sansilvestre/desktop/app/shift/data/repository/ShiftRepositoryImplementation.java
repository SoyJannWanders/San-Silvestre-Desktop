package com.sansilvestre.desktop.app.shift.data.repository;

import com.sansilvestre.desktop.app.shift.screen.ShiftViewController;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.shift.data.source.ShiftAPI;
import com.sansilvestre.desktop.app.shift.data.source.ShiftStorage;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.shift.domain.repository.ShiftRepository;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;

import java.util.List;

public class ShiftRepositoryImplementation implements ShiftRepository {

    private ShiftViewController viewController;

    private final ShiftStorage storage;
    private final ShiftAPI api;

    public ShiftRepositoryImplementation(ShiftStorage storage, ShiftAPI api) {
        this.storage = storage;
        this.api = api;
    }

    @Override
    public void setViewController(ShiftViewController viewController) {
        this.viewController = viewController;
    }

    @Override
    public Response<Shift> getShift() {
        return storage.getShift();
    }

    @Override
    public Response<List<Shift>> getShiftList() {
        return storage.getShiftList();
    }

    @Override
    public Response<Void> addShift(Shift shift) {
        Response<Void> addShift = storage.addShift(shift);
        addShift.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {

            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {

            }

        });
        return addShift;
    }

    @Override
    public Response<Void> updateShift(Shift shift) {
        Response<Void> updateShift = storage.updateShift(shift);
        updateShift.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {

            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {

            }

        });
        return updateShift;
    }

    @Override
    public Response<Void> deleteShiftByID(int id) {
        Response<Void> deleteShiftByID = storage.deleteShiftByID(id);
        deleteShiftByID.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {

            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {

            }

        });
        return deleteShiftByID;
    }
}