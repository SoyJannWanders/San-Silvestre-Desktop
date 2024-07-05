package com.sansilvestre.desktop.app.setting.module;

import com.sansilvestre.desktop.app.branch.data.repository.BranchRepositoryImplementation;
import com.sansilvestre.desktop.app.branch.data.source.BranchAPI;
import com.sansilvestre.desktop.app.branch.data.source.BranchStorage;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchList;
import com.sansilvestre.desktop.app.setting.data.repository.SettingRepositoryImplementation;
import com.sansilvestre.desktop.app.setting.data.source.SettingStorage;
import com.sansilvestre.desktop.app.setting.domain.repository.SettingRepository;
import com.sansilvestre.desktop.app.setting.domain.usecase.AddSetting;
import com.sansilvestre.desktop.app.setting.domain.usecase.GetSetting;
import com.sansilvestre.desktop.app.setting.domain.usecase.UpdateSetting;
import com.sansilvestre.desktop.app.setting.screen.SettingViewModel;

public class SettingModule {

    private static SettingModule instance;

    private final SettingRepository settingRepository;

    private final BranchRepository branchRepository;

    public SettingModule() {
        settingRepository = new SettingRepositoryImplementation(new SettingStorage());
        branchRepository = new BranchRepositoryImplementation(new BranchStorage(), new BranchAPI());
    }

    public static SettingModule getInstance() {
        if (instance == null)
            instance = new SettingModule();
        return instance;
    }

    public SettingViewModel provideSettingViewModel() {
        return new SettingViewModel(
                provideGetSettingUseCase(),
                provideAddSettingUseCase(),
                provideUpdateSettingUseCase(),
                provideGetBranchMapListUseCase()
        );
    }

    private GetSetting provideGetSettingUseCase() {
        return new GetSetting(settingRepository);
    }

    private AddSetting provideAddSettingUseCase() {
        return new AddSetting(settingRepository);
    }

    private UpdateSetting provideUpdateSettingUseCase() {
        return new UpdateSetting(settingRepository);
    }

    private GetBranchList provideGetBranchMapListUseCase() {
        return new GetBranchList(branchRepository);
    }

}