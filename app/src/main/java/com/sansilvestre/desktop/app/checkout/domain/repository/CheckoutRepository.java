package com.sansilvestre.desktop.app.checkout.domain.repository;

import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public interface CheckoutRepository {

    Response<List<Checkout>> getCheckoutList();

    Response<Integer> addCheckout(Checkout checkout);

    Response<Void> updateCheckout(Checkout checkout);

    Response<Void> deleteCheckoutByID(int id);

}