package com.sansilvestre.desktop.app.sale.screen.add;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.checkout.screen.CheckoutViewController;
import com.sansilvestre.desktop.app.client.domain.model.Client;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.util.formatter.Rounder;
import com.sansilvestre.desktop.app.sale.domain.model.PaymentMethod;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.sale.module.SaleModule;
import com.sansilvestre.desktop.app.sale.screen.SaleEvent;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.util.formatter.Percentage;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class AddSaleScreen extends javax.swing.JPanel implements AddSaleViewController {

    private final AddSaleViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final List<Item> items;

    private final Session session;

    private final CheckoutViewController viewController;

    private double totalCache = 0;
    private double total = 0;

    private double paid = 0;

    private boolean isAdded = false;

    public AddSaleScreen(List<Item> items, Session session, CheckoutViewController viewController) {
        viewModel = SaleModule.getInstance().provideAddSaleViewModel();
        this.items = items;
        this.session = session;
        this.viewController = viewController;
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblCash = new javax.swing.JLabel();
        lblEnteredCash = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPayoutMethod = new javax.swing.JLabel();
        cmbPayoutMethod = new javax.swing.JComboBox<>();
        txtAmount = new javax.swing.JTextField();
        lblAmount = new javax.swing.JLabel();
        lblClient = new javax.swing.JLabel();
        cmbClient = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblTransfer = new javax.swing.JLabel();
        lblEnteredTransfer = new javax.swing.JLabel();
        lblQR = new javax.swing.JLabel();
        lblEnteredQR = new javax.swing.JLabel();
        lblDebit = new javax.swing.JLabel();
        lblEnteredDebit = new javax.swing.JLabel();
        lblCredit = new javax.swing.JLabel();
        lblEnteredCredit = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        lblEnteredDiscount = new javax.swing.JLabel();
        btnAccept = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblDiscountRate = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblTotal = new javax.swing.JLabel();
        lblEnteredTotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblDetail = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblChange = new javax.swing.JLabel();
        lblEnteredChange = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(658, 453));

        lblHeadline.setText("Cobrar");
        lblHeadline.setPreferredSize(new java.awt.Dimension(320, 16));

        lblCash.setText("Efectivo");

        lblEnteredCash.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEnteredCash.setText("$ 0");
        lblEnteredCash.setPreferredSize(new java.awt.Dimension(128, 16));

        jPanel1.setPreferredSize(new java.awt.Dimension(320, 195));

        lblPayoutMethod.setText("Metodo de Pago");

        cmbPayoutMethod.setEditable(true);
        cmbPayoutMethod.setPreferredSize(new java.awt.Dimension(136, 22));

        txtAmount.setPreferredSize(new java.awt.Dimension(136, 22));

        lblAmount.setText("Monto");

        lblClient.setText("Cliente");

        cmbClient.setEditable(true);

        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblClient)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPayoutMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPayoutMethod))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAmount)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cmbClient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPayoutMethod)
                    .addComponent(lblAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPayoutMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnAdd)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jSeparator1.setPreferredSize(new java.awt.Dimension(320, 10));

        lblTransfer.setText("Transferencia");

        lblEnteredTransfer.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEnteredTransfer.setText("$ 0");
        lblEnteredTransfer.setPreferredSize(new java.awt.Dimension(128, 16));

        lblQR.setText("QR");

        lblEnteredQR.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEnteredQR.setText("$ 0");
        lblEnteredQR.setPreferredSize(new java.awt.Dimension(128, 16));

        lblDebit.setText("Debito");

        lblEnteredDebit.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEnteredDebit.setText("$ 0");
        lblEnteredDebit.setPreferredSize(new java.awt.Dimension(128, 16));

        lblCredit.setText("Credito");

        lblEnteredCredit.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEnteredCredit.setText("$ 0");
        lblEnteredCredit.setPreferredSize(new java.awt.Dimension(128, 16));

        lblDiscount.setText("Descuento");

        lblEnteredDiscount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEnteredDiscount.setText("$ 0");
        lblEnteredDiscount.setPreferredSize(new java.awt.Dimension(128, 16));

        btnAccept.setText("Aceptar");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.setContentAreaFilled(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblDiscountRate.setText("0%");

        jSeparator2.setPreferredSize(new java.awt.Dimension(320, 10));

        lblTotal.setText("Total");

        lblEnteredTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEnteredTotal.setText("$ 0");
        lblEnteredTotal.setPreferredSize(new java.awt.Dimension(128, 16));

        jLabel1.setText("Vuelva pronto, le estaremos esperando.");

        lblDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetail.setText("Datos de Pago");
        lblDetail.setPreferredSize(new java.awt.Dimension(256, 16));

        lblChange.setText("Vuelto");

        lblEnteredChange.setText("$ 0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblChange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEnteredChange)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnteredChange)
                    .addComponent(lblChange))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAccept))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCredit)
                                    .addComponent(lblDebit)
                                    .addComponent(lblQR)
                                    .addComponent(lblTransfer)
                                    .addComponent(lblCash))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEnteredCash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEnteredTransfer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEnteredQR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEnteredDebit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEnteredCredit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblTotal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEnteredTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblDiscount)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblDiscountRate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblEnteredDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblDetail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEnteredCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEnteredTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEnteredQR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEnteredDebit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEnteredCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCash)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTransfer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblQR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDebit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCredit)))
                        .addGap(16, 16, 16)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiscount)
                            .addComponent(lblEnteredDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiscountRate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(lblEnteredTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAccept)
                            .addComponent(btnCancel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new SaleEvent.GetClientListEvent());
        viewModel.onEvent(new SaleEvent.GetPaymentMethodListEvent());
        setItemList();
    }

    @Override
    public void setClientList(List<Client> clients) {
        clients.forEach(client -> {
            cmbClient.addItem(client);
        });
    }

    @Override
    public void setPaymentMethodList(List<PaymentMethod> paymentMethods) {
        paymentMethods.forEach(paymentMethod -> {
            cmbPayoutMethod.addItem(paymentMethod);
        });
    }

    private void setItemList() {

        for (Item item : items) {

            totalCache = totalCache + item.getPrice() * item.getUnits();

        }

        total = totalCache;

        txtAmount.setText(Currency.format(totalCache));

        lblEnteredTotal.setText(Currency.format(totalCache));

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addPaymentMethod();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        if (paid >= total) {
            addSale();
        } else {
            addPaymentMethod();
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void addPaymentMethod() {

        final PaymentMethod paymentMethod = (PaymentMethod) cmbPayoutMethod.getSelectedItem();
        final double amount = Currency.toDouble(txtAmount.getText());

        switch (paymentMethod) {
            case CASH -> {
                double cash = Currency.toDouble(lblEnteredCash.getText());
                lblEnteredCash.setText(Currency.format(amount + cash));
            }
            case TRANSFER -> {
                double transfer = Currency.toDouble(lblEnteredTransfer.getText());
                lblEnteredTransfer.setText(Currency.format(amount + transfer));
            }
            case QR_CODE -> {
                double qr = Currency.toDouble(lblEnteredQR.getText());
                lblEnteredQR.setText(Currency.format(amount + qr));
            }
            case DEBIT -> {
                double debit = Currency.toDouble(lblEnteredDebit.getText());
                lblEnteredDebit.setText(Currency.format(amount + debit));
            }
            case CREDIT -> {
                double credit = Currency.toDouble(lblEnteredCredit.getText());
                lblEnteredCredit.setText(Currency.format(amount + credit));
            }
        }

        if (amount != 0) {

            paid += amount;

            if (paid > total) {
                txtAmount.setText("$ 0");
            } else {
                txtAmount.setText(Currency.format(total - paid));
            }

        }

    }

    private void addSale() {
        viewModel.onEvent(new SaleEvent.AddSaleEvent(
                new Sale(
                        1,
                        items,
                        totalCache,
                        Currency.toDouble(lblEnteredCash.getText()),
                        Currency.toDouble(lblEnteredTransfer.getText()),
                        Currency.toDouble(lblEnteredQR.getText()),
                        Currency.toDouble(lblEnteredDebit.getText()),
                        Currency.toDouble(lblEnteredCredit.getText()),
                        session.getCheckoutId(),
                        Setting.getInstance().getBranchId()
        ), session));
        isAdded = true;
    }

    @Override
    public void dispose() {
        if (isAdded)
            viewController.reset();
        NavigationController.getInstance().navigate(NavigationController.Route.DISPOSE_SCREEN, new NavigationData(
                new Object[] { this }, new Class[] { JPanel.class }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<Client> cmbClient;
    private javax.swing.JComboBox<PaymentMethod> cmbPayoutMethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCash;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblClient;
    private javax.swing.JLabel lblCredit;
    private javax.swing.JLabel lblDebit;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblDiscountRate;
    private javax.swing.JLabel lblEnteredCash;
    private javax.swing.JLabel lblEnteredChange;
    private javax.swing.JLabel lblEnteredCredit;
    private javax.swing.JLabel lblEnteredDebit;
    private javax.swing.JLabel lblEnteredDiscount;
    private javax.swing.JLabel lblEnteredQR;
    private javax.swing.JLabel lblEnteredTotal;
    private javax.swing.JLabel lblEnteredTransfer;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblPayoutMethod;
    private javax.swing.JLabel lblQR;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTransfer;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(jPanel1, "container");

            Styles.setStyleTo(jPanel2, "container");

            Styles.setStyleTo(lblHeadline, "headline.small");

            Styles.setStyleTo(lblClient, "label.small");

            Styles.setStyleTo(lblPayoutMethod, "label.small");

            cmbPayoutMethod.setSelectedItem(PaymentMethod.DEBIT);

            Styles.setStyleTo(lblAmount, "label.small");

            Placeholder.setPlaceholderTo(txtAmount, "$ 0");

            Styles.setStyleTo(lblChange, "body.medium");

            Styles.setStyleTo(lblEnteredChange, "body.medium");

            Styles.setStyleTo(lblDetail, "label.large");

            Styles.setStyleTo(lblDiscount, "label.medium");

            Styles.setStyleTo(lblDiscountRate, "label.medium");

            Styles.setStyleTo(lblEnteredDiscount, "label.medium");

            Styles.setStyleTo(lblTotal, "label.large");

            Styles.setStyleTo(lblEnteredTotal, "label.large");

            Styles.setStyleTo(btnAdd, "button.outline");

            Styles.setStyleTo(btnCancel, "button.text");

        }

        private void initializeListeners() {

            cmbClient.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (shortcut.isAllowed(e))
                        e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

            });

            cmbPayoutMethod.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (shortcut.isAllowed(e))
                        e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

            });

            cmbPayoutMethod.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    PaymentMethod paymentMethod = (PaymentMethod) cmbPayoutMethod.getSelectedItem();
                    if (paymentMethod == PaymentMethod.CASH) {
                        double discount = 0;
                        if (paid == 0) {
                            double percentage = Setting.getInstance().getPercentageDiscountCash() / 100;
                            discount = totalCache * percentage;
                            total = totalCache - discount;
                            lblDiscountRate.setText(Percentage.format(percentage * 100));
                        }
                        double rest = total - paid;
                        double cash = Rounder.roundByCash(rest);
                        lblEnteredDiscount.setText(Currency.format(discount));
                        lblEnteredChange.setText(Currency.format(cash - rest));
                        txtAmount.setText(Currency.format(cash));
                    } else {
                        if (paid == 0) {
                            total = totalCache;
                            lblDiscountRate.setText("0%");
                            lblEnteredDiscount.setText("$ 0");
                        }
                        lblEnteredChange.setText("$ 0");
                        txtAmount.setText(Currency.format(total - paid));
                    }
                    lblEnteredTotal.setText(Currency.format(total));
                }
            });

            txtAmount.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    String in = txtAmount.getText();
                    char c = e.getKeyChar();
                    if (Character.isDigit(c) || c == ',' || c == '.') {
                        if (c == '.' || c == ',') {
                            e.setKeyChar(',');
                            if (in.isEmpty() || in.contains(","))
                                e.consume();
                        }
                        if (c == '0') {
                            if (in.equals("$ 0") || in.equals("0"))
                                e.consume();
                        }
                    } else {
                        e.consume();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    String in = txtAmount.getText();
                    double amount = Currency.toDouble(in);
                    if (amount > total)
                        txtAmount.setText(Currency.format(total));
                    else
                        txtAmount.setText(Currency.format(in));
                    lblEnteredChange.setText("$ 0");
                }

            });

            txtAmount.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseReleased(MouseEvent e) {
                    txtAmount.setText("");
                }

            });

        }

    }

    private class Shortcut {

        public void configure(JComponent component) {

            InputMap input = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

            final String DISPOSE = "dispose";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), DISPOSE);
            actionMap.put(DISPOSE, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            final String ACCEPT_PAYOUT = "addPaymentMethod";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), ACCEPT_PAYOUT);
            actionMap.put(ACCEPT_PAYOUT, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (paid >= total) {
                        addSale();
                    } else {
                        addPaymentMethod();
                    }
                }
            });

            final String CASH_PAYMENT_METHOD = "cashPaymentMethod";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), CASH_PAYMENT_METHOD);
            actionMap.put(CASH_PAYMENT_METHOD, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cmbPayoutMethod.setSelectedItem(PaymentMethod.CASH);
                }
            });

            final String TRANSFER_PAYMENT_METHOD = "transferPaymentMethod";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), TRANSFER_PAYMENT_METHOD);
            actionMap.put(TRANSFER_PAYMENT_METHOD, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cmbPayoutMethod.setSelectedItem(PaymentMethod.TRANSFER);
                }
            });

            final String QR_CODE_PAYMENT_METHOD = "qrCodePaymentMethod";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), QR_CODE_PAYMENT_METHOD);
            actionMap.put(QR_CODE_PAYMENT_METHOD, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cmbPayoutMethod.setSelectedItem(PaymentMethod.QR_CODE);
                }
            });

            final String DEBIT_PAYMENT_METHOD = "debitPaymentMethod";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), DEBIT_PAYMENT_METHOD);
            actionMap.put(DEBIT_PAYMENT_METHOD, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cmbPayoutMethod.setSelectedItem(PaymentMethod.DEBIT);
                }
            });

            final String CREDIT_PAYMENT_METHOD = "creditPaymentMethod";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), CREDIT_PAYMENT_METHOD);
            actionMap.put(CREDIT_PAYMENT_METHOD, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cmbPayoutMethod.setSelectedItem(PaymentMethod.CREDIT);
                }
            });

        }

        public boolean isAllowed(KeyEvent e) {
            return e.getKeyCode() != KeyEvent.VK_ESCAPE &&
                    e.getKeyCode() != KeyEvent.VK_F4 &&
                    e.getKeyCode() != KeyEvent.VK_F5 &&
                    e.getKeyCode() != KeyEvent.VK_F6 &&
                    e.getKeyCode() != KeyEvent.VK_F7 &&
                    e.getKeyCode() != KeyEvent.VK_F8 &&
                    e.getKeyCode() != KeyEvent.VK_F9;
        }

    }

}