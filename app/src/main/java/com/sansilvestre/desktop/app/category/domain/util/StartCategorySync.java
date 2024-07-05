package com.sansilvestre.desktop.app.category.domain.util;

import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;

public class StartCategorySync {

    private final CategoryRepository repository;

    public StartCategorySync(CategoryRepository repository) {
        this.repository = repository;
    }

    public void execute() {
        repository.startSync();
    }

}