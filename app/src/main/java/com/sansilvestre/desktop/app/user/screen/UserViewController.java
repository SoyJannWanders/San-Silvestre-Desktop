package com.sansilvestre.desktop.app.user.screen;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.user.domain.model.User;

import java.util.List;
import java.util.Map;

public interface UserViewController {

    void setUserList(List<User> users);

    void setRoleList(List<Role> roles);
    void setBranchMap(Map<Integer, Branch> branches);

}