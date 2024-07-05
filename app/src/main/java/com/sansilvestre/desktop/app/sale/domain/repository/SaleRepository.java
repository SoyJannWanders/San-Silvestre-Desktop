package com.sansilvestre.desktop.app.sale.domain.repository;

import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.util.data.response.Response;

import java.util.List;

public interface SaleRepository {

    Response<List<Sale>> getSaleList();
    Response<List<Sale>> getSaleListByBranchID(int branchId);

    Response<List<Item>> getSaleItemListBySaleID(int saleId);

    Response<Void> addSale(Sale sale);

}