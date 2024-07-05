package com.sansilvestre.desktop.app.util.data.response;

import com.sansilvestre.desktop.app.ViewStateController;

import javax.swing.*;
import java.util.function.Consumer;

public class ResponseHandler {

    public static <T> void handleResponse(Response<T> response, ViewStateController viewStateController, Consumer<T> onSuccess) {
        response.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<T> success) {
                viewStateController.isSuccess();
                if (onSuccess != null)
                    onSuccess.accept(success.getObject());
            }

            @Override
            public void visitFailure(Response.Failure<T> failure) {
                viewStateController.isFailure(failure.getException());
            }

        });
    }

    public static <T> void handleResponse(Response<T> response, ViewStateController viewStateController, Runnable onSuccess) {
        response.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<T> success) {
                viewStateController.isSuccess();
                if (onSuccess != null)
                    onSuccess.run();
            }

            @Override
            public void visitFailure(Response.Failure<T> failure) {
                viewStateController.isFailure(failure.getException());
            }

        });
    }

}