package com.sansilvestre.desktop.app.product.add.domain.usecase;

import com.sansilvestre.desktop.app.product.add.domain.model.ProductFormData;
import com.sansilvestre.desktop.app.product.main.domain.repository.ProductRepository;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.util.Response;

import java.time.LocalDate;

public class InsertProductUseCase {

    private final ProductRepository repository;

    public InsertProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public Response<Void> execute(ProductFormData data) {
        String code = isValid(data);
        if (code.equals("Code: 200 OK"))
            return repository.addProduct(
                    new Product()
                            .setBarcode(data.getBarcode())
                            .setLabel(data.getLabel())
                            .setAddedDate(LocalDate.now())
                            .setUpdatedDate(LocalDate.now())
                            .setCategory(data.getCategory())
                            .setStock(data.getStock())
                            .setUID(123)
                            .setOID(123)
                            .setCost(data.getCost())
                            .setAdditionalTaxes(data.hasAdditionalTaxes())
            );
        else
            return new Response.Failure<>(code);
    }

    private String isValid(ProductFormData data) {
        if (isEmpty(data.getBarcode()))
            return "Code: Barcode";
        if (isEmpty(data.getLabel()))
            return "Code: Label";
        if (isEmpty(data.getCost()))
            return "Code: Cost";
        if (isEmpty(data.getCategory()))
            return "Code: Category";
        if (isEmpty(data.getStock()))
            return "Code: Stock";
        return "Code: 200 OK";
    }

    private boolean isEmpty(String value) {
        return value.isEmpty() || value.isBlank();
    }

}