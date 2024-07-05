package com.sansilvestre.desktop.app.splash.module;

import com.sansilvestre.desktop.app.session.data.repository.SessionRepositoryImplementation;
import com.sansilvestre.desktop.app.session.data.source.SessionStorage;
import com.sansilvestre.desktop.app.session.domain.repository.SessionRepository;
import com.sansilvestre.desktop.app.session.domain.usecase.GetSession;
import com.sansilvestre.desktop.app.setting.data.repository.SettingRepositoryImplementation;
import com.sansilvestre.desktop.app.setting.data.source.SettingStorage;
import com.sansilvestre.desktop.app.setting.domain.repository.SettingRepository;
import com.sansilvestre.desktop.app.setting.domain.usecase.GetSetting;
import com.sansilvestre.desktop.app.splash.screen.SplashViewModel;

public class SplashModule {

    private static SplashModule instance;

    private final SettingRepository settingRepository;
    private final SessionRepository sessionRepository;

    public SplashModule() {
        settingRepository = new SettingRepositoryImplementation(new SettingStorage());
        sessionRepository = new SessionRepositoryImplementation(new SessionStorage());
    }

    public static SplashModule getInstance() {
        if (instance == null)
            instance = new SplashModule();
        return instance;
    }

    public SplashViewModel provideSplashViewModel() {
        return new SplashViewModel(
                provideGetSettingUseCase(),
                provideGetSessionUseCase()
        );
    }

    private GetSetting provideGetSettingUseCase() {
        return new GetSetting(settingRepository);
    }

    private GetSession provideGetSessionUseCase() {
        return new GetSession(sessionRepository);
    }

}