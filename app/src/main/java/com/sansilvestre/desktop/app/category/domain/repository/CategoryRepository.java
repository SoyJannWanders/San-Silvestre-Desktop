package com.sansilvestre.desktop.app.category.domain.repository;

import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.screen.CategoryViewController;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;
import java.util.Map;

public interface CategoryRepository {

    void setViewController(CategoryViewController viewController);

    Response<Map<Integer, Category>> getCategoryMap();

    Response<List<Category>> getCategoryList();
    Response<List<Category>> getCategoryBySearch(String search);

    Response<Void> addCategory(Category category);

    Response<Void> updateCategory(Category category);

    Response<Void> deleteCategoryByID(int ID);

    void startSync();
    void stopSync();

}