package com.sansilvestre.desktop.app.shift.module;

import com.sansilvestre.desktop.app.branch.data.repository.BranchRepositoryImplementation;
import com.sansilvestre.desktop.app.branch.data.source.BranchAPI;
import com.sansilvestre.desktop.app.branch.data.source.BranchStorage;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchList;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchMap;
import com.sansilvestre.desktop.app.checkout.data.repository.CheckoutRepositoryImplementation;
import com.sansilvestre.desktop.app.checkout.data.source.CheckoutStorage;
import com.sansilvestre.desktop.app.checkout.domain.repository.CheckoutRepository;
import com.sansilvestre.desktop.app.checkout.domain.usecase.AddCheckout;
import com.sansilvestre.desktop.app.checkout.domain.usecase.DeleteCheckoutByID;
import com.sansilvestre.desktop.app.checkout.domain.usecase.GetCheckoutList;
import com.sansilvestre.desktop.app.checkout.domain.usecase.UpdateCheckout;
import com.sansilvestre.desktop.app.shift.data.repository.ShiftRepositoryImplementation;
import com.sansilvestre.desktop.app.shift.data.source.ShiftAPI;
import com.sansilvestre.desktop.app.shift.data.source.ShiftStorage;
import com.sansilvestre.desktop.app.shift.domain.repository.ShiftRepository;
import com.sansilvestre.desktop.app.shift.domain.usecase.AddShift;
import com.sansilvestre.desktop.app.shift.domain.usecase.DeleteShiftByID;
import com.sansilvestre.desktop.app.shift.domain.usecase.GetShiftList;
import com.sansilvestre.desktop.app.shift.domain.usecase.UpdateShift;
import com.sansilvestre.desktop.app.shift.screen.ShiftViewModel;
import com.sansilvestre.desktop.app.shift.screen.add.AddShiftViewModel;
import com.sansilvestre.desktop.app.shift.screen.update.UpdateShiftViewModel;

public class ShiftModule {

    private static ShiftModule instance;

    private final ShiftRepository shiftRepository;

    private final CheckoutRepository checkoutRepository;
    private final BranchRepository branchRepository;

    private ShiftModule() {
        shiftRepository = new ShiftRepositoryImplementation(new ShiftStorage(), new ShiftAPI());
        checkoutRepository = new CheckoutRepositoryImplementation(new CheckoutStorage());
        branchRepository = new BranchRepositoryImplementation(new BranchStorage(), new BranchAPI());
    }

    public static ShiftModule getInstance() {
        if (instance == null)
            instance = new ShiftModule();
        return instance;
    }

    public ShiftViewModel provideShiftViewModel() {
        return new ShiftViewModel(
                provideGetShiftListUseCase(),
                provideDeleteShiftByIDUseCase(),
                provideGetCheckoutListUseCase(),
                provideDeleteCheckoutByIDUseCase()
        );
    }

    private GetShiftList provideGetShiftListUseCase() {
        return new GetShiftList(shiftRepository);
    }

    private DeleteShiftByID provideDeleteShiftByIDUseCase() {
        return new DeleteShiftByID(shiftRepository);
    }

    private GetCheckoutList provideGetCheckoutListUseCase() {
        return new GetCheckoutList(checkoutRepository);
    }

    private DeleteCheckoutByID provideDeleteCheckoutByIDUseCase() {
        return new DeleteCheckoutByID(checkoutRepository);
    }

    public AddShiftViewModel provideAddShiftViewModel() {
        return new AddShiftViewModel(
                provideAddShiftUseCase(),
                provideAddCheckoutUseCase(),
                provideGetBranchListUseCase()
        );
    }

    private AddShift provideAddShiftUseCase() {
        return new AddShift(shiftRepository);
    }

    private AddCheckout provideAddCheckoutUseCase() {
        return new AddCheckout(checkoutRepository);
    }

    private GetBranchList provideGetBranchListUseCase() {
        return new GetBranchList(branchRepository);
    }

    public UpdateShiftViewModel provideUpdateShiftViewModel() {
        return new UpdateShiftViewModel(
                provideUpdateShiftUseCase(),
                provideUpdateCheckoutUseCase(),
                provideGetBranchMapUseCase()
        );
    }

    private UpdateShift provideUpdateShiftUseCase() {
        return new UpdateShift(shiftRepository);
    }

    private UpdateCheckout provideUpdateCheckoutUseCase() {
        return new UpdateCheckout(checkoutRepository);
    }

    private GetBranchMap provideGetBranchMapUseCase() {
        return new GetBranchMap(branchRepository);
    }

}