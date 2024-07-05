package com.sansilvestre.desktop.app.branch.module;

import com.sansilvestre.desktop.app.branch.data.repository.BranchRepositoryImplementation;
import com.sansilvestre.desktop.app.branch.data.source.BranchAPI;
import com.sansilvestre.desktop.app.branch.data.source.BranchStorage;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.branch.domain.usecase.*;
import com.sansilvestre.desktop.app.branch.domain.util.SetBranchViewController;
import com.sansilvestre.desktop.app.branch.screen.BranchViewModel;
import com.sansilvestre.desktop.app.branch.screen.add.AddBranchViewModel;
import com.sansilvestre.desktop.app.branch.screen.update.UpdateBranchViewModel;
import com.sansilvestre.desktop.app.sale.data.repository.SaleRepositoryImplementation;
import com.sansilvestre.desktop.app.sale.data.source.SaleStorage;
import com.sansilvestre.desktop.app.sale.domain.repository.SaleRepository;
import com.sansilvestre.desktop.app.sale.domain.usecase.GetSaleList;

public class BranchModule {

    private static BranchModule instance;

    private final BranchRepository branchRepository;

    public BranchModule() {
        branchRepository = new BranchRepositoryImplementation(new BranchStorage(), new BranchAPI());
    }

    public static BranchModule getInstance() {
        if (instance == null)
            instance = new BranchModule();
        return instance;
    }

    public BranchViewModel provideBranchViewModel() {
        return new BranchViewModel(
                provideSetBranchViewControllerUseCase(),
                provideGetBranchListUseCase(),
                provideGetBranchListBySearchUseCase(),
                provideDeleteBranchByIDUseCase()
        );
    }

    private SetBranchViewController provideSetBranchViewControllerUseCase() {
        return new SetBranchViewController(branchRepository);
    }

    private GetBranchList provideGetBranchListUseCase() {
        return new GetBranchList(branchRepository);
    }

    private GetBranchListBySearch provideGetBranchListBySearchUseCase() {
        return new GetBranchListBySearch(branchRepository);
    }

    public AddBranchViewModel provideAddBranchViewModel() {
        return new AddBranchViewModel(provideAddBranchUseCase());
    }

    private AddBranch provideAddBranchUseCase() {
        return new AddBranch(branchRepository);
    }

    public UpdateBranchViewModel provideUpdateBranchViewModel() {
        return new UpdateBranchViewModel(
                provideUpdateBranchUseCase()
        );
    }

    private UpdateBranch provideUpdateBranchUseCase() {
        return new UpdateBranch(branchRepository);
    }

    private DeleteBranchByID provideDeleteBranchByIDUseCase() {
        return new DeleteBranchByID(branchRepository);
    }

}