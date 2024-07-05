package com.sansilvestre.desktop.app.category.domain.util;

import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;
import com.sansilvestre.desktop.app.category.screen.CategoryViewController;

public class SetCategoryViewController {

    private final CategoryRepository repository;

    public SetCategoryViewController(CategoryRepository repository) {
        this.repository = repository;
    }

    public void execute(CategoryViewController viewController) {
        repository.setViewController(viewController);
    }

}