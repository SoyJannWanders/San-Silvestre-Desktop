package com.sansilvestre.desktop.app.category.screen;

import com.sansilvestre.desktop.app.category.domain.model.Category;

public abstract class CategoryEvent {

    public static final class GetCategoryListEvent extends CategoryEvent {}

    public static final class GetCategoryListBySearchEvent extends CategoryEvent {

        private final String search;

        public GetCategoryListBySearchEvent(String search) {
            this.search = search;
        }

        public String getSearch() {
            return search;
        }

    }



    public static final class AddCategoryEvent extends CategoryEvent {

        private final Category category;

        public AddCategoryEvent(Category category) {
            this.category = category;
        }

        public Category getCategory() {
            return category;
        }

    }



    public static final class UpdateCategoryEvent extends CategoryEvent {

        private final Category category;

        public UpdateCategoryEvent(Category category) {
            this.category = category;
        }

        public Category getCategory() {
            return category;
        }

    }



    public static final class DeleteCategoryByIDEvent extends CategoryEvent {

        private final int id;

        public DeleteCategoryByIDEvent(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }

}