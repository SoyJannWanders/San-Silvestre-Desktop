package com.sansilvestre.desktop.app.branch.domain.usecase;

import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class DeleteBranchByID {

    private final BranchRepository repository;

    public DeleteBranchByID(BranchRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(int id) {
        return repository.deleteBranchByID(id);
    }

}