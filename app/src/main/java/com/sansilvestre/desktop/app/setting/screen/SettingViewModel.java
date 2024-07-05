package com.sansilvestre.desktop.app.setting.screen;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchList;
import com.sansilvestre.desktop.app.branch.screen.BranchEvent;
import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.setting.domain.usecase.AddSetting;
import com.sansilvestre.desktop.app.setting.domain.usecase.GetSetting;
import com.sansilvestre.desktop.app.setting.domain.usecase.UpdateSetting;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;

public class SettingViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private SettingViewController viewController;

    private final GetSetting getSetting;
    private final AddSetting addSetting;
    private final UpdateSetting updateSetting;

    private final GetBranchList getBranchList;

    public SettingViewModel(
            GetSetting getSetting,
            AddSetting addSetting,
            UpdateSetting updateSetting,
            GetBranchList getBranchList
    ) {
        this.getSetting = getSetting;
        this.addSetting = addSetting;
        this.updateSetting = updateSetting;
        this.getBranchList = getBranchList;
    }

    public void setViewController(SettingViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(SettingEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof SettingEvent.GetSettingEvent) {
                    ResponseHandler.handleResponse(getSetting.execute(), viewStateController, () -> {
                        viewController.setSetting();
                    });
                } else if (event instanceof SettingEvent.AddSettingEvent) {
                    Setting setting = ((SettingEvent.AddSettingEvent) event).getSetting();
                    ResponseHandler.handleResponse(addSetting.execute(setting), viewStateController, () -> {
                        viewController.restart();
                    });
                } else if (event instanceof SettingEvent.UpdateSettingEvent) {
                    Setting setting = ((SettingEvent.UpdateSettingEvent) event).getSetting();
                    ResponseHandler.handleResponse(updateSetting.execute(setting), viewStateController, () -> {
                        viewController.refresh();
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

    public void onEvent(BranchEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof BranchEvent.GetBranchListEvent) {
                    ResponseHandler.handleResponse(getBranchList.execute(), viewStateController, branches -> {
                        viewController.setBranchList(branches);
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}