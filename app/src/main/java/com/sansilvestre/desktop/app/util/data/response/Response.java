package com.sansilvestre.desktop.app.util.data.response;

public abstract class Response<T> {

    public abstract void accept(ResponseVisitor<T> visitor);

    public static class Success<T> extends Response<T> {

        private final T object;

        public Success(T object) {
            this.object = object;
        }

        public T getObject() {
            return object;
        }

        @Override
        public void accept(ResponseVisitor<T> visitor) {
            visitor.visitSuccess(this);
        }

    }

    public static class Failure<T> extends Response<T> {

        private String message;
        private Exception exception;

        public Failure(String message) {
            this.message = message;
        }

        public Failure(Exception exception) {
            this.exception = exception;
        }

        public String getMessage() {
            return message;
        }

        public Exception getException() {
            return exception;
        }

        @Override
        public void accept(ResponseVisitor<T> visitor) {
            visitor.visitFailure(this);
        }

    }

}