package com.sansilvestre.desktop.app.category.data.source.sync;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnsyncedCategoryList {

    public static List<UnsyncedCategory> valueOf(ResultSet result) throws SQLException {
        List<UnsyncedCategory> unsyncedCategories = new ArrayList<>();
        while (result.next()) {
            unsyncedCategories.add(new UnsyncedCategory(result));
        }
        return unsyncedCategories;
    }

}