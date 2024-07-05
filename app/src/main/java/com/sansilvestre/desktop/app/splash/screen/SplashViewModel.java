package com.sansilvestre.desktop.app.splash.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.session.domain.usecase.GetSession;
import com.sansilvestre.desktop.app.setting.domain.usecase.GetSetting;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class SplashViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private SplashViewController viewController;

    private final GetSetting getSetting;

    private final GetSession getSession;

    public SplashViewModel(
            GetSetting getSetting,
            GetSession getSession
    ) {
        this.getSetting = getSetting;
        this.getSession = getSession;
    }

    public void setViewController(SplashViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(SplashEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                if (event instanceof SplashEvent.GetSettingEvent) {
                    ResponseHandler.handleResponse(getSetting.execute(), viewStateController, () -> {
                        viewController.getSetting();
                    });
                } else if (event instanceof SplashEvent.GetSessionEvent) {
                    ResponseHandler.handleResponse(getSession.execute(), viewStateController, session -> {
                        viewController.setSession(session);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}