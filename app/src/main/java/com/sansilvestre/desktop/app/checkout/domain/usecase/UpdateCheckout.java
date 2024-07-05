package com.sansilvestre.desktop.app.checkout.domain.usecase;

import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.checkout.domain.repository.CheckoutRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class UpdateCheckout {

    private final CheckoutRepository repository;

    public UpdateCheckout(CheckoutRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(Checkout checkout) {
        return repository.updateCheckout(checkout);
    }

}