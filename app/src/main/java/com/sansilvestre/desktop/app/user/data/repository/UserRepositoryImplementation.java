package com.sansilvestre.desktop.app.user.data.repository;

import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.sync.AsyncTaskManager;
import com.sansilvestre.desktop.app.util.data.sync.AttemptsManager;
import com.sansilvestre.desktop.app.util.log.ExceptionManager;
import com.sansilvestre.desktop.app.user.data.source.UserStorage;
import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;
import com.sansilvestre.desktop.app.user.data.source.UserAPI;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.screen.UserViewController;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.log.Console;
import com.sansilvestre.desktop.app.util.objects.IncreaseType;

import java.util.List;
import java.util.Map;

public class UserRepositoryImplementation implements UserRepository {

    private UserViewController viewController;

    private final UserStorage storage;
    private final UserAPI api;

    private boolean isAdding = false;
    private boolean isUpdating = false;
    private boolean isDeleting = false;

    public UserRepositoryImplementation(UserStorage storage, UserAPI api) {
        this.storage = storage;
        this.api = api;
    }

    @Override
    public void setViewController(UserViewController viewController) {
        this.viewController = viewController;
    }

    @Override
    public void startSync() {
    }

    @Override
    public void stopSync() {

    }

    private synchronized void notifySync() {
        notifyAll();
    }

    private void syncData(Map<Integer, User> storageData, Map<Integer, User> apiData) {
        apiData.forEach((ID, user) -> {
            User result = storageData.get(ID);
            if (result == null)
                syncStorageAdd(user);
            else if (user.getUpdatedDate().isAfter(result.getUpdatedDate()))
                syncStorageUpdate(user);
        });
        if (storageData.size() > apiData.size()) {
            storageData.forEach((ID, user) -> {
                User result = apiData.get(ID);
                if (result == null)
                    syncStorageDelete(ID);
            });
        }
    }

    private void syncAPIAdd(User user) {
        AsyncTaskManager.executeAsync(() -> {
            AttemptsManager attemptsManager = new AttemptsManager();
            while (true) {
                Response<Void> response = api.addUser(user);
                if (response instanceof Response.Success<Void>)
                    break;
                else
                    attemptsManager.retryWithDelay();
            }
            synchronized (this) {
                isAdding = false;
                notifySync();
            }
        });
    }

    private void syncStorageAdd(User user) {
        Response<Void> response = storage.addUser(user);
        if (response instanceof Response.Success<Void>) {
            refreshView();
        } else {

        }
    }

    private void syncAPIUpdate(User user) {
        AsyncTaskManager.executeAsync(() -> {
            AttemptsManager attemptsManager = new AttemptsManager();
            while (true) {
                Response<Void> response = api.updateUser(user);
                if (response instanceof Response.Success<Void>) {
                    break;
                } else {
                    attemptsManager.resetDelay();
                    Exception exception = ((Response.Failure<Void>) response).getException();
                    Console.warn("", "", exception.getMessage());
                }
            }
            synchronized (this) {
                isUpdating = false;
                notifySync();
            }
        });
    }

    private void syncAPISalaryUpdateByID(int ID, double increase) {
        AsyncTaskManager.executeAsync(() -> {
            AttemptsManager attemptsManager = new AttemptsManager();
            while (true) {
                Response<Void> response = api.updateUserSalaryByID(ID, increase);
                if (response instanceof Response.Success<Void>) {
                    break;
                } else {
                    attemptsManager.resetDelay();
                    Exception exception = ((Response.Failure<Void>) response).getException();
                    Console.warn("", "", exception.getMessage());
                }
            }
            synchronized (this) {
                isUpdating = false;
                notifySync();
            }
        });
    }

