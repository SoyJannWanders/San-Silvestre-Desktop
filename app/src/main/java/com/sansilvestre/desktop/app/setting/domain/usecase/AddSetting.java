package com.sansilvestre.desktop.app.setting.domain.usecase;

import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.setting.domain.repository.SettingRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class AddSetting {

    private final SettingRepository repository;

    public AddSetting(SettingRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(Setting setting) {
        return repository.addSetting(setting);
    }

}