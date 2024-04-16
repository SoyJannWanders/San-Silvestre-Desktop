package com.sansilvestre.desktop.app.product.add.screen;

import com.sansilvestre.desktop.app.product.add.domain.usecase.InsertProductUseCase;
import com.sansilvestre.desktop.app.product.add.domain.util.DateParser;
import com.sansilvestre.desktop.app.product.add.domain.util.Office;
import com.sansilvestre.desktop.app.product.add.domain.util.Utilities;
import com.sansilvestre.desktop.app.product.util.Billing;
import com.sansilvestre.desktop.app.product.util.Response;

import java.time.LocalDate;

public class AddProductViewModel {

    private AddProductState state;

    private final InsertProductUseCase insertProductUseCase;

    private final Office office = new Office();
    private final DateParser dateParser = new DateParser();
    private final Billing billing = new Billing();

    public AddProductViewModel(InsertProductUseCase insertProductUseCase) {
        this.insertProductUseCase = insertProductUseCase;
    }

    public void setState(AddProductState state) {
        this.state = state;
    }

    public void onEvent(AddProductEvent event) {
        if (event instanceof AddProductEvent.OnOfficeChange) {
            state.updateOffice(office.getOffice());
        }
        if (event instanceof AddProductEvent.OnDateChange) {
            state.updateDate(dateParser.parse(LocalDate.now()));
        }
        if (event instanceof AddProductEvent.OnApplyIVA || event instanceof AddProductEvent.OnCostChange) {
            if (event instanceof AddProductEvent.OnApplyIVA) {
                if (((AddProductEvent.OnApplyIVA) event).isApply())
                    Utilities.add(0.21);
                else
                    Utilities.remove(0.21);
            }
            if (event instanceof AddProductEvent.OnCostChange) {
                billing.build(((AddProductEvent.OnCostChange) event).getCost());
            }
            state.updateBilling(
                    billing.getInput(),
                    billing.getFormattedCost(),
                    billing.getFormattedProfit(),
                    billing.getFormattedPrice(),
                    billing.getFormattedRoundedPrice()
            );
        }
        if (event instanceof AddProductEvent.OnAddProduct) {
            Response<Void> response = insertProductUseCase.execute(((AddProductEvent.OnAddProduct) event).getProduct());
            if (response instanceof Response.Success<Void>) {
                state.closeFormAfterInserction();
            }
            if (response instanceof Response.Failure<Void>) {
                state.displayErrorPopup(((Response.Failure<Void>) response).getException());
            }
        }
    }

}