package com.sansilvestre.desktop.app.shift.screen.update;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;

import java.util.Map;

public interface UpdateShiftViewController {

    void setBranchMap(Map<Integer, Branch> branches);

    void dispose();

}