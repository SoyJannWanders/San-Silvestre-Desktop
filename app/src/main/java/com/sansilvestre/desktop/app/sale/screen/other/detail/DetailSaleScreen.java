package com.sansilvestre.desktop.app.sale.screen.other.detail;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.util.formatter.Percentage;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.util.formatter.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DetailSaleScreen extends javax.swing.JPanel {

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Sale sale;

    public DetailSaleScreen(Sale sale) {
        this.sale = sale;
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblEnteredCash = new javax.swing.JLabel();
        lblEnteredTransfer = new javax.swing.JLabel();
        lblEnteredCodeQR = new javax.swing.JLabel();
        lblEnteredDebit = new javax.swing.JLabel();
        lblEnteredCredit = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblChange = new javax.swing.JLabel();
        lblEnteredChange = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblDiscount = new javax.swing.JLabel();
        lblDiscountRate = new javax.swing.JLabel();
        lblEnteredDiscount = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblTotal = new javax.swing.JLabel();
        lblEnteredTotal = new javax.swing.JLabel();
        lblClient = new javax.swing.JLabel();
        lblEnteredClient = new javax.swing.JLabel();
        lblDateTime = new javax.swing.JLabel();
        lblEnteredDateTime = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        btnDispose = new javax.swing.JButton();

        lblHeadline.setText("Detalles de la Venta");

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de Barras", "Producto", "Cantidad", "Precio U.", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItems.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblItems);
        if (tblItems.getColumnModel().getColumnCount() > 0) {
            tblItems.getColumnModel().getColumn(0).setMinWidth(128);
            tblItems.getColumnModel().getColumn(0).setPreferredWidth(128);
            tblItems.getColumnModel().getColumn(0).setMaxWidth(128);
            tblItems.getColumnModel().getColumn(2).setMinWidth(64);
            tblItems.getColumnModel().getColumn(2).setPreferredWidth(64);
            tblItems.getColumnModel().getColumn(2).setMaxWidth(64);
            tblItems.getColumnModel().getColumn(3).setMinWidth(96);
            tblItems.getColumnModel().getColumn(3).setPreferredWidth(96);
            tblItems.getColumnModel().getColumn(3).setMaxWidth(96);
            tblItems.getColumnModel().getColumn(4).setMinWidth(96);
            tblItems.getColumnModel().getColumn(4).setPreferredWidth(96);
            tblItems.getColumnModel().getColumn(4).setMaxWidth(96);
        }

        jLabel2.setText("Efectivo");

        jLabel3.setText("Transferencia");

        jLabel4.setText("Codigo QR");

        jLabel5.setText("Debito");

        jLabel6.setText("Credito");

        lblEnteredCash.setText("$ 0");

        lblEnteredTransfer.setText("$ 0");

        lblEnteredCodeQR.setText("$ 0");

        lblEnteredDebit.setText("$ 0");

        lblEnteredCredit.setText("$ 0");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblChange.setText("Vuelto");

        lblEnteredChange.setText("$ 0");

        lblDiscount.setText("Descuento");

        lblDiscountRate.setText("0%");

        lblEnteredDiscount.setText("$ 0");

        lblTotal.setText("Total");

        lblEnteredTotal.setText("$ 0");

        lblClient.setText("Cliente");

        lblEnteredClient.setText("-");

        lblDateTime.setText("Fecha y Hora");

        lblEnteredDateTime.setText("-");

        btnDispose.setText("Volver");
        btnDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisposeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeadline)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDispose))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEnteredClient)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEnteredDateTime))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblClient)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblDateTime))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblEnteredCredit))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblEnteredCodeQR))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblEnteredTransfer))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(90, 90, 90)
                                                .addComponent(lblEnteredCash))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblEnteredDebit)))
                                        .addGap(24, 24, 24)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblTotal)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblEnteredTotal))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblDiscount)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblDiscountRate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblEnteredDiscount))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblChange)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblEnteredChange))
                                            .addComponent(jSeparator2)
                                            .addComponent(jSeparator3)))
                                    .addComponent(jSeparator4)
                                    .addComponent(jSeparator5))))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClient)
                    .addComponent(lblDateTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnteredClient)
                    .addComponent(lblEnteredDateTime))
                .addGap(16, 16, 16)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(lblEnteredCash))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(lblEnteredTransfer))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(lblEnteredCodeQR))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(lblEnteredDebit))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(lblEnteredCredit)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChange)
                            .addComponent(lblEnteredChange))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiscount)
                            .addComponent(lblDiscountRate)
                            .addComponent(lblEnteredDiscount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(lblEnteredTotal))))
                .addGap(16, 16, 16)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnDispose)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        shortcut.configure(this);
        setItemList();
    }

    private void setItemList() {

        DefaultTableModel model = (DefaultTableModel) tblItems.getModel();
        model.setRowCount(0);

        for (Item item: sale.getItemList()) {

            model.addRow(new Object[] {
                    item.getBarcode(),
                    item.getName(),
                    item.getUnits(),
                    Currency.format(item.getPrice()),
                    Currency.format(item.getPrice() * item.getUnits())
            });

        }

    }

    private void btnDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisposeActionPerformed
        dispose();
    }//GEN-LAST:event_btnDisposeActionPerformed

    private void dispose() {
        NavigationController.getInstance().navigate(NavigationController.Route.LOCALE_SALE_SCREEN, new NavigationData(
                new Object[] { sale.getBranchId() }, new Class[] { Integer.class }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDispose;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblClient;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblDiscountRate;
    private javax.swing.JLabel lblEnteredCash;
    private javax.swing.JLabel lblEnteredChange;
    private javax.swing.JLabel lblEnteredClient;
    private javax.swing.JLabel lblEnteredCodeQR;
    private javax.swing.JLabel lblEnteredCredit;
    private javax.swing.JLabel lblEnteredDateTime;
    private javax.swing.JLabel lblEnteredDebit;
    private javax.swing.JLabel lblEnteredDiscount;
    private javax.swing.JLabel lblEnteredTotal;
    private javax.swing.JLabel lblEnteredTransfer;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblItems;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(lblHeadline, "headline.small");

            Styles.setStyleTo(lblClient, "label.small");

            lblEnteredClient.setText("Consumidor Final");

            Styles.setStyleTo(lblDateTime, "label.small");

            lblEnteredDateTime.setText(Date.formatDateTime(sale.getCreatedAt()));

            lblEnteredCash.setText(Currency.format(sale.getCash()));

            lblEnteredTransfer.setText(Currency.format(sale.getTransfer()));

            lblEnteredCodeQR.setText(Currency.format(sale.getQrCode()));

            lblEnteredDebit.setText(Currency.format(sale.getDebit()));

            lblEnteredCredit.setText(Currency.format(sale.getCredit()));

            Styles.setStyleTo(lblDiscount, "label.small");

            Styles.setStyleTo(lblDiscountRate, "label.small");

            Styles.setStyleTo(lblEnteredDiscount, "label.small");

            if (sale.getCash() != 0) {

                double percentage = Setting.getInstance().getPercentageDiscountCash() / 100;

                double totalWithDiscount = sale.getTotal() * (sale.getTotal() * percentage);

                double cash = sale.getCash();
                double transfer = sale.getTransfer();
                double qrCode = sale.getQrCode();
                double debit = sale.getDebit();
                double credit = sale.getCredit();

                if ((cash + transfer + qrCode + debit + credit) == totalWithDiscount || cash >= totalWithDiscount) {

                    if (cash >= totalWithDiscount)
                        lblEnteredChange.setText(Currency.format(sale.getCash() - totalWithDiscount));

                    lblEnteredDiscount.setText(Currency.format(sale.getTotal() - totalWithDiscount));
                    lblDiscountRate.setText(Percentage.format(percentage * 100));
                    lblEnteredTotal.setText(Currency.format(totalWithDiscount));

                }

            } else {

                lblEnteredTotal.setText(Currency.format(sale.getTotal()));

            }

            Styles.setStyleTo(lblTotal, "label.medium");

            Styles.setStyleTo(lblEnteredTotal, "label.medium");

            Styles.setStyleTo(btnDispose, "button.outline");

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

        }

    }

}