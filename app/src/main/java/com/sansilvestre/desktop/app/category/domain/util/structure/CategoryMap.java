package com.sansilvestre.desktop.app.category.domain.util.structure;

import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.data.source.CategoryDatabase;

import java.sql.ResultSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CategoryMap {

    public static Map<Integer, Category> of(ResultSet result) throws Exception {
        Map<Integer, Category> map = new ConcurrentHashMap<>();
        while (result.next()) {
            map.put(result.getInt(CategoryDatabase.ID.getColumnName()), new Category(result));
        }
        return map;
    }

}