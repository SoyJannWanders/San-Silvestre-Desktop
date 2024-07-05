package com.sansilvestre.desktop.app.product.screen;

import com.sansilvestre.desktop.app.product.domain.model.Product;

public abstract class ProductEvent {

    public static final class InitializeListenersEvent extends ProductEvent {}



    public static final class GetProductListEvent extends ProductEvent {}

    public static final class GetProductListBySearchEvent extends ProductEvent {

        private final String search;

        public GetProductListBySearchEvent(String search) {
            this.search = search;
        }

        public String getSearch() {
            return search;
        }

    }

    public static final class GetProductListByCategoryIDEvent extends ProductEvent {

        private final int categoryId;

        public GetProductListByCategoryIDEvent(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getCategoryId() {
            return categoryId;
        }

    }

    public static final class GetProductListByBranchIDEvent extends ProductEvent {

        private final int branchId;

        public GetProductListByBranchIDEvent(int branchId) {
            this.branchId = branchId;
        }

        public int getBranchId() {
            return branchId;
        }

    }



    public static final class AddProductEvent extends ProductEvent {

        private final Product product;

        public AddProductEvent(Product product) {
            this.product = product;
        }

        public Product getProduct() {
            return product;
        }

    }



    public static final class UpdateProductEvent extends ProductEvent {

        private final Product product;

        public UpdateProductEvent(Product product) {
            this.product = product;
        }

        public Product getProduct() {
            return product;
        }

    }

    public static final class UpdateProductStockByBarcodeEvent extends ProductEvent {

        private final int stock;
        private final String barcode;

        public UpdateProductStockByBarcodeEvent(int stock, String barcode) {
            this.stock = stock;
            this.barcode = barcode;
        }

        public int getStock() {
            return stock;
        }

        public String getBarcode() {
            return barcode;
        }

    }

    public static final class UpdateProductPriceByBarcodeEvent extends ProductEvent {

        private final double increase;
        private final String barcode;

        public UpdateProductPriceByBarcodeEvent(double increase, String barcode) {
            this.increase = increase;
            this.barcode = barcode;
        }

        public double getIncrease() {
            return increase;
        }

        public String getBarcode() {
            return barcode;
        }

    }

    public static final class UpdateProductsPricesByCategoryIDEvent extends ProductEvent {

        private final double increase;
        private final int categoryId;

        public UpdateProductsPricesByCategoryIDEvent(double increase, int categoryId) {
            this.increase = increase;
            this.categoryId = categoryId;
        }

        public double getIncrease() {
            return increase;
        }

        public int getCategoryId() {
            return categoryId;
        }

    }

    public static final class UpdateProductsPricesByBranchIDEvent extends ProductEvent {

        private final double increase;
        private final int branchId;

        public UpdateProductsPricesByBranchIDEvent(double increase, int branchId) {
            this.increase = increase;
            this.branchId = branchId;
        }

        public double getIncrease() {
            return increase;
        }

        public int getBranchId() {
            return branchId;
        }

    }



    public static final class DeleteProductByBarcodeEvent extends ProductEvent {

        private final String barcode;

        public DeleteProductByBarcodeEvent(String barcode) {
            this.barcode = barcode;
        }

        public String getBarcode() {
            return barcode;
        }

    }



    public static final class GetStockListEvent extends ProductEvent {}

    public static final class GetCategoryMapEvent extends ProductEvent {}

    public static final class GetBranchMapEvent extends ProductEvent {}

}