    private void syncAPISalariesUpdateByRole(int role, double increase) {
        AsyncTaskManager.executeAsync(() -> {
            AttemptsManager attemptsManager = new AttemptsManager();
            while (true) {
                Response<Void> response = api.updateUserSalariesByRole(role, increase);
                if (response instanceof Response.Success<Void>) {
                    break;
                } else {
                    attemptsManager.resetDelay();
                    Exception exception = ((Response.Failure<Void>) response).getException();
                    Console.warn("", "", exception.getMessage());
                }
            }
            synchronized (this) {
                isUpdating = false;
                notifySync();
            }
        });
    }

    private void syncStorageUpdate(User user) {
        Response<Void> response = storage.updateUser(user);
        if (response instanceof Response.Success<Void>) {
            refreshView();
        } else {

        }
    }

    private void syncAPIDelete(int ID) {
        AsyncTaskManager.executeAsync(() -> {
            AttemptsManager attemptsManager = new AttemptsManager();
            while (true) {
                Response<Void> response = api.deleteUserByBarcode(ID);
                if (response instanceof Response.Success<Void>) {
                    break;
                } else {
                    attemptsManager.retryWithDelay();
                    Exception exception = ((Response.Failure<Void>) response).getException();
                    Console.warn("", "", exception.getMessage());
                }
            }
            synchronized (this) {
                isDeleting = false;
                notifySync();
            }
        });
    }

    private void syncStorageDelete(int ID) {
        Response<Void> response = storage.deleteUserByID(ID);
        if (response instanceof Response.Success<Void>) {
            refreshView();
        } else {

        }
    }

    private void refreshView() {
        Response<List<User>> response = getUserList();
        if (response instanceof Response.Success<List<User>>) {
            List<User> updatedList = ((Response.Success<List<User>>) response).getObject();
            viewController.setUserList(updatedList);
        } else {

        }
    }

    @Override
    public Response<List<User>> getUserList() {
        final Response<List<User>> getUserList = storage.getUserList();
        getUserList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<User>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetUserList");
            }

