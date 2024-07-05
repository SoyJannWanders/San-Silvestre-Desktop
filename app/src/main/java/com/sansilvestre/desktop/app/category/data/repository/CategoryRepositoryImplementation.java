package com.sansilvestre.desktop.app.category.data.repository;

import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;
import com.sansilvestre.desktop.app.category.data.source.CategoryStorage;
import com.sansilvestre.desktop.app.category.data.source.CategoryAPI;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.screen.CategoryViewController;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.data.sync.AsyncTaskManager;
import com.sansilvestre.desktop.app.util.data.sync.AttemptsManager;
import com.sansilvestre.desktop.app.util.log.ExceptionManager;
import com.sansilvestre.desktop.app.util.log.Console;

import java.util.List;
import java.util.Map;

public class CategoryRepositoryImplementation implements CategoryRepository {

    private CategoryViewController viewController;

    private final CategoryStorage storage;
    private final CategoryAPI api;

    private boolean isSync = true;

    private boolean isAdding = false;
    private boolean isUpdating = false;
    private boolean isDeleting = false;

    public CategoryRepositoryImplementation(CategoryStorage storage, CategoryAPI api) {
        this.storage = storage;
        this.api = api;
    }

    @Override
    public void setViewController(CategoryViewController controller) {
        this.viewController = controller;
    }

    @Override
    public void startSync() {
        AsyncTaskManager.executeAsync(this::sync);
    }

    @Override
    public void stopSync() {
        isSync = false;
    }

    private synchronized void notifySync() {
        notifyAll();
    }

    private void sync() {
        AttemptsManager attemptsManager = new AttemptsManager();
        Exception exception = null;
        while (isSync) {
            while (isAdding || isUpdating || isDeleting) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Response<Map<Integer, Category>> apiResponse = api.getCategoryMap();
            if (apiResponse instanceof Response.Success<Map<Integer, Category>>) {
                Response<Map<Integer, Category>> storageResponse = storage.getCategoryMap();
                if (storageResponse instanceof Response.Success<Map<Integer, Category>>) {
                    Map<Integer, Category> apiData =
                            ((Response.Success<Map<Integer, Category>>) apiResponse).getObject();
                    Map<Integer, Category> storageData =
                            ((Response.Success<Map<Integer, Category>>) storageResponse).getObject();
                    syncData(storageData, apiData);
                    attemptsManager.resetDelay();
                } else {
                    exception = ((Response.Failure<Map<Integer, Category>>) storageResponse).getException();
                }
            } else {
                exception = ((Response.Failure<Map<Integer, Category>>) apiResponse).getException();
            }
            if (exception != null) {
                ExceptionManager.catchException(exception);
                attemptsManager.retryWithDelay();
                exception = null;
            }
        }
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
                notifySync();
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
                notifySync();
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
                notifySync();
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

}