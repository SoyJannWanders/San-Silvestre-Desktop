package com.sansilvestre.desktop.app.user.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchMap;
import com.sansilvestre.desktop.app.user.domain.usecase.*;
import com.sansilvestre.desktop.app.user.domain.util.StartUserSync;
import com.sansilvestre.desktop.app.user.domain.util.StopUserSync;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.user.domain.util.SetUserViewController;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class UserViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private UserViewController viewController;

    private final SetUserViewController setUserViewController;

    private final StartUserSync startUserSync;
    private final StopUserSync stopUserSync;

    private final GetUserList getUserList;
    private final GetUserListBySearch getUserListBySearch;
    private final GetUserListByRole getUserListByRole;
    private final GetUserListByBranchID getUserListByBranchID;

    private final DeleteUserByID deleteUserByID;

    private final GetBranchMap getBranchMap;

    public UserViewModel(
            SetUserViewController setUserViewController,
            StartUserSync startUserSync,
            StopUserSync stopUserSync,
            GetUserList getUserList,
            GetUserListBySearch getUserListBySearch,
            GetUserListByRole getUserListByRole,
            GetUserListByBranchID getUserListByBranchID,
            DeleteUserByID deleteUserByID,
            GetBranchMap getBranchMap
    ) {
        this.setUserViewController = setUserViewController;
        this.startUserSync = startUserSync;
        this.stopUserSync = stopUserSync;
        this.getUserList = getUserList;
        this.getUserListBySearch = getUserListBySearch;
        this.getUserListByRole = getUserListByRole;
        this.getUserListByBranchID = getUserListByBranchID;
        this.deleteUserByID = deleteUserByID;
        this.getBranchMap = getBranchMap;
    }

    public void setViewController(UserViewController viewController) {
        this.viewController = viewController;
        setUserViewController.execute(viewController);
    }

    public void onEvent(UserEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                if (event instanceof UserEvent.GetUserListBySearchEvent) {
                    String search = ((UserEvent.GetUserListBySearchEvent) event).getSearch();
                    ResponseHandler.handleResponse(getUserListBySearch.execute(search), viewStateController, success -> {
                        viewController.setUserList(success);
                    });
                } else {
                    viewStateController.isLoading();
                    if (event instanceof UserEvent.GetUserListEvent) {
                        ResponseHandler.handleResponse(getUserList.execute(), viewStateController, success -> {
                            viewController.setUserList(success);
                        });
                    } else if (event instanceof UserEvent.GetUserListByRoleEvent) {
                        Role role = ((UserEvent.GetUserListByRoleEvent) event).getRole();
                        ResponseHandler.handleResponse(getUserListByRole.execute(role), viewStateController, success -> {
                            viewController.setUserList(success);
                        });
                    } else if (event instanceof UserEvent.GetUserListByBranchIDEvent) {
                        int branchId = ((UserEvent.GetUserListByBranchIDEvent) event).getBranchId();
                        ResponseHandler.handleResponse(getUserListByBranchID.execute(branchId), viewStateController, success -> {
                            viewController.setUserList(success);
                        });
                    } else if (event instanceof UserEvent.DeleteUserByIdEvent) {
                        int id = ((UserEvent.DeleteUserByIdEvent) event).getId();
                        ResponseHandler.handleResponse(deleteUserByID.execute(id), viewStateController, (Runnable) null);
                    } else if (event instanceof UserEvent.GetRoleListEvent) {
                        ResponseHandler.handleResponse(new Response.Success<>(Role.getRoles()), viewStateController, roles -> {
                            viewController.setRoleList(roles);
                        });
                    } else if (event instanceof UserEvent.GetBranchListEvent) {
                        ResponseHandler.handleResponse(getBranchMap.execute(), viewStateController, branches -> {
                            viewController.setBranchMap(branches);
                        });
                    }
                }
                return null;
            }
        };
        worker.execute();
    }

    public class Sync {

        public void start() {
            startUserSync.execute();
        }

        public void stop() {
            stopUserSync.execute();
        }

    }

}