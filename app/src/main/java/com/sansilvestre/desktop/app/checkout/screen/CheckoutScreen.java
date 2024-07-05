package com.sansilvestre.desktop.app.checkout.screen;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.checkout.module.CheckoutModule;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.util.formatter.SalePoint;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.util.ui.resource.AppStrings;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutScreen extends javax.swing.JPanel implements CheckoutViewController {

    private final CheckoutViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcuts shortcuts = new Shortcuts();

    private final Map<String, Item> itemCache = new HashMap<>();
    private final List<Item> items = new ArrayList<>();

    private Session session;

    private final JPopupMenu popupItemActions = new JPopupMenu();

    private final JMenuItem mniDeleteProduct = new JMenuItem("Eliminar Item");
    
    public CheckoutScreen() {
        viewModel = CheckoutModule.getInstance().provideCheckoutViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblBody = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        removeItem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblProductQuantity = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCharge = new javax.swing.JButton();
        btnDiscard = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblTotal = new javax.swing.JLabel();
        lblTotalTransaction = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblCheckout = new javax.swing.JLabel();
        lblCheckoutId = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        window = new javax.swing.JLabel();
        spnQuantity = new javax.swing.JSpinner();

        setPreferredSize(new java.awt.Dimension(768, 640));

        lblHeadline.setText("San Silvestre Full");

        lblBody.setText("¿Qué es lo que necesitas? Tenemos todo aquí");

        txtSearch.setPreferredSize(new java.awt.Dimension(160, 22));

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
            tblItems.getColumnModel().getColumn(0).setPreferredWidth(128);
            tblItems.getColumnModel().getColumn(2).setPreferredWidth(64);
            tblItems.getColumnModel().getColumn(3).setPreferredWidth(96);
            tblItems.getColumnModel().getColumn(4).setPreferredWidth(96);
        }

        removeItem.setText("Quitar");
        removeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(532, 102));

        lblName.setText("Producto");
        lblName.setPreferredSize(new java.awt.Dimension(360, 16));

        lblProductName.setText("-");
        lblProductName.setPreferredSize(new java.awt.Dimension(360, 16));

        lblQuantity.setText("Cantidad");

        lblProductQuantity.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductQuantity))
                .addGap(24, 24, 24))
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(160, 100));

        btnCharge.setText("Cobrar");
        btnCharge.setPreferredSize(new java.awt.Dimension(112, 23));
        btnCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChargeActionPerformed(evt);
            }
        });

        btnDiscard.setText("Descartar");
        btnDiscard.setPreferredSize(new java.awt.Dimension(112, 23));
        btnDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscardActionPerformed(evt);
            }
        });

        lblTotal.setText("Total");

        lblTotalTransaction.setText("$ 0");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Detalles");
        jLabel9.setPreferredSize(new java.awt.Dimension(112, 16));

        lblCheckout.setText("Caja");

        lblCheckoutId.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCheckout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCheckoutId))
                    .addComponent(lblTotalTransaction, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDiscard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCharge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCheckout)
                    .addComponent(lblCheckoutId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalTransaction)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCharge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDiscard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(0, 48));

        window.setText("Ventana #1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(window)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(window)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        spnQuantity.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBody)
                            .addComponent(lblHeadline))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBody)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeItem)
                    .addComponent(spnQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcuts.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new CheckoutEvent.GetLastActiveSessionEvent());
    }

    @Override
    public void setSession(Session session) {
        lblCheckoutId.setText(SalePoint.format(session.getCheckoutId()));
        this.session = session;
    }

    @Override
    public void setItem(Item item) {

        if (item.getStock() == 0) {
            return;
        }

        Item response = itemCache.get(item.getBarcode());

        if (response != null) {
            response.setUnits(response.getUnits() + 1);
        } else {
            spnQuantity.setEnabled(true);
            itemCache.put(item.getBarcode(), item);
            items.add(item);
        }

        setItemList();

        int lastRow = getLastRow();
        if (lastRow != getSelectedRow()) {
            tblItems.setRowSelectionInterval(lastRow, lastRow);
        }

    }

    private void removeItem() {

        int selectedRow = getSelectedRow();

        if (selectedRow != -1) {

            Item item = items.get(selectedRow);
            itemCache.remove(item.getBarcode());
            items.remove(selectedRow);

            if (!items.isEmpty()) {

                int newRow = items.size() - 1;
                tblItems.setRowSelectionInterval(newRow, newRow);

                setItemList();

            } else {

                reset();

            }

        }

    }

    private void setItemList() {

        int rowSelected = getSelectedRow();

        DefaultTableModel model = (DefaultTableModel) tblItems.getModel();
        model.setRowCount(0);

        double total = 0;

        for (Item item: items) {

            total += item.getPrice() * item.getUnits();

            model.addRow(new Object[] {
                    item.getBarcode(),
                    item.getName(),
                    item.getUnits(),
                    Currency.format(item.getPrice()),
                    Currency.format(item.getPrice() * item.getUnits())
            });

        }

        if (rowSelected != -1)
            tblItems.setRowSelectionInterval(rowSelected, rowSelected);

        lblTotalTransaction.setText(Currency.format(total));

    }

    private void removeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemActionPerformed
        removeItem();
    }//GEN-LAST:event_removeItemActionPerformed

    private void btnChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChargeActionPerformed
        addSale();
    }//GEN-LAST:event_btnChargeActionPerformed

    private void btnDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscardActionPerformed
        reset();
    }//GEN-LAST:event_btnDiscardActionPerformed

    private void addSale() {
        if (!items.isEmpty()) {
            NavigationController.getInstance().navigate(NavigationController.Route.ADD_SALE_SCREEN, new NavigationData(
                    new Object[] { items, session, this }, new Class[] { List.class, Session.class, CheckoutViewController.class }
            ));
        }
    }

    @Override
    public void reset() {
        screen.reset();
    }

    private int getSelectedRow() {
        return tblItems.getSelectedRow();
    }

    private int getLastRow() {
        return tblItems.getRowCount() - 1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCharge;
    private javax.swing.JButton btnDiscard;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblCheckout;
    private javax.swing.JLabel lblCheckoutId;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblProductQuantity;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalTransaction;
    private javax.swing.JButton removeItem;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tblItems;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel window;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(jPanel1, "container");
            Styles.setStyleTo(jPanel2, "container");
            Styles.setStyleTo(jPanel3, "container");

            Styles.setStyleTo(lblHeadline, "headline.large");

            Styles.setStyleTo(lblBody, "body.small");
            lblBody.setText(AppStrings.get(AppStrings.Screen.CHECKOUT, "label.body"));

            Placeholder.setPlaceholderTo(txtSearch, AppStrings.get(AppStrings.Screen.CHECKOUT, "input.search.placeholder"));

            spnQuantity.setValue(1);

            removeItem.setText(AppStrings.get(AppStrings.Screen.CHECKOUT, "button.delete"));

            TableRenderer renderer = new TableRenderer();
            tblItems.getColumnModel().getColumn(0).setCellRenderer(renderer);
            tblItems.getColumnModel().getColumn(1).setCellRenderer(renderer);
            tblItems.getColumnModel().getColumn(2).setCellRenderer(renderer);
            tblItems.getColumnModel().getColumn(3).setCellRenderer(renderer);
            tblItems.getColumnModel().getColumn(4).setCellRenderer(renderer);

            popupItemActions.add(mniDeleteProduct);

            mniDeleteProduct.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));

            Styles.setStyleTo(window, "label.medium");

            Styles.setStyleTo(lblTotal, "label.small");

            Styles.setStyleTo(lblTotalTransaction, "label.large");

            Styles.setStyleTo(lblProductName, "headline.medium");
            lblName.setText(AppStrings.get(AppStrings.Screen.CHECKOUT, "label.name"));

            Styles.setStyleTo(lblProductQuantity, "headline.medium");
            lblQuantity.setText(AppStrings.get(AppStrings.Screen.CHECKOUT, "label.amount"));

            Styles.setStyleTo(removeItem, "button.outline");

            Styles.setStyleTo(btnCharge, "button.outline");
            Styles.setStyleTo(btnDiscard, "button.outline.danger");

        }

        private void initializeListeners() {

            mniDeleteProduct.addActionListener(e -> removeItem());

            txtSearch.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        viewModel.onEvent(new CheckoutEvent.GetProductByBarcodeEvent(txtSearch.getText()));
                        txtSearch.setText("");
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && !Character.isDigit(c))
                        e.consume();
                }

            });

            ((JSpinner.DefaultEditor) spnQuantity.getEditor()).getTextField().addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c))
                        e.consume();
                }

            });

            spnQuantity.addChangeListener(e -> {
                int unit = (int) spnQuantity.getValue();
                if (unit < 1)
                    spnQuantity.setValue(1);
                int row = getSelectedRow();
                if (row != -1) {
                    Item item = items.get(row);
                    if (unit > item.getStock()) {
                        spnQuantity.setValue(item.getStock());
                        unit = (int) spnQuantity.getValue();
                    }
                    item.setUnits(unit);
                    setItemList();
                }
            });

            tblItems.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int row = tblItems.getSelectedRow();
                    if (row != -1) {
                        Item item = items.get(row);
                        spnQuantity.setValue(item.getUnits());
                        lblProductName.setText(item.getName());
                        lblProductQuantity.setText(item.getUnits() + "");
                    }
                }
            });

            tblItems.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        int row = tblItems.getSelectedRow();
                        if (row != -1)
                            popupItemActions.show(tblItems, e.getX(), e.getY());
                    }
                }

            });

        }

        private void reset() {

            itemCache.clear();
            items.clear();

            DefaultTableModel model = (DefaultTableModel) tblItems.getModel();
            model.setRowCount(0);

            spnQuantity.setEnabled(false);
            spnQuantity.setValue(1);

            lblProductName.setText("-");
            lblProductQuantity.setText("-");
            lblTotalTransaction.setText("$ 0");

        }

    }

    private class Shortcuts {

        public void configure(JComponent component) {

            InputMap input = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

            final String SEARCH_ITEM = "searchItem";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), SEARCH_ITEM);
            actionMap.put(SEARCH_ITEM, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    NavigationController.getInstance().navigate(NavigationController.Route.SEARCH_PRODUCT_SCREEN, null);
                }
            });

            final String FINISH_SALE = "finishSale";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), FINISH_SALE);
            actionMap.put(FINISH_SALE, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addSale();
                }
            });

            final String CANCEL_SALE = "cancelSale";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), CANCEL_SALE);
            actionMap.put(CANCEL_SALE, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    reset();
                }
            });

            final String INCREASE_QUANTITY = "increaseQuantity";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), INCREASE_QUANTITY);
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), INCREASE_QUANTITY);
            actionMap.put(INCREASE_QUANTITY, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int qty = (Integer) spnQuantity.getValue();
                    if (getSelectedRow() != -1) {
                        qty++;
                    }
                    spnQuantity.setValue(qty);
                }
            });

            final String DECREASE_QUANTITY = "decreaseQuantity";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), DECREASE_QUANTITY);
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), DECREASE_QUANTITY);
            actionMap.put(DECREASE_QUANTITY, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int qty = (Integer) spnQuantity.getValue();
                    if (getSelectedRow() != -1) {
                        qty--;
                    }
                    spnQuantity.setValue(qty);
                }
            });

            final String DELETE_ITEM = "deleteItem";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), DELETE_ITEM);
            actionMap.put(DELETE_ITEM, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeItem();
                }
            });

        }

    }

    private class Form {

        public void isValid() {

            try {



            } catch (Exception e) {



            }

        }

        private void isValidSearch() {

        }

        private boolean isBlank(String input) {
            return input == null || input.trim().isEmpty();
        }

    }

    private static class TableRenderer extends DefaultTableCellRenderer {

        private final DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        public TableRenderer() {
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (column == 0 || column == 2) {
                return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }

            if (column == 1) {
                setHorizontalAlignment(SwingConstants.LEFT);
            }

            if (column == 3 || column == 4) {
                setHorizontalAlignment(SwingConstants.RIGHT);
            }

            return component;

        }
    }

}