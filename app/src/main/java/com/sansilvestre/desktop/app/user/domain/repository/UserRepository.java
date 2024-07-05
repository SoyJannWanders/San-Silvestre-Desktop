package com.sansilvestre.desktop.app.user.domain.repository;

import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.screen.UserViewController;
import com.sansilvestre.desktop.app.util.objects.IncreaseType;

import java.util.List;

public interface UserRepository {

    void setViewController(UserViewController viewController);

    void startSync();
    void stopSync();

    Response<List<User>> getUserList();
    Response<List<User>> getUserListBySearch(String search);
    Response<List<User>> getUserListByRole(Role role);
    Response<List<User>> getUserListByBranch(int branch);

    Response<Void> addUser(User user);

    Response<Void> updateUser(User user);
    Response<Void> updateUserSalaryByID(double salary, int id);

    Response<Void> updateUsersSalaries(IncreaseType increaseType, double increase, int branchId);

    Response<Void> deleteUserByID(int ID);

}