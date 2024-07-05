package com.sansilvestre.desktop.app.branch.domain.usecase;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class UpdateBranch {

    private final BranchRepository repository;

    public UpdateBranch(BranchRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(Branch branch) {
        return repository.updateBranch(branch);
    }

}