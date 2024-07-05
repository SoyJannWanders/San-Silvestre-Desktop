package com.sansilvestre.desktop.app.checkout.domain.usecase;

import com.sansilvestre.desktop.app.checkout.domain.repository.CheckoutRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class DeleteCheckoutByID {

    private final CheckoutRepository repository;

    public DeleteCheckoutByID(CheckoutRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(int id) {
        return repository.deleteCheckoutByID(id);
    }

}