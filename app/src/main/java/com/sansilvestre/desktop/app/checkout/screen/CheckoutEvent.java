package com.sansilvestre.desktop.app.checkout.screen;

public abstract class CheckoutEvent {

    public static final class UpdateItem extends CheckoutEvent {

        private final int index;

        public UpdateItem(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

    }

    public static final class DeleteItem extends CheckoutEvent {

        private final int index;

        public DeleteItem(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

    }

    public static final class GetProductByBarcodeEvent extends CheckoutEvent {

        private final String barcode;

        public GetProductByBarcodeEvent(String barcode) {
            this.barcode = barcode;
        }

        public String getBarcode() {
            return barcode;
        }

    }



    public static final class GetLastActiveSessionEvent extends CheckoutEvent { }

}