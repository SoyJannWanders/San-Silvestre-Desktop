package com.sansilvestre.desktop.app.product.util;

public abstract class Response<T> {

    public static class Loading<T> extends Response<T> {}

    public static class Success<T> extends Response<T> {

        private T object;

        public Success(T object) {
            this.object = object;
        }

        public T getObject() {
            return object;
        }

    }

    public static class Failure<T> extends Response<T> {

        private String exception;

        public Failure(String exception) {
            this.exception = exception;
        }

        public String getException() {
            return exception;
        }

    }

}