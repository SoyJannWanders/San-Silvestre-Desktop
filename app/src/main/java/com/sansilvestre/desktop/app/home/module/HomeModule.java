package com.sansilvestre.desktop.app.home.module;

import com.sansilvestre.desktop.app.branch.data.repository.BranchRepositoryImplementation;
import com.sansilvestre.desktop.app.branch.data.source.BranchAPI;
import com.sansilvestre.desktop.app.branch.data.source.BranchStorage;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchMap;
import com.sansilvestre.desktop.app.home.screen.HomeViewModel;
import com.sansilvestre.desktop.app.sale.data.repository.SaleRepositoryImplementation;
import com.sansilvestre.desktop.app.sale.data.source.SaleStorage;
import com.sansilvestre.desktop.app.sale.domain.repository.SaleRepository;
import com.sansilvestre.desktop.app.sale.domain.usecase.GetSaleList;

public class HomeModule {

    private static HomeModule instance;

    private final BranchRepository branchRepository;
    private final SaleRepository saleRepository;

    private HomeModule() {
        branchRepository = new BranchRepositoryImplementation(new BranchStorage(), new BranchAPI());
        saleRepository = new SaleRepositoryImplementation(new SaleStorage());
    }

    public static HomeModule getInstance() {
        if (instance == null)
            instance = new HomeModule();
        return instance;
    }

    public HomeViewModel provideHomeViewModel() {
        return new HomeViewModel(
                provideGetBranchMapUseCase(),
                provideGetSaleListUseCase()
        );
    }

    private GetBranchMap provideGetBranchMapUseCase() {
        return new GetBranchMap(branchRepository);
    }

    private GetSaleList provideGetSaleListUseCase() {
        return new GetSaleList(saleRepository);
    }

}