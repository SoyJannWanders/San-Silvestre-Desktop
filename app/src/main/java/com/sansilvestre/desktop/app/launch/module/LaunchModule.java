package com.sansilvestre.desktop.app.launch.module;

import com.sansilvestre.desktop.app.launch.screen.LaunchViewModel;
import com.sansilvestre.desktop.app.shift.data.repository.ShiftRepositoryImplementation;
import com.sansilvestre.desktop.app.shift.data.source.ShiftAPI;
import com.sansilvestre.desktop.app.shift.data.source.ShiftStorage;
import com.sansilvestre.desktop.app.shift.domain.repository.ShiftRepository;
import com.sansilvestre.desktop.app.shift.domain.usecase.GetShift;
import com.sansilvestre.desktop.app.shift.domain.usecase.GetShiftList;

public class LaunchModule {

    private static LaunchModule instance;

    private final ShiftRepository shiftRepository;

    private LaunchModule() {
        shiftRepository = new ShiftRepositoryImplementation(new ShiftStorage(), new ShiftAPI());
    }

    public static LaunchModule getInstance() {
        if (instance == null)
            instance = new LaunchModule();
        return instance;
    }

    public LaunchViewModel provideLaunchViewModel() {
        return new LaunchViewModel(
                provideGetShiftUseCase(),
                provideGetShiftListUseCase()
        );
    }

    private GetShift provideGetShiftUseCase() {
        return new GetShift(shiftRepository);
    }

    private GetShiftList provideGetShiftListUseCase() {
        return new GetShiftList(shiftRepository);
    }

}