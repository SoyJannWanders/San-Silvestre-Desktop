package com.sansilvestre.desktop.app.category.domain.util;

import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;

public class StopCategorySync {

    private final CategoryRepository repository;

    public StopCategorySync(CategoryRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        repository.stopSync();
    }

}