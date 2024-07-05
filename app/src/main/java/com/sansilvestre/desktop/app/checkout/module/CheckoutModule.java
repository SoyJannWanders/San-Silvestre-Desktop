package com.sansilvestre.desktop.app.checkout.module;

import com.sansilvestre.desktop.app.checkout.data.repository.CheckoutRepositoryImplementation;
import com.sansilvestre.desktop.app.checkout.data.source.CheckoutStorage;
import com.sansilvestre.desktop.app.checkout.domain.repository.CheckoutRepository;
import com.sansilvestre.desktop.app.checkout.screen.CheckoutViewModel;
import com.sansilvestre.desktop.app.product.data.repository.ProductRepositoryImplementation;
import com.sansilvestre.desktop.app.product.data.source.ProductAPI;
import com.sansilvestre.desktop.app.product.data.source.ProductStorage;
import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.domain.usecase.GetProductByBarcode;
import com.sansilvestre.desktop.app.session.data.repository.SessionRepositoryImplementation;
import com.sansilvestre.desktop.app.session.data.source.SessionStorage;
import com.sansilvestre.desktop.app.session.domain.repository.SessionRepository;
import com.sansilvestre.desktop.app.session.domain.usecase.GetSession;

public class CheckoutModule {

    private static CheckoutModule instance;

    private final CheckoutRepository checkoutRepository;

    private final ProductRepository productRepository;
    private final SessionRepository sessionRepository;

    private CheckoutModule() {
        checkoutRepository = new CheckoutRepositoryImplementation(new CheckoutStorage());
        productRepository = new ProductRepositoryImplementation(new ProductStorage(), new ProductAPI());
        sessionRepository = new SessionRepositoryImplementation(new SessionStorage());
    }

    public static CheckoutModule getInstance() {
        if (instance == null)
            instance = new CheckoutModule();
        return instance;
    }

    public CheckoutViewModel provideCheckoutViewModel() {
        return new CheckoutViewModel(
                provideGetProductByBarcodeUseCase(),
                provideGetSessionUseCase()
        );
    }

    private GetProductByBarcode provideGetProductByBarcodeUseCase() {
        return new GetProductByBarcode(productRepository);
    }

    private GetSession provideGetSessionUseCase() {
        return new GetSession(sessionRepository);
    }

}