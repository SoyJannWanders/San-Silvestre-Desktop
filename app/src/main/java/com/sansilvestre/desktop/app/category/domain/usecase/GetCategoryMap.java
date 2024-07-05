package com.sansilvestre.desktop.app.category.domain.usecase;

import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.Map;

public class GetCategoryMap {

    private final CategoryRepository repository;

    public GetCategoryMap(CategoryRepository repository) {
        this.repository = repository;
    }

    public Response<Map<Integer, Category>> execute() {
        return repository.getCategoryMap();
    }

}