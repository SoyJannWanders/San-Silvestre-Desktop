package com.sansilvestre.desktop.app.setting.domain.repository;

import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.util.data.response.Response;

public interface SettingRepository {

    Response<Void> getSetting();

    Response<Void> addSetting(Setting setting);

    Response<Void> updateSetting(Setting setting);

}