            @Override
            public void visitFailure(Response.Failure<List<User>> failure) {
                Console.warn(Console.WarnCode.W001, "Error: GetUserList");
            }

        });
        return getUserList;
    }

    @Override
    public Response<List<User>> getUserListBySearch(String search) {
        final Response<List<User>> getUserList = storage.getUserListBySearch(search);
        getUserList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<User>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetUserList by Search - " + search);
            }

            @Override
            public void visitFailure(Response.Failure<List<User>> failure) {
                Console.warn(Console.WarnCode.W001, "Error: GetUserList by Search - " + search);
            }

        });
        return getUserList;
    }

    @Override
    public Response<List<User>> getUserListByRole(Role role) {
        final Response<List<User>> getUserList = storage.getUserListByRole(role);
        getUserList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<User>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetUserList by Role - " + role);
            }

            @Override
            public void visitFailure(Response.Failure<List<User>> failure) {
                Console.warn(Console.WarnCode.W001, "Error: GetUserList by Role - " + role);
            }

        });
        return getUserList;
    }

    @Override
    public Response<List<User>> getUserListByBranch(int branchId) {
        final Response<List<User>> getUserList = storage.getUserListByBranch(branchId);
        getUserList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<User>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetUserList by Branch ID - " + branchId);
            }

            @Override
            public void visitFailure(Response.Failure<List<User>> failure) {
                Console.warn(Console.WarnCode.W001, "Error: GetUserList by Branch ID - " + branchId);
            }

        });
        return getUserList;
    }

    @Override
    public Response<Void> addUser(User user) {
        final Response<Void> addUser = storage.addUser(user);
        addUser.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Response<List<User>> getUserList = storage.getUserList();
                getUserList.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<List<User>> success) {
                        Console.info(Console.InfoCode.I001, "OK: Refresh View after AddUser");
                        viewController.setUserList(success.getObject());
                    }

                    @Override
                    public void visitFailure(Response.Failure<List<User>> failure) {
                        Console.info(Console.InfoCode.I001, "ERROR: GetUserList in AddUser");
                    }

                });
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: AddUser");
            }

        });
        return addUser;
    }

    @Override
    public Response<Void> updateUser(User user) {
        final Response<Void> updateUser = storage.updateUser(user);
        updateUser.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                final Response<List<User>> getUserList = storage.getUserList();
                getUserList.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<List<User>> success) {
                        Console.info(Console.InfoCode.I001, "OK: Refresh View after UpdateUser");
                        viewController.setUserList(success.getObject());
                    }

                    @Override
                    public void visitFailure(Response.Failure<List<User>> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: GetUserList in UpdateUser");
                    }

                });
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateUser");
            }

        });
        return updateUser;
    }

    @Override
    public Response<Void> updateUserSalaryByID(double salary, int id) {
        final Response<Void> updateUserSalaryByID = storage.updateUserSalaryByID(salary, id);
        updateUserSalaryByID.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                final Response<List<User>> getUserList = storage.getUserList();
                getUserList.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<List<User>> success) {
                        Console.info(Console.InfoCode.I001, "OK: Refresh View after UpdateUserSalaryByID");
                        viewController.setUserList(success.getObject());
                    }

                    @Override
                    public void visitFailure(Response.Failure<List<User>> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: GetUserList in UpdateUserSalaryByID");
                    }

                });
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateUserSalaryByID");
            }

        });
        return updateUserSalaryByID;
    }

    @Override
    public Response<Void> updateUsersSalaries(IncreaseType increaseType, double increase, int branchId) {
        Response<Void> updateUsersSalaries = storage.updateUsersSalariesByBranchID(increaseType, increase, branchId);
        updateUsersSalaries.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                final Response<List<User>> getUserList = storage.getUserList();
                getUserList.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<List<User>> success) {
                        Console.info(Console.InfoCode.I001, "OK: Refresh View after UpdateUsersSalaries");
                        viewController.setUserList(success.getObject());
                    }

                    @Override
                    public void visitFailure(Response.Failure<List<User>> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: GetUserList in UpdateUsersSalaries");
                    }

                });
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateUsersSalaries");
            }

        });
        return updateUsersSalaries;
    }

    @Override
    public Response<Void> deleteUserByID(int ID) {
        final Response<Void> deleteUserByID = storage.deleteUserByID(ID);
        deleteUserByID.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                final Response<List<User>> getUserList = storage.getUserList();
                getUserList.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<List<User>> success) {
                        Console.info(Console.InfoCode.I001, "OK: Refresh View after DeleteUserByID");
                        viewController.setUserList(success.getObject());
                    }

                    @Override
                    public void visitFailure(Response.Failure<List<User>> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: GetUserList in DeleteUserByID");
                    }

                });
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: DeleteUserByID");
            }

        });
        return deleteUserByID;
    }

    private class Sync {

        AttemptsManager attemptsManager = new AttemptsManager();

        private boolean isSync = true;

        public void start() {
            AsyncTaskManager.executeAsync(this::sync);
        }

        public void stop() {
            isSync = false;
        }

        private void sync() {
            Exception exception = null;
            while (isSync) {
                synchronized (this) {
                    while (isAdding || isUpdating || isDeleting) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                Response<Map<Integer, User>> apiResponse = api.getUserMap();
                if (apiResponse instanceof Response.Success<Map<Integer, User>>) {
                    Response<Map<Integer, User>> storageResponse = storage.getProductMap();
                    if (storageResponse instanceof Response.Success<Map<Integer, User>>) {
                        Map<Integer, User> apiData =
                                ((Response.Success<Map<Integer, User>>) apiResponse).getObject();
                        Map<Integer, User> storageData =
                                ((Response.Success<Map<Integer, User>>) storageResponse).getObject();
                        syncData(storageData, apiData);
                        attemptsManager.resetDelay();
                    } else {
                        exception = ((Response.Failure<Map<Integer, User>>) storageResponse).getException();
                    }
                } else {
                    exception = ((Response.Failure<Map<Integer, User>>) apiResponse).getException();
                }
                if (exception != null) {
                    ExceptionManager.catchException(exception);
                    attemptsManager.retryWithDelay();
                    exception = null;
                }
            }
        }

    }

}