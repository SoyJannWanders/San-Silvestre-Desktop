package com.sansilvestre.desktop.app.sale.screen.add;

import com.sansilvestre.desktop.app.client.domain.model.Client;
import com.sansilvestre.desktop.app.sale.domain.model.PaymentMethod;
import com.sansilvestre.desktop.app.user.domain.model.User;

import java.util.List;

public interface AddSaleViewController {

    void setClientList(List<Client> clients);
    void setPaymentMethodList(List<PaymentMethod> paymentMethods);

    void dispose();

}