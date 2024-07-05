package com.sansilvestre.desktop.app.setting.screen;

import com.sansilvestre.desktop.app.setting.domain.model.Setting;

public abstract class SettingEvent {

    public static final class GetSettingEvent extends SettingEvent {}



    public static final class AddSettingEvent extends SettingEvent {

        private final Setting setting;

        public AddSettingEvent(Setting setting) {
            this.setting = setting;
        }

        public Setting getSetting() {
            return setting;
        }

    }



    public static final class UpdateSettingEvent extends SettingEvent {

        private final Setting setting;

        public UpdateSettingEvent(Setting setting) {
            this.setting = setting;
        }

        public Setting getSetting() {
            return setting;
        }

    }

}