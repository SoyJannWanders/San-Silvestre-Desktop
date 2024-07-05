package com.sansilvestre.desktop.app.setting.data.repository;

import com.sansilvestre.desktop.app.setting.data.source.SettingStorage;
import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.setting.domain.repository.SettingRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.log.Console;

public class SettingRepositoryImplementation implements SettingRepository {

    private final SettingStorage storage;

    public SettingRepositoryImplementation(SettingStorage storage) {
        this.storage = storage;
    }

    @Override
    public Response<Void> getSetting() {
        Response<Void> getSetting = storage.getSetting();
        getSetting.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: GetSetting");
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: GetSetting");
            }

        });
        return getSetting;
    }

    @Override
    public Response<Void> addSetting(Setting setting) {
        Response<Void> addSetting = storage.addSetting(setting);
        addSetting.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Response<Void> getSetting = storage.getSetting();
                getSetting.accept(new ResponseVisitor<>() {

                    @Override
                    public void visitSuccess(Response.Success<Void> success) {
                        Console.info(Console.InfoCode.I001, "OK: GetSetting");
                    }

                    @Override
                    public void visitFailure(Response.Failure<Void> failure) {
                        Console.warn(Console.WarnCode.W001, "ERROR: GetSetting");
                    }

                });
                Console.info(Console.InfoCode.I001, "OK: AddSetting");
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: AddSetting");
            }

        });
        return addSetting;
    }

    @Override
    public Response<Void> updateSetting(Setting setting) {
        Response<Void> updateSetting = storage.updateSetting(setting);
        updateSetting.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Console.info(Console.InfoCode.I001, "OK: UpdateSetting");
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                Console.warn(Console.WarnCode.W001, "ERROR: UpdateSetting");
            }

        });
        return updateSetting;
    }

}