package com.sansilvestre.desktop.app.sale.domain.util.structure;

import com.sansilvestre.desktop.app.sale.domain.model.Sale;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleList {

    public static List<Sale> valueOf(ResultSet result) throws SQLException {
        List<Sale> sales = new ArrayList<>();
        while (result.next()) {
            sales.add(new Sale(result));
        }
        return sales;
    }

}