package com.sansilvestre.desktop.app.category.domain.usecase;

import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class AddCategory {

    private final CategoryRepository repository;

    public AddCategory(CategoryRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(Category category) {
        return repository.addCategory(category);
    }

}