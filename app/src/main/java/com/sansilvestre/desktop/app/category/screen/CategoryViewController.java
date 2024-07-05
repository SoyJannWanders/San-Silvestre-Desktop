package com.sansilvestre.desktop.app.category.screen;

import com.sansilvestre.desktop.app.category.domain.model.Category;

import java.util.List;

public interface CategoryViewController {

    void setCategoryList(List<Category> categories);

    void refresh();

}