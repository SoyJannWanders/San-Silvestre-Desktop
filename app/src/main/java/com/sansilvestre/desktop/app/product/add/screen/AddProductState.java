package com.sansilvestre.desktop.app.product.add.screen;

public interface AddProductState {

    void updateOffice(String office);
    void updateDate(String date);

    void updateBilling(String in, String cost, String profit, String price, String roundedPrice);

    void closeFormAfterInserction();
    void displayErrorPopup(String code);

}