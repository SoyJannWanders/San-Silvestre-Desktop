package com.sansilvestre.desktop.app.product.main.screen;

public abstract class ProductEvent {

    public static final class GetProductList extends ProductEvent {}

    public static final class SearchProduct extends ProductEvent {

        private final String query;

        public SearchProduct(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }

    }

}