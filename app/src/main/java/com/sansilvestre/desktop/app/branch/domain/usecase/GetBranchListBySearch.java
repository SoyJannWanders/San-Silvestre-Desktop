package com.sansilvestre.desktop.app.branch.domain.usecase;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.branch.domain.util.exception.InvalidSearchException;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.log.Console;

import java.util.List;

public class GetBranchListBySearch {

    private final BranchRepository repository;

    public GetBranchListBySearch(BranchRepository repository) {
        this.repository = repository;
    }

    public Response<List<Branch>> execute(String search) {
        return repository.getBranchListBySearch(search);
    }

}