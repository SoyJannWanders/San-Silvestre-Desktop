package com.sansilvestre.desktop.app.checkout.data.repository;

import com.sansilvestre.desktop.app.checkout.data.source.CheckoutStorage;
import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.checkout.domain.repository.CheckoutRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;

import java.util.List;

public class CheckoutRepositoryImplementation implements CheckoutRepository {

    private final CheckoutStorage storage;

    public CheckoutRepositoryImplementation(CheckoutStorage storage) {
        this.storage = storage;
    }

    @Override
    public Response<List<Checkout>> getCheckoutList() {
        Response<List<Checkout>> getCheckoutList = storage.getCheckoutList();
        getCheckoutList.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<List<Checkout>> success) {

            }

            @Override
            public void visitFailure(Response.Failure<List<Checkout>> failure) {

            }

        });
        return getCheckoutList;
    }

    @Override
    public Response<Integer> addCheckout(Checkout checkout) {
        Response<Integer> addCheckout = storage.addCheckout(checkout);
        addCheckout.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Integer> success) {

            }

            @Override
            public void visitFailure(Response.Failure<Integer> failure) {

            }

        });
        return addCheckout;
    }

    @Override
    public Response<Void> updateCheckout(Checkout checkout) {
        Response<Void> updateCheckout = storage.updateCheckout(checkout);
        updateCheckout.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {

            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {

            }

        });
        return updateCheckout;
    }

    @Override
    public Response<Void> deleteCheckoutByID(int id) {
        Response<Void> deleteCheckoutByID = storage.deleteCheckoutByID(id);
        deleteCheckoutByID.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {

            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {

            }

        });
        return deleteCheckoutByID;
    }
}