package com.sansilvestre.desktop.app.category.data.repository;

import com.sansilvestre.desktop.app.branch.data.repository.BranchRepositoryImplementation;
import com.sansilvestre.desktop.app.branch.data.source.sync.UnsyncedBranch;
import com.sansilvestre.desktop.app.branch.data.source.sync.UnsyncedBranchStorage;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.category.data.source.sync.UnsyncedCategory;
import com.sansilvestre.desktop.app.category.data.source.sync.UnsyncedCategoryStorage;
import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;
import com.sansilvestre.desktop.app.category.data.source.CategoryStorage;
import com.sansilvestre.desktop.app.category.data.source.CategoryAPI;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.screen.CategoryViewController;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.data.sync.AsyncTaskManager;
import com.sansilvestre.desktop.app.util.data.sync.AttemptsManager;
import com.sansilvestre.desktop.app.util.data.sync.UnsyncedTaskQueue;
import com.sansilvestre.desktop.app.util.log.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryRepositoryImplementation implements CategoryRepository {

    private CategoryViewController viewController;

    private final CategoryStorage storage;
    private final CategoryAPI api;

    public CategoryRepositoryImplementation(CategoryStorage storage, CategoryAPI api) {
        this.storage = storage;
        this.api = api;
    }

    @Override
    public void setViewController(CategoryViewController controller) {
        this.viewController = controller;
    }

    private void syncData(Map<Integer, Category> storageData, Map<Integer, Category> apiData) {
        apiData.forEach((ID, category) -> {
            Category result = storageData.get(ID);
            if (result == null)
                syncStorageAdd(category);
            else if (category.getUpdatedDate().isAfter(result.getUpdatedDate()))
                syncStorageUpdate(category);
        });
        if (storageData.size() > apiData.size()) {
            storageData.forEach((ID, category) -> {
                Category result = apiData.get(ID);
                if (result == null)
                    syncStorageDelete(ID);
            });
        }
    }

    private void syncAPIAdd(Category category) {
        AsyncTaskManager.executeAsync(() -> {
            AttemptsManager attemptsManager = new AttemptsManager();
            while (true) {
                Response<Void> response = api.addCategory(category);
                if (response instanceof Response.Success<Void>)
                    break;
                else
                    attemptsManager.retryWithDelay();
            }
            synchronized (this) {
                isAdding = false;
                resumeSync();
            }
        });
    }

    private void syncStorageAdd(Category category) {
        Response<Void> response = storage.addCategory(category);
        if (response instanceof Response.Success<Void>) {
            refreshView();
        } else {

        }
    }

    private void syncAPIUpdate(Category category) {
        AsyncTaskManager.executeAsync(() -> {
            AttemptsManager attemptsManager = new AttemptsManager();
            while (true) {
                Response<Void> response = api.updateCategory(category);
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
                resumeSync();
            }
        });
    }

    private void syncStorageUpdate(Category category) {
        Response<Void> response = storage.updateCategory(category);
        if (response instanceof Response.Success<Void>) {
            refreshView();
        } else {

        }
    }

    private void syncAPIDelete(int ID) {
        AsyncTaskManager.executeAsync(() -> {
            AttemptsManager attemptsManager = new AttemptsManager();
            while (true) {
                Response<Void> response = api.deleteCategoryByID(ID);
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
                resumeSync();
            }
        });
    }

    private void syncStorageDelete(int ID) {
        Response<Void> response = storage.deleteCategoryByID(ID);
        if (response instanceof Response.Success<Void>) {
            refreshView();
        } else {

        }
    }

    private void refreshView() {
        Response<List<Category>> response = getCategoryList();
        if (response instanceof Response.Success<List<Category>>) {
            List<Category> updatedList = ((Response.Success<List<Category>>) response).getObject();
            viewController.setCategoryList(updatedList);
        } else {

        }
    }

    @Override
    public Response<Map<Integer, Category>> getCategoryMap() {
        Response<Map<Integer, Category>> getCategoryMap = storage.getCategoryMap();
        getCategoryMap.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Map<Integer, Category>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetCategoryMap");
            }

            @Override
            public void visitFailure(Response.Failure<Map<Integer, Category>> failure) {
                Console.info(Console.InfoCode.I001, "ERROR: GetCategoryMap");
            }

        });
        return getCategoryMap;
    }

    @Override
    public Response<List<Category>> getCategoryList() {
        Response<List<Category>> getCategoryList = storage.getCategoryList();
        getCategoryList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Category>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetCategoryList");
            }

            @Override
            public void visitFailure(Response.Failure<List<Category>> failure) {
                Console.info(Console.InfoCode.I001, "ERROR: GetCategoryList");
            }

        });
        return getCategoryList;
    }

    @Override
    public Response<List<Category>> getCategoryBySearch(String search) {
        Response<List<Category>> getUserList = storage.getCategoryListBySearch(search);
        getUserList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Category>> success) {
                Console.info(Console.InfoCode.I001, "OK: GetCategoryList by Search - " + search);
            }

            @Override
            public void visitFailure(Response.Failure<List<Category>> failure) {
                Console.info(Console.InfoCode.I001, "ERROR: GetCategoryList by Search - " + search);
            }

        });
        return getUserList;
    }

    @Override
    public Response<Void> addCategory(Category category) {
        Response<Void> addCategory = storage.addCategory(category);
        addCategory.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: AddCategory");
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: AddCategory");
            }

        });
        /*synchronized (this) {
            isAdding = true;
        }
        Response<Void> response = storage.addCategory(category);
        if (response instanceof Response.Success<Void>) {
            syncAPIAdd(category);
        } else {
            synchronized (this) {
                isAdding = false;
                notifySync();
            }
        }
        return response;*/
        return addCategory;
    }

    @Override
    public Response<Void> updateCategory(Category category) {
        Response<Void> updateCategory = storage.updateCategory(category);
        updateCategory.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: UpdateCategory");
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateCategory");
            }

        });
        return updateCategory;
        /*synchronized (this) {
            isUpdating = true;
        }
        Response<Void> response = storage.updateCategory(category);
        if (response instanceof Response.Success<Void>) {
            syncAPIUpdate(category);
        } else {
            synchronized (this) {
                isUpdating = false;
                notifySync();
            }
        }
        return response;*/
    }

    @Override
    public Response<Void> deleteCategoryByID(int id) {
        Response<Void> deleteCategoryByID = storage.deleteCategoryByID(id);
        deleteCategoryByID.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: DeleteCategoryByID - " + id);
                viewController.refresh();
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: DeleteCategoryByID - " + id);
            }

        });
        return deleteCategoryByID;
        /*synchronized (this) {
            isDeleting = true;
        }
        Response<Void> response = storage.deleteCategoryByID(ID);
        if (response instanceof Response.Success<Void>) {
            syncAPIDelete(ID);
        } else {
            synchronized (this) {
                isDeleting = false;
                notifySync();
            }
        }
        return response;*/
    }

    private final UnsyncedTaskQueue queue = new UnsyncedTaskQueue();
    private final QueueBackup queueBackup = new QueueBackup();

    private boolean isSync = true;

    private boolean isAdding = false;
    private boolean isUpdating = false;
    private boolean isDeleting = false;

    @Override
    public void startSync() {
        AsyncTaskManager.executeAsync(this::sync);
    }

    @Override
    public void stopSync() {
        isSync = false;
    }

    private synchronized void resumeSync() {
        notifyAll();
    }

    private void synchronize() {

        isSync = true;

        AttemptsManager attemptsManager = new AttemptsManager();

        while (isSync) {

            queueBackup.upload();

            synchronized (this) {
                while (isAdding || isUpdating || isDeleting) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Sync Wait");
                        throw new RuntimeException(e);
                    }
                }
            }

            if (isAdding || isUpdating || isDeleting) continue;

            Map<Integer, User> databaseOfAPI;
            Response<Map<Integer, User>> getProductMapOfAPI = api.getBranchMap();
            if (getProductMapOfAPI instanceof Response.Success<Map<Integer, User>>) {
                databaseOfAPI = ((Response.Success<Map<Integer, User>>) getProductMapOfAPI).getObject();
            } else {
                Console.warn(Console.WarnCode.W001, "ERROR: GetDatabaseOfAPI");
                attemptsManager.retryWithDelay();
                continue;
            }

            if (isAdding || isUpdating || isDeleting) continue;

            Map<Integer, User> databaseOfStorage;
            Response<Map<Integer, User>> getProductMapOfStorage = storage.getBranchMap();
            if (getProductMapOfStorage instanceof Response.Success<Map<Integer, User>>) {
                databaseOfStorage = ((Response.Success<Map<Integer, User>>) getProductMapOfStorage).getObject();
            } else {
                Console.warn(Console.WarnCode.W001, "ERROR: GetDatabaseOfStorage");
                attemptsManager.retryWithDelay();
                continue;
            }

            if (isAdding || isUpdating || isDeleting) continue;

            databaseOfAPI.forEach((id, itemOfAPI) -> {
                User itemOfStorage = databaseOfStorage.get(id);
                if (itemOfStorage == null) {
                    syncAddInStorage(itemOfAPI);
                } else {
                    if (itemOfAPI.getUpdatedDate().isAfter(itemOfStorage.getUpdatedDate())) {
                        syncUpdateInStorage(itemOfAPI);
                    } else if (itemOfStorage.getUpdatedDate().isAfter(itemOfAPI.getUpdatedDate())) {
                        synchronized (BranchRepositoryImplementation.this) {
                            isUpdating = false;
                        }
                        syncUpdateInAPI(itemOfStorage);
                    }
                }
            });

            if (isAdding || isUpdating || isDeleting) continue;

            if (databaseOfAPI.size() < databaseOfStorage.size()) {
                databaseOfStorage.forEach((id, itemOfStorage) -> {
                    User itemOfAPI = databaseOfAPI.get(id);
                    if (itemOfAPI == null)
                        syncDeleteInStorage(id);
                });
            }

            attemptsManager.resetDelay();

            Console.info(Console.InfoCode.I200, "OK: Ciclo de Sincronizacion finalizado Correctamente");

        }
    }

    private class QueueBackup {

        private final UnsyncedCategoryStorage unsyncedStorage = new UnsyncedCategoryStorage();

        private List<UnsyncedCategory> unsyncedBranches = new ArrayList<>();

        public void upload() {

            Response<List<UnsyncedCategory>> upload = unsyncedStorage.getUnsyncedCategoriesList();
            upload.accept(new ResponseVisitor<>() {

                @Override
                public void visitSuccess(Response.Success<List<UnsyncedCategory>> success) {
                    unsyncedBranches = success.getObject();
                    unsyncedBranches.forEach(unsyncedBranch -> {
                        Response<Branch> getProductByBarcode = storage.getBranchByID(unsyncedBranch.getBranchId());
                        getProductByBarcode.accept(new ResponseVisitor<>() {

                            @Override
                            public void visitSuccess(Response.Success<Branch> success) {
                                Console.info(Console.InfoCode.I001, "OK: Upload AddTask");
                                switch (unsyncedBranch.getType()) {
                                    case ADD -> queue.add(() -> syncAddInAPI(success.getObject()));
                                    case UPDATE -> queue.add(() -> syncUpdateInAPI(success.getObject()));
                                    case DELETE -> queue.add(() -> syncDeleteInAPI(success.getObject().getId()));
                                }
                            }

                            @Override
                            public void visitFailure(Response.Failure<Branch> failure) {
                                Console.warn(Console.WarnCode.W001, "ERROR: GetProductByBarcode in GetProductTaskList - Type.ADD");
                            }

                        });
                    });
                }

                @Override
                public void visitFailure(Response.Failure<List<UnsyncedCategory>> failure) {
                    Console.warn(Console.WarnCode.W001, "ERROR: GetProductTaskList");
                }

            });

        }

        public void add(UnsyncedCategory unsyncedCategory) {

            Response<Void> add = unsyncedStorage.addUnsyncedCategoriesInQueue(unsyncedCategory);
            add.accept(new ResponseVisitor<>() {

                @Override
                public void visitSuccess(Response.Success<Void> success) {
                    Console.info(Console.InfoCode.I001, "OK: Add Product Insertion in Queue - " + unsyncedCategory.getCategoryId());
                    unsyncedBranches.add(unsyncedCategory);
                }

                @Override
                public void visitFailure(Response.Failure<Void> failure) {
                    Console.warn(Console.WarnCode.W001, "ERROR: Add Product Insertion in Queue - " + unsyncedCategory.getCategoryId());
                }

            });

        }

        public void poll() {

            if (!unsyncedBranches.isEmpty()) {

                UnsyncedCategory unsyncedCategory = unsyncedBranches.getFirst();

                Response<Void> delete = unsyncedStorage.deleteUnsyncedCategoriesOfQueueByID(unsyncedCategory.getId());
                delete.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<Void> success) {
                        Console.info(Console.InfoCode.I001, "OK: Product Synchronized - " + unsyncedCategory.getCategoryId());
                        unsyncedBranches.removeFirst();
                    }

                    @Override
                    public void visitFailure(Response.Failure<Void> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: Unsynchronized Product - " + unsyncedCategory.getCategoryId());
                    }

                });

            }

        }

    }

}