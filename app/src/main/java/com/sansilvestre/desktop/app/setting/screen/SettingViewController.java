package com.sansilvestre.desktop.app.setting.screen;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;

import java.util.List;

public interface SettingViewController {

    void setSetting();

    void setBranchList(List<Branch> branches);

    void refresh();
    void restart();

}