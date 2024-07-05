package com.sansilvestre.desktop.app.sale.domain.usecase;

import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.sale.domain.repository.SaleRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetSaleItemListBySaleID {

    private final SaleRepository repository;

    public GetSaleItemListBySaleID(SaleRepository repository) {
        this.repository = repository;
    }

    public Response<List<Item>> execute(int saleId) {
        return repository.getSaleItemListBySaleID(saleId);
    }

}