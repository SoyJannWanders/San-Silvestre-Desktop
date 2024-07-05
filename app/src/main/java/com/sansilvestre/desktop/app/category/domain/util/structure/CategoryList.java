package com.sansilvestre.desktop.app.category.domain.util.structure;

import com.sansilvestre.desktop.app.category.domain.model.Category;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryList {

    public static List<Category> valueOf(ResultSet result) throws Exception {
        List<Category> categories = new ArrayList<>();
        while (result.next()) {
            categories.add(new Category(result));
        }
        return categories;
    }

}