package com.sansilvestre.desktop.app.category.domain.usecase;

import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetCategoryList {

    private final CategoryRepository repository;

    public GetCategoryList(CategoryRepository repository) {
        this.repository = repository;
    }

    public Response<List<Category>> execute() {
        return repository.getCategoryList();
    }

}