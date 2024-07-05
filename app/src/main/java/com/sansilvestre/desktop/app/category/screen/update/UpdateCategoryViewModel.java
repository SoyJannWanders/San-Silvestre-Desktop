package com.sansilvestre.desktop.app.category.screen.update;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.domain.usecase.UpdateCategory;
import com.sansilvestre.desktop.app.category.screen.CategoryEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class UpdateCategoryViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private UpdateCategoryViewController viewController;

    private final UpdateCategory updateCategory;

    public UpdateCategoryViewModel(
            UpdateCategory updateCategory
    ) {
        this.updateCategory = updateCategory;
    }

    public void setViewController(UpdateCategoryViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(CategoryEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof CategoryEvent.UpdateCategoryEvent) {
                    Category category = ((CategoryEvent.UpdateCategoryEvent) event).getCategory();
                    ResponseHandler.handleResponse(updateCategory.execute(category), viewStateController, () -> {
                        viewController.dispose();
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}