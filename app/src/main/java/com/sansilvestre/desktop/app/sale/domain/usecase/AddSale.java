package com.sansilvestre.desktop.app.sale.domain.usecase;

import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.sale.domain.repository.SaleRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class AddSale {

    private final SaleRepository repository;

    public AddSale(SaleRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(Sale sale) {
        return repository.addSale(sale);
    }

}