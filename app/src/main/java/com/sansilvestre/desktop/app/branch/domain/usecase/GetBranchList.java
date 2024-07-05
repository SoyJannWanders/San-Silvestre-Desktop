package com.sansilvestre.desktop.app.branch.domain.usecase;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetBranchList {

    private final BranchRepository repository;

    public GetBranchList(BranchRepository repository) {
        this.repository = repository;
    }

    public Response<List<Branch>> execute() {
        return repository.getBranchList();
    }

}