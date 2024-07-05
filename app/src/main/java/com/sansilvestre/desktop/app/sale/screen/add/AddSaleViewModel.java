package com.sansilvestre.desktop.app.sale.screen.add;

import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.client.domain.model.Client;
import com.sansilvestre.desktop.app.sale.domain.model.PaymentMethod;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.sale.domain.usecase.AddSale;
import com.sansilvestre.desktop.app.sale.screen.SaleEvent;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.transaction.domain.model.Transaction;
import com.sansilvestre.desktop.app.transaction.domain.usecase.AddTransaction;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AddSaleViewModel {

    private final ViewStateController viewStateController = ViewStateController.getInstance();
    private AddSaleViewController viewController;

    private final AddSale addSale;

    private final AddTransaction addTransaction;

    public AddSaleViewModel(
            AddSale addSale,
            AddTransaction addTransaction
    ) {
        this.addSale = addSale;
        this.addTransaction = addTransaction;
    }

    public void setViewController(AddSaleViewController viewController) {
        this.viewController = viewController;
    }

    public void onEvent(SaleEvent event) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                viewStateController.isLoading();
                if (event instanceof SaleEvent.GetClientListEvent) {
                    List<Client> clients = new ArrayList<>();
                    clients.add(new Client("Consumidor Final", "", "", 0.0));
                    ResponseHandler.handleResponse(new Response.Success<>(clients), viewStateController, c -> {
                        viewController.setClientList(clients);
                    });
                } else if (event instanceof SaleEvent.GetPaymentMethodListEvent) {
                    ResponseHandler.handleResponse(new Response.Success<>(PaymentMethod.values()), viewStateController, paymentMethods -> {
                        viewController.setPaymentMethodList(List.of(paymentMethods));
                    });
                } else if (event instanceof SaleEvent.AddSaleEvent) {
                    Sale sale = ((SaleEvent.AddSaleEvent) event).getSale();
                    Session session = ((SaleEvent.AddSaleEvent) event).getSession();
                    ResponseHandler.handleResponse(addSale.execute(sale), viewStateController, () -> {
                        Transaction transaction = new Transaction(session.getId(), Transaction.Concept.CASH_SALE, Transaction.Type.INCOME, sale.getCash());
                        ResponseHandler.handleResponse(addTransaction.execute(transaction), viewStateController, () -> {
                            viewController.dispose();
                        });
                    });
                }
                return null;
            }
        };
        worker.execute();
    }

}