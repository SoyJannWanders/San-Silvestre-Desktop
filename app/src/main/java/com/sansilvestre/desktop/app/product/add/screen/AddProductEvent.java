package com.sansilvestre.desktop.app.product.add.screen;

import com.sansilvestre.desktop.app.product.add.domain.model.ProductFormData;

public abstract class AddProductEvent {

    public static final class OnOfficeChange extends AddProductEvent {}

    public static final class OnDateChange extends AddProductEvent {}

    public static final class OnApplyIVA extends AddProductEvent {

        private final boolean apply;

        public OnApplyIVA(boolean apply) {
            this.apply = apply;
        }

        public boolean isApply() {
            return apply;
        }

    }

    public static final class OnCostChange extends AddProductEvent {

        private final String cost;

        public OnCostChange(String cost) {
            this.cost = cost;
        }

        public String getCost() {
            return cost;
        }

    }

    public static final class OnAddProduct extends AddProductEvent {

        private final ProductFormData product;

        public OnAddProduct(ProductFormData product) {
            this.product = product;
        }

        public ProductFormData getProduct() {
            return product;
        }

    }

}