package com.sansilvestre.desktop.app.branch.domain.repository;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.screen.BranchViewController;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;
import java.util.Map;

public interface BranchRepository {

    void setBranchViewController(BranchViewController viewController);

    void startSync();
    void stopSync();

    Response<Map<Integer, Branch>> getBranchMap();

    Response<List<Branch>> getBranchList();
    Response<List<Branch>> getBranchListBySearch(String search);

    Response<Void> addBranch(Branch branch);

    Response<Void> updateBranch(Branch branch);

    Response<Void> deleteBranchByID(int id);

}