package com.sansilvestre.desktop.app.product.main.domain.model;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.util.Billing;

import java.util.ArrayList;
import java.util.List;

public class ProductTableModelList {

    private static final Billing billing = new Billing();

    public static List<ProductTableModel> valueOf(List<Product> products) {
        List<ProductTableModel> list = new ArrayList<>();
        for (Product product: products) {
            billing.setCost(product.getCost());
            list.add(
                    new ProductTableModel()
                            .setBarcode(product.getBarcode())
                            .setName(product.getLabel())
                            .setCost(billing.getFormattedCost())
                            .setProfit(billing.getFormattedProfit())
                            .setPrice(billing.getFormattedPrice())
                            .setRoundedPrice(billing.getFormattedRoundedPrice())
                            .setCategory(product.getCategory().getValue())
                            .setStock(product.getStock())
            );
        }
        return list;
    }

}