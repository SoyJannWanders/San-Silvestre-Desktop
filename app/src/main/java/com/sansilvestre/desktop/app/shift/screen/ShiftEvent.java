package com.sansilvestre.desktop.app.shift.screen;

import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;

public abstract class ShiftEvent {

    public static final class GetShiftListEvent extends ShiftEvent {}



    public static final class AddShiftEvent extends ShiftEvent {

        private final Checkout checkout;
        private final Shift shift;

        public AddShiftEvent(Checkout checkout, Shift shift) {
            this.checkout = checkout;
            this.shift = shift;
        }

        public Checkout getCheckout() {
            return checkout;
        }

        public Shift getShift() {
            return shift;
        }

    }



    public static final class UpdateShiftEvent extends ShiftEvent {

        private final Checkout checkout;
        private final Shift shift;

        public UpdateShiftEvent(Checkout checkout, Shift shift) {
            this.checkout = checkout;
            this.shift = shift;
        }

        public Checkout getCheckout() {
            return checkout;
        }

        public Shift getShift() {
            return shift;
        }

    }



    public static final class DeleteShiftByIDEvent extends ShiftEvent {

        private final int id;
        private final int checkoutId;

        public DeleteShiftByIDEvent(int id, int checkoutId) {
            this.id = id;
            this.checkoutId = checkoutId;
        }

        public int getId() {
            return id;
        }

        public int getCheckoutId() {
            return checkoutId;
        }

    }



    public static final class GetCheckoutListEvent extends ShiftEvent {}



    public static final class GetBranchMapEvent extends ShiftEvent {}

    public static final class GetBranchListEvent extends ShiftEvent {}

}