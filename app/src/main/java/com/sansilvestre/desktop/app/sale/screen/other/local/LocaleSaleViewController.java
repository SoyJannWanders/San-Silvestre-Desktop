package com.sansilvestre.desktop.app.sale.screen.other.local;

import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;

import java.util.List;

public interface LocaleSaleViewController {

    void setSaleList(List<Sale> sales);

    void setItemList(List<Item> items);

}