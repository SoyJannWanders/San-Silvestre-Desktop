package com.sansilvestre.desktop.app.sale.module;

import com.sansilvestre.desktop.app.sale.data.repository.SaleRepositoryImplementation;
import com.sansilvestre.desktop.app.sale.data.source.SaleStorage;
import com.sansilvestre.desktop.app.sale.domain.repository.SaleRepository;
import com.sansilvestre.desktop.app.sale.domain.usecase.AddSale;
import com.sansilvestre.desktop.app.sale.domain.usecase.GetSaleItemListBySaleID;
import com.sansilvestre.desktop.app.sale.domain.usecase.GetSaleListByBranchID;
import com.sansilvestre.desktop.app.sale.screen.add.AddSaleViewModel;
import com.sansilvestre.desktop.app.sale.screen.other.local.LocaleSaleViewModel;
import com.sansilvestre.desktop.app.transaction.data.repository.TransactionRepositoryImplementation;
import com.sansilvestre.desktop.app.transaction.data.source.TransactionStorage;
import com.sansilvestre.desktop.app.transaction.domain.repository.TransactionRepository;
import com.sansilvestre.desktop.app.transaction.domain.usecase.AddTransaction;

public class SaleModule {

    private static SaleModule instance;

    private final SaleRepository saleRepository;

    private final TransactionRepository transactionRepository;

    public SaleModule() {
        saleRepository = new SaleRepositoryImplementation(new SaleStorage());
        transactionRepository = new TransactionRepositoryImplementation(new TransactionStorage());
    }

    public static SaleModule getInstance() {
        if (instance == null)
            instance = new SaleModule();
        return instance;
    }

    public AddSaleViewModel provideAddSaleViewModel() {
        return new AddSaleViewModel(
                provideAddSaleUseCase(),
                provideAddTransactionUseCase()
        );
    }

    private AddSale provideAddSaleUseCase() {
        return new AddSale(saleRepository);
    }

    private AddTransaction provideAddTransactionUseCase() {
        return new AddTransaction(transactionRepository);
    }

    public LocaleSaleViewModel provideLocaleSaleViewModel() {
        return new LocaleSaleViewModel(
                provideGetSaleListByBranchIDUseCase(),
                provideGetSaleItemListBySaleIDUseCase()
        );
    }

    private GetSaleListByBranchID provideGetSaleListByBranchIDUseCase() {
        return new GetSaleListByBranchID(saleRepository);
    }

    private GetSaleItemListBySaleID provideGetSaleItemListBySaleIDUseCase() {
        return new GetSaleItemListBySaleID(saleRepository);
    }

}