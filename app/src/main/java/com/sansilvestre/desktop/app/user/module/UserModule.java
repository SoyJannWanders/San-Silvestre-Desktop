package com.sansilvestre.desktop.app.user.module;

import com.sansilvestre.desktop.app.branch.data.repository.BranchRepositoryImplementation;
import com.sansilvestre.desktop.app.branch.data.source.BranchAPI;
import com.sansilvestre.desktop.app.branch.data.source.BranchStorage;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchMap;
import com.sansilvestre.desktop.app.user.data.repository.UserRepositoryImplementation;
import com.sansilvestre.desktop.app.user.data.source.UserStorage;
import com.sansilvestre.desktop.app.user.data.source.UserAPI;
import com.sansilvestre.desktop.app.user.domain.repository.UserRepository;
import com.sansilvestre.desktop.app.user.domain.usecase.*;
import com.sansilvestre.desktop.app.user.domain.util.SetUserViewController;
import com.sansilvestre.desktop.app.user.domain.util.StartUserSync;
import com.sansilvestre.desktop.app.user.domain.util.StopUserSync;
import com.sansilvestre.desktop.app.user.screen.add.AddUserViewModel;
import com.sansilvestre.desktop.app.user.screen.update.UpdateUserSalaryViewModel;
import com.sansilvestre.desktop.app.user.screen.update.UpdateUsersSalariesViewModel;
import com.sansilvestre.desktop.app.user.screen.update.UpdateUserViewModel;
import com.sansilvestre.desktop.app.user.screen.UserViewModel;

public class UserModule {

    private static UserModule instance;

    private final BranchRepository branchRepository;
    private final UserRepository userRepository;

    public UserModule() {
        branchRepository = new BranchRepositoryImplementation(new BranchStorage(), new BranchAPI());
        userRepository = new UserRepositoryImplementation(new UserStorage(), new UserAPI());
    }

    public static UserModule getInstance() {
        if (instance == null)
            instance = new UserModule();
        return instance;
    }

    public UserViewModel provideUserViewModel() {
        return new UserViewModel(
                provideSetUserViewControllerUseCase(),
                provideStartUserSyncUseCase(),
                provideStopUserSyncUseCase(),
                provideGetUserListUseCase(),
                provideGetUserListBySearchUseCase(),
                provideGetUserListByRoleUseCase(),
                provideGetUserListByBranchIDUseCase(),
                provideDeleteUserByIDUseCase(),
                provideGetBranchListUseCase()
        );
    }

    private SetUserViewController provideSetUserViewControllerUseCase() {
        return new SetUserViewController(userRepository);
    }

    private StartUserSync provideStartUserSyncUseCase() {
        return new StartUserSync(userRepository);
    }

    private StopUserSync provideStopUserSyncUseCase() {
        return new StopUserSync(userRepository);
    }

    private GetUserList provideGetUserListUseCase() {
        return new GetUserList(userRepository);
    }

    private GetUserListBySearch provideGetUserListBySearchUseCase() {
        return new GetUserListBySearch(userRepository);
    }

    private GetUserListByRole provideGetUserListByRoleUseCase() {
        return new GetUserListByRole(userRepository);
    }

    private GetUserListByBranchID provideGetUserListByBranchIDUseCase() {
        return new GetUserListByBranchID(userRepository);
    }

    private DeleteUserByID provideDeleteUserByIDUseCase() {
        return new DeleteUserByID(userRepository);
    }

    private GetBranchMap provideGetBranchListUseCase() {
        return new GetBranchMap(branchRepository);
    }

    public AddUserViewModel provideAddUserViewModel() {
        return new AddUserViewModel(
                provideAddUserUseCase()
        );
    }

    private AddUser provideAddUserUseCase() {
        return new AddUser(userRepository);
    }

    public UpdateUserViewModel provideUpdateUserViewModel() {
        return new UpdateUserViewModel(
                provideUpdateUserUseCase()
        );
    }

    private UpdateUser provideUpdateUserUseCase() {
        return new UpdateUser(userRepository);
    }

    public UpdateUserSalaryViewModel provideUpdateUserSalaryViewModel() {
        return new UpdateUserSalaryViewModel(
                provideUpdateUserSalaryByIDUseCase()
        );
    }

    private UpdateUserSalaryByID provideUpdateUserSalaryByIDUseCase() {
        return new UpdateUserSalaryByID(userRepository);
    }

    public UpdateUsersSalariesViewModel provideUpdateUsersSalariesViewModel() {
        return new UpdateUsersSalariesViewModel(
                provideUpdateUsersSalariesByBranchIDUseCase()
        );
    }

    private UpdateUsersSalariesByBranchID provideUpdateUsersSalariesByBranchIDUseCase() {
        return new UpdateUsersSalariesByBranchID(userRepository);
    }

}