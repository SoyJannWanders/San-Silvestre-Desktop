package com.sansilvestre.desktop.app.checkout.domain.usecase;

import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.checkout.domain.repository.CheckoutRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetCheckoutList {

    private final CheckoutRepository repository;

    public GetCheckoutList(CheckoutRepository repository) {
        this.repository = repository;
    }

    public Response<List<Checkout>> execute() {
        return repository.getCheckoutList();
    }

}