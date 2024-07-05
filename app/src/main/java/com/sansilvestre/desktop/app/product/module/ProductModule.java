package com.sansilvestre.desktop.app.product.module;

import com.sansilvestre.desktop.app.branch.data.repository.BranchRepositoryImplementation;
import com.sansilvestre.desktop.app.branch.data.source.BranchAPI;
import com.sansilvestre.desktop.app.branch.data.source.BranchStorage;
import com.sansilvestre.desktop.app.branch.domain.repository.BranchRepository;
import com.sansilvestre.desktop.app.branch.domain.usecase.GetBranchMap;
import com.sansilvestre.desktop.app.category.data.repository.CategoryRepositoryImplementation;
import com.sansilvestre.desktop.app.category.data.source.CategoryStorage;
import com.sansilvestre.desktop.app.category.data.source.CategoryAPI;
import com.sansilvestre.desktop.app.category.domain.repository.CategoryRepository;
import com.sansilvestre.desktop.app.category.domain.usecase.GetCategoryMap;
import com.sansilvestre.desktop.app.product.domain.usecase.DeleteProductByBarcode;
import com.sansilvestre.desktop.app.product.domain.usecase.*;
import com.sansilvestre.desktop.app.product.data.repository.ProductRepositoryImplementation;
import com.sansilvestre.desktop.app.product.data.source.ProductStorage;
import com.sansilvestre.desktop.app.product.data.source.ProductAPI;
import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.domain.util.SetProductViewController;
import com.sansilvestre.desktop.app.product.domain.util.StartProductSync;
import com.sansilvestre.desktop.app.product.domain.util.StopProductSync;
import com.sansilvestre.desktop.app.product.domain.usecase.AddProduct;
import com.sansilvestre.desktop.app.product.screen.add.AddProductViewModel;
import com.sansilvestre.desktop.app.product.screen.ProductViewModel;
import com.sansilvestre.desktop.app.product.screen.other.search.SearchProductViewModel;
import com.sansilvestre.desktop.app.product.screen.update.UpdateProductViewModel;

public class ProductModule {

    private static ProductModule instance;

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;
    private final BranchRepository branchRepository;

    private ProductModule() {
        productRepository = new ProductRepositoryImplementation(new ProductStorage(), new ProductAPI());
        categoryRepository = new CategoryRepositoryImplementation(new CategoryStorage(), new CategoryAPI());
        branchRepository = new BranchRepositoryImplementation(new BranchStorage(), new BranchAPI());
    }

    public static ProductModule getInstance() {
        if (instance == null) {
            instance = new ProductModule();
        }
        return instance;
    }

    public ProductViewModel provideProductViewModel() {
        return new ProductViewModel(
                provideSetViewController(),
                provideStartSyncProductsUseCase(),
                provideStopSyncProductsUseCase(),
                provideGetProductListUseCase(),
                provideGetProductListBySearchUseCase(),
                provideGetProductListByCategoryIDUseCase(),
                provideGetProductListByBranchIDUseCase(),
                provideDeleteProductByBarcodeUseCase(),
                provideGetCategoryMapUseCase(),
                provideGetBranchMapUseCase()
        );
    }

    public SetProductViewController provideSetViewController(){
        return new SetProductViewController(productRepository);
    }

    private StartProductSync provideStartSyncProductsUseCase() {
        return new StartProductSync(productRepository);
    }

    private StopProductSync provideStopSyncProductsUseCase() {
        return new StopProductSync(productRepository);
    }

    private GetProductList provideGetProductListUseCase() {
        return new GetProductList(productRepository);
    }

    private GetProductListBySearch provideGetProductListBySearchUseCase() {
        return new GetProductListBySearch(productRepository);
    }

    private GetProductListByCategoryID provideGetProductListByCategoryIDUseCase() {
        return new GetProductListByCategoryID(productRepository);
    }

    private GetProductListByBranchID provideGetProductListByBranchIDUseCase() {
        return new GetProductListByBranchID(productRepository);
    }

    private DeleteProductByBarcode provideDeleteProductByBarcodeUseCase() {
        return new DeleteProductByBarcode(productRepository);
    }

    private GetCategoryMap provideGetCategoryMapUseCase() {
        return new GetCategoryMap(categoryRepository);
    }

    private GetBranchMap provideGetBranchMapUseCase() {
        return new GetBranchMap(branchRepository);
    }

    public AddProductViewModel provideAddProductViewModel() {
        return new AddProductViewModel(
                provideAddProductUseCase()
        );
    }

    private AddProduct provideAddProductUseCase() {
        return new AddProduct(productRepository);
    }

    public UpdateProductViewModel provideUpdateProductViewModel() {
        return new UpdateProductViewModel(
                provideUpdateProductUseCase()
        );
    }

    private UpdateProduct provideUpdateProductUseCase() {
        return new UpdateProduct(productRepository);
    }



    public SearchProductViewModel provideSearchProductViewModel() {
        return new SearchProductViewModel(
                provideGetProductListUseCase(),
                provideGetProductListBySearchUseCase()
        );
    }

}