package com.sansilvestre.desktop.app.user.screen;

import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.util.objects.IncreaseType;

public abstract class UserEvent {

    public static final class GetUserListEvent extends UserEvent {}

    public static final class GetUserListBySearchEvent extends UserEvent {

        private final String search;

        public GetUserListBySearchEvent(String search) {
            this.search = search;
        }

        public String getSearch() {
            return search;
        }

    }

    public static final class GetUserListByRoleEvent extends UserEvent {

        private final Role role;

        public GetUserListByRoleEvent(Role role) {
            this.role = role;
        }

        public Role getRole() {
            return role;
        }

    }

    public static final class GetUserListByBranchIDEvent extends UserEvent {

        private final int branchId;

        public GetUserListByBranchIDEvent(int branchId) {
            this.branchId = branchId;
        }

        public int getBranchId() {
            return branchId;
        }

    }



    public static final class AddUserEvent extends UserEvent {

        private final User user;

        public AddUserEvent(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

    }



    public static final class UpdateUserEvent extends UserEvent {

        private final User user;

        public UpdateUserEvent(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

    }

    public static final class UpdateUserSalaryByIDEvent extends UserEvent {

        private final double salary;
        private final int id;

        public UpdateUserSalaryByIDEvent(double salary, int id) {
            this.salary = salary;
            this.id = id;
        }

        public double getSalary() {
            return salary;
        }

        public int getId() {
            return id;
        }

    }

    public static final class UpdateUsersSalariesByBranchIDEvent extends UserEvent {

        private final IncreaseType increaseType;
        private final double increase;
        private final int branchId;

        public UpdateUsersSalariesByBranchIDEvent(IncreaseType increaseType, double increase, int branchId) {
            this.increaseType = increaseType;
            this.increase = increase;
            this.branchId = branchId;
        }

        public int getBranchId() {
            return branchId;
        }

        public IncreaseType getIncreaseType() {
            return increaseType;
        }

        public double getIncrease() {
            return increase;
        }

    }



    public static final class DeleteUserByIdEvent extends UserEvent {

        private final int id;

        public DeleteUserByIdEvent(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }



    public static final class GetRoleListEvent extends UserEvent {}

    public static final class GetBranchListEvent extends UserEvent {}

}