package com.sansilvestre.desktop.app.session.screen;

public abstract class SessionEvent {

    public static final class OpenSessionEvent extends SessionEvent {

        private final int checkoutId;

        private final double openAmount;

        public OpenSessionEvent(int checkoutId, double openAmount) {
            this.checkoutId = checkoutId;
            this.openAmount = openAmount;
        }

        public int getCheckoutId() {
            return checkoutId;
        }

        public double getOpenAmount() {
            return openAmount;
        }

    }



    public static final class ArchSessionEvent extends SessionEvent {

        private final double openAmount;
        private final double closeAmount;

        private final int id;
        private final int checkoutId;

        public ArchSessionEvent(int id, int checkoutId, double openAmount, double closeAmount) {
            this.id = id;
            this.checkoutId = checkoutId;
            this.openAmount = openAmount;
            this.closeAmount = closeAmount;
        }

        public int getId() {
            return id;
        }

        public int getCheckoutId() {
            return checkoutId;
        }

        public double getOpenAmount() {
            return openAmount;
        }

        public double getCloseAmount() {
            return closeAmount;
        }

    }



    public static final class CloseSessionEvent extends SessionEvent {

        private final int id;
        private final double closeAmount;

        public CloseSessionEvent(int id, double closeAmount) {
            this.id = id;
            this.closeAmount = closeAmount;
        }

        public int getId() {
            return id;
        }

        public double getCloseAmount() {
            return closeAmount;
        }

    }



    public static final class GetTotalAmountBySessionIDEvent extends SessionEvent {

        private final int id;

        public GetTotalAmountBySessionIDEvent(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }

}