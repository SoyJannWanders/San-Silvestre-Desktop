package com.sansilvestre.desktop.app.shift.screen.add;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;

import java.util.List;

public interface AddShiftViewController {

    void setBranchList(List<Branch> branches);

    void dispose();

}