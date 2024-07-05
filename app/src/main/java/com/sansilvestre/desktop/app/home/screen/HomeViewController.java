package com.sansilvestre.desktop.app.home.screen;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;

import java.util.List;
import java.util.Map;

public interface HomeViewController {

    void setSaleList(List<Sale> sales);
    void setBranchMap(Map<Integer, Branch> branches);

}