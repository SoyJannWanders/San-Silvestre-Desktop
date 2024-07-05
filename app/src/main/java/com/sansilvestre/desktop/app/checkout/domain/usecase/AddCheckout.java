package com.sansilvestre.desktop.app.checkout.domain.usecase;

import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.checkout.domain.repository.CheckoutRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class AddCheckout {

    private final CheckoutRepository repository;

    public AddCheckout(CheckoutRepository repository) {
        this.repository = repository;
    }

    public Response<Integer> execute(Checkout checkout) {
        return repository.addCheckout(checkout);
    }

}