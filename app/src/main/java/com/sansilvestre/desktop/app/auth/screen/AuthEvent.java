package com.sansilvestre.desktop.app.auth.screen;

public abstract class AuthEvent {

    public static final class SignInEvent extends AuthEvent {

        private final int id;
        private final String password;

        public SignInEvent(int id, String password) {
            this.id = id;
            this.password = password;
        }

        public int getId() {
            return id;
        }

        public String getPassword() {
            return password;
        }

    }

}