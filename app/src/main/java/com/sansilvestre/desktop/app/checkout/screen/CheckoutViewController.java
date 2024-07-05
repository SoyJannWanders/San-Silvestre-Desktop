package com.sansilvestre.desktop.app.checkout.screen;

import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.session.domain.model.Session;

public interface CheckoutViewController {

    void setItem(Item item);

    void setSession(Session session);

    void reset();

}