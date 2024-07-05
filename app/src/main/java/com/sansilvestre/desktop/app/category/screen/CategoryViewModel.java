package com.sansilvestre.desktop.app.category.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.category.domain.usecase.*;
import com.sansilvestre.desktop.app.category.domain.util.SetCategoryViewController;
import com.sansilvestre.desktop.app.category.domain.util.StartCategorySync;
import com.sansilvestre.desktop.app.category.domain.util.StopCategorySync;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class CategoryViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private CategoryViewController viewController;

    private final SetCategoryViewController setCategoryViewController;

    private final StartCategorySync startCategorySync;
    private final StopCategorySync stopCategorySync;

    private final GetCategoryList getCategoryList;
    private final GetCategoryBySearch getCategoryBySearch;

    private final DeleteCategoryByID deleteCategoryByID;

    public CategoryViewModel(
            SetCategoryViewController setCategoryViewController,
            StartCategorySync startCategorySync,
            StopCategorySync stopCategorySync,
            GetCategoryList getCategoryList,
            GetCategoryBySearch getCategoryBySearch,
            DeleteCategoryByID deleteCategoryByID
    ) {
        this.setCategoryViewController = setCategoryViewController;
        this.startCategorySync = startCategorySync;
        this.stopCategorySync = stopCategorySync;
        this.getCategoryList = getCategoryList;
        this.getCategoryBySearch = getCategoryBySearch;
        this.deleteCategoryByID = deleteCategoryByID;
    }

    public void setViewController(CategoryViewController viewController) {
        this.viewController = viewController;
        setCategoryViewController.execute(viewController);
    }

    public void onEvent(CategoryEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                if (event instanceof CategoryEvent.GetCategoryListBySearchEvent) {
                    String search = ((CategoryEvent.GetCategoryListBySearchEvent) event).getSearch();
                    ResponseHandler.handleResponse(getCategoryBySearch.execute(search), viewStateController, categories -> {
                        viewController.setCategoryList(categories);
                    });
                } else {
                    viewStateController.isLoading();
                    if (event instanceof CategoryEvent.GetCategoryListEvent) {
                        ResponseHandler.handleResponse(getCategoryList.execute(), viewStateController, categories -> {
                            viewController.setCategoryList(categories);
                        });
                    } else if (event instanceof CategoryEvent.DeleteCategoryByIDEvent) {
                        int id = ((CategoryEvent.DeleteCategoryByIDEvent) event).getId();
                        ResponseHandler.handleResponse(deleteCategoryByID.execute(id), viewStateController, (Runnable) null);
                    }
                }
                return null;
            }
        };
        worker.execute();
    }

    public class Sync {

        public void start() {
            startCategorySync.execute();
        }

        public void stop() {
            stopCategorySync.execute();
        }

    }

}