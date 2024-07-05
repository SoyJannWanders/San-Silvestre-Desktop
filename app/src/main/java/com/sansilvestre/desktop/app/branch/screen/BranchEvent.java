package com.sansilvestre.desktop.app.branch.screen;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;

public abstract class BranchEvent {

    public static final class GetBranchListEvent extends BranchEvent {}

    public static final class GetBranchListBySearchEvent extends BranchEvent {

        private final String search;

        public GetBranchListBySearchEvent(String search) {
            this.search = search;
        }

        public String getSearch() {
            return search;
        }

    }



    public static final class AddBranchEvent extends BranchEvent {

        private final Branch branch;

        public AddBranchEvent(Branch branch) {
            this.branch = branch;
        }

        public Branch getBranch() {
            return branch;
        }

    }



    public static final class UpdateBranchEvent extends BranchEvent {

        private final Branch branch;

        public UpdateBranchEvent(Branch branch) {
            this.branch = branch;
        }

        public Branch getBranch() {
            return branch;
        }

    }



    public static final class DeleteBranchByIDEvent extends BranchEvent {

        private final int id;

        public DeleteBranchByIDEvent(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }



    public static final class GetSaleListEvent extends BranchEvent {}

}