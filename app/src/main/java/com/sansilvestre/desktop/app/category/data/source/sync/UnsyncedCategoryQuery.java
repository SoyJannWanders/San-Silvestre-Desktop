package com.sansilvestre.desktop.app.category.data.source.sync;

public class UnsyncedCategoryQuery {

    public static final String SELECT_UNSYNCED_CATEGORIES =
            "SELECT * FROM unsynced_category ORDER BY created_at ASC;";

    public static final String ADD_UNSYNCED_CATEGORIES_IN_QUEUE =
            "INSERT INTO unsynced_category (category_id, type) VALUES (?, ?);";

    public static final String DELETE_UNSYNCED_CATEGORIES_OF_QUEUE_BY_ID =
            "DELETE FROM unsynced_category WHERE id = ?;";

}