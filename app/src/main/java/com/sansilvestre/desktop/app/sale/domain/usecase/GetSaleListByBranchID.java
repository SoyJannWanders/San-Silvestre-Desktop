package com.sansilvestre.desktop.app.sale.domain.usecase;

import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.sale.domain.repository.SaleRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public class GetSaleListByBranchID {

    private final SaleRepository repository;

    public GetSaleListByBranchID(SaleRepository repository) {
        this.repository = repository;
    }

    public Response<List<Sale>> execute(int branchId) {
        return repository.getSaleListByBranchID(branchId);
    }

}