package com.sansilvestre.desktop.app.sale.domain.usecase;

import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.sale.domain.repository.SaleRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetSaleList {

    private final SaleRepository repository;

    public GetSaleList(SaleRepository repository) {
        this.repository = repository;
    }

    public Response<List<Sale>> execute() {
        return repository.getSaleList();
    }

}