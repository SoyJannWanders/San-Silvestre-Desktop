package com.sansilvestre.desktop.app.product.domain.usecase;

import com.sansilvestre.desktop.app.product.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.util.data.response.Response;

public class UpdateProductsPricesByBranchID {

    private final ProductRepository repository;

    public UpdateProductsPricesByBranchID(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(double percentage, int office) {
        return repository.updateProductsPricesByBranchID(percentage, office);
    }

}