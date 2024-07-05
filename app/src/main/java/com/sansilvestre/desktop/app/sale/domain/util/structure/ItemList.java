package com.sansilvestre.desktop.app.sale.domain.util.structure;

import com.sansilvestre.desktop.app.checkout.domain.model.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemList {

    public static List<Item> valueOf(ResultSet result) throws SQLException {
        List<Item> items = new ArrayList<>();
        while (result.next()) {
            items.add(new Item(result));
        }
        return items;
    }

}