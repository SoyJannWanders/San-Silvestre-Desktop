package com.sansilvestre.desktop.app.category.domain.usecase;

import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class DeleteCategoryByID {

    private final CategoryRepository repository;

    public DeleteCategoryByID(CategoryRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(int id) {
        return repository.deleteCategoryByID(id);
    }

}