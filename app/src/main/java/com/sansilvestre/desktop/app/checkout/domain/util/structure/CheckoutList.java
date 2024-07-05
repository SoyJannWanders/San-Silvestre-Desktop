package com.sansilvestre.desktop.app.checkout.domain.util.structure;

import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckoutList {

    public static List<Checkout> valueOf(ResultSet result) throws SQLException {
        List<Checkout> checkouts = new ArrayList<>();
        while (result.next()) {
            checkouts.add(new Checkout(result));
        }
        return checkouts;
    }

}