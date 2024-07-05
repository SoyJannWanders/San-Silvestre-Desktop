package com.sansilvestre.desktop.app.setting.domain.usecase;

import com.sansilvestre.desktop.app.setting.domain.repository.SettingRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class GetSetting {

    private final SettingRepository repository;

    public GetSetting(SettingRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute() {
        return repository.getSetting();
    }

}