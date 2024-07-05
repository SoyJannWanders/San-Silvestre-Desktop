package com.sansilvestre.desktop.app.category.screen.add;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.domain.usecase.AddCategory;
import com.sansilvestre.desktop.app.category.screen.CategoryEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class AddCategoryViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private AddCategoryViewController viewController;

    private final AddCategory addCategory;

    public AddCategoryViewModel(
            AddCategory addCategory
    ) {
        this.addCategory = addCategory;
    }

    public void setViewController(AddCategoryViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(CategoryEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof CategoryEvent.AddCategoryEvent) {
                    Category category = ((CategoryEvent.AddCategoryEvent) event).getCategory();
                    ResponseHandler.handleResponse(addCategory.execute(category), viewStateController, () -> {
                        viewController.dispose();
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}