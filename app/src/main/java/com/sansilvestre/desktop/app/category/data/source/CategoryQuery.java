package com.sansilvestre.desktop.app.category.data.source;

public class CategoryQuery {

    public static final String SELECT_CATEGORIES =
            "SELECT * FROM categories;";

    public static final String SELECT_CATEGORIES_BY_SEARCH =
            "SELECT * FROM categories WHERE name LIKE ? ORDER BY CASE " +
                    "WHEN name = ? THEN 1 " +
                    "WHEN name LIKE ? THEN 2 " +
                    "ELSE 3 END, name;";

    public static final String INSERT_PRODUCT =
            "INSERT INTO categories (name, increase) VALUES (?, ?);";

    public static final String UPDATE_CATEGORY =
            "UPDATE categories SET name = ?, increase = ? WHERE id = ?;";

    public static final String DELETE_CATEGORY_BY_ID =
            "DELETE FROM categories WHERE id = ?;";

}