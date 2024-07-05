package com.sansilvestre.desktop.app.category.module;

import com.sansilvestre.desktop.app.category.data.repository.CategoryRepositoryImplementation;
import com.sansilvestre.desktop.app.category.data.source.CategoryStorage;
import com.sansilvestre.desktop.app.category.data.source.CategoryAPI;
import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;
import com.sansilvestre.desktop.app.category.domain.usecase.*;
import com.sansilvestre.desktop.app.category.domain.util.SetCategoryViewController;
import com.sansilvestre.desktop.app.category.domain.util.StartCategorySync;
import com.sansilvestre.desktop.app.category.domain.util.StopCategorySync;
import com.sansilvestre.desktop.app.category.screen.CategoryViewModel;
import com.sansilvestre.desktop.app.category.screen.add.AddCategoryViewModel;
import com.sansilvestre.desktop.app.category.screen.update.UpdateCategoryViewModel;

public class CategoryModule {

    private static CategoryModule instance;

    private final CategoryRepository categoryRepository;

    public CategoryModule() {
        categoryRepository = new CategoryRepositoryImplementation(new CategoryStorage(), new CategoryAPI());
    }

    public static CategoryModule getInstance() {
        if (instance == null)
            instance = new CategoryModule();
        return instance;
    }

    public CategoryViewModel provideCategoryViewModel() {
        return new CategoryViewModel(
                provideSetCategoryViewControllerUseCase(),
                provideStartCategorySyncUseCase(),
                provideStopCategorySyncUseCase(),
                provideGetCategoryListUseCase(),
                provideGetCategoryListBySearchUseCase(),
                provideDeleteCategoryByIDUseCase()
        );
    }

    private SetCategoryViewController provideSetCategoryViewControllerUseCase() {
        return new SetCategoryViewController(categoryRepository);
    }

    private StartCategorySync provideStartCategorySyncUseCase() {
        return new StartCategorySync(categoryRepository);
    }

    private StopCategorySync provideStopCategorySyncUseCase() {
        return new StopCategorySync(categoryRepository);
    }

    private GetCategoryList provideGetCategoryListUseCase() {
        return new GetCategoryList(categoryRepository);
    }

    private GetCategoryBySearch provideGetCategoryListBySearchUseCase() {
        return new GetCategoryBySearch(categoryRepository);
    }

    private DeleteCategoryByID provideDeleteCategoryByIDUseCase() {
        return new DeleteCategoryByID(categoryRepository);
    }

    public AddCategoryViewModel provideAddCategoryViewModel() {
        return new AddCategoryViewModel(provideAddCategoryUseCase());
    }

    private AddCategory provideAddCategoryUseCase() {
        return new AddCategory(categoryRepository);
    }

    public UpdateCategoryViewModel provideUpdateCategoryViewModel() {
        return new UpdateCategoryViewModel(
                provideUpdateCategoryUseCase()
        );
    }

    private UpdateCategory provideUpdateCategoryUseCase() {
        return new UpdateCategory(categoryRepository);
    }

}