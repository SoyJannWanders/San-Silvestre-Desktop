package com.sansilvestre.desktop.app.branch.domain.usecase;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.Map;

public class GetBranchMap {

    private final BranchRepository repository;

    public GetBranchMap(BranchRepository repository) {
        this.repository = repository;
    }

    public Response<Map<Integer, Branch>> execute() {
        return repository.getBranchMap();
    }

}