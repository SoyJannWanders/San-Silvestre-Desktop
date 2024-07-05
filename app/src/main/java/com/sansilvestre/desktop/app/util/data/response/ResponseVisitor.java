package com.sansilvestre.desktop.app.util.data.response;

public interface ResponseVisitor<T> {

    void visitSuccess(Response.Success<T> success);
    void visitFailure(Response.Failure<T> failure);

}