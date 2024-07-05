package com.sansilvestre.desktop.app.branch.screen;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;

import java.util.List;

public interface BranchViewController {

    void setBranchList(List<Branch> branches);

    void refresh();

}