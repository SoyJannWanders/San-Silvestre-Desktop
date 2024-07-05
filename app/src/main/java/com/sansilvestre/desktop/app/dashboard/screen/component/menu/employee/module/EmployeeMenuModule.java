package com.sansilvestre.desktop.app.dashboard.screen.component.menu.employee.module;

import com.sansilvestre.desktop.app.dashboard.screen.component.menu.employee.screen.EmployeeMenuViewModel;
import com.sansilvestre.desktop.app.session.data.repository.SessionRepositoryImplementation;
import com.sansilvestre.desktop.app.session.data.source.SessionStorage;
import com.sansilvestre.desktop.app.session.domain.repository.SessionRepository;
import com.sansilvestre.desktop.app.session.domain.usecase.GetSession;
import com.sansilvestre.desktop.app.shift.data.repository.ShiftRepositoryImplementation;
import com.sansilvestre.desktop.app.shift.data.source.ShiftAPI;
import com.sansilvestre.desktop.app.shift.data.source.ShiftStorage;
import com.sansilvestre.desktop.app.shift.domain.repository.ShiftRepository;
import com.sansilvestre.desktop.app.shift.domain.usecase.GetShift;

public class EmployeeMenuModule {

    private static EmployeeMenuModule instance;

    private final SessionRepository sessionRepository;
    private final ShiftRepository shiftRepository;

    private EmployeeMenuModule() {
        sessionRepository = new SessionRepositoryImplementation(new SessionStorage());
        shiftRepository = new ShiftRepositoryImplementation(new ShiftStorage(), new ShiftAPI());
    }

    public static EmployeeMenuModule getInstance() {
        if (instance == null)
            instance = new EmployeeMenuModule();
        return instance;
    }

    public EmployeeMenuViewModel provideEmployeeMenuViewModel() {
        return new EmployeeMenuViewModel(
                provideGetSessionUseCase(),
                provideGetShiftUseCase()
        );
    }

    private GetSession provideGetSessionUseCase() {
        return new GetSession(sessionRepository);
    }

    private GetShift provideGetShiftUseCase() {
        return new GetShift(shiftRepository);
    }

}