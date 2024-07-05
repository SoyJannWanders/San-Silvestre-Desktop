package com.sansilvestre.desktop.app.shift.screen;

import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;

import java.util.List;

public interface ShiftViewController {

    void setShiftList(List<Shift> shifts);
    void setCheckoutList(List<Checkout> checkouts);

    void refresh();

}