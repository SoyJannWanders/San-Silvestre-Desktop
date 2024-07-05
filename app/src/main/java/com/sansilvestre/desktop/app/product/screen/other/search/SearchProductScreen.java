package com.sansilvestre.desktop.app.product.screen.other.search;

import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.module.ProductModule;
import com.sansilvestre.desktop.app.product.screen.ProductEvent;
import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.util.formatter.Rounder;
import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class SearchProductScreen extends javax.swing.JPanel implements SearchProductViewController {

    private final SearchProductViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    public SearchProductScreen() {
        viewModel = ProductModule.getInstance().provideSearchProductViewModel();
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
        tblProducts = new javax.swing.JTable();

        lblHeadline.setText("¿Qué andas buscando?");

        lblBody.setText("Encuentra rápidamente lo que necesitas en tu inventario");

        txtSearch.setPreferredSize(new java.awt.Dimension(160, 22));

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Stock", "Producto", "Codigo de Barras", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblProducts);
        if (tblProducts.getColumnModel().getColumnCount() > 0) {
            tblProducts.getColumnModel().getColumn(0).setMinWidth(64);
            tblProducts.getColumnModel().getColumn(0).setPreferredWidth(64);
            tblProducts.getColumnModel().getColumn(0).setMaxWidth(64);
            tblProducts.getColumnModel().getColumn(2).setMinWidth(128);
            tblProducts.getColumnModel().getColumn(2).setPreferredWidth(128);
            tblProducts.getColumnModel().getColumn(2).setMaxWidth(128);
            tblProducts.getColumnModel().getColumn(3).setMinWidth(96);
            tblProducts.getColumnModel().getColumn(3).setPreferredWidth(96);
            tblProducts.getColumnModel().getColumn(3).setMaxWidth(96);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBody)
                    .addComponent(lblHeadline))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBody)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new ProductEvent.GetProductListEvent());
    }

    @Override
    public void setProductList(List<Product> products) {

        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        model.setRowCount(0);

        for (Product product: products) {

            double spentPerUnit = product.getSpent() / product.getUnits();
            double totalPercentageTax = Setting.getInstance().getPercentageProfit() + product.getTaxes();
            double priceWithTaxes = spentPerUnit * (1 + (totalPercentageTax / 100));

            model.addRow(new Object[] {
                    product.getStock(),
                    product.getName(),
                    product.getBarcode(),
                    Currency.format(Rounder.round(priceWithTaxes))
            });

        }

    }

    private void dispose() {
        NavigationController.getInstance().navigate(NavigationController.Route.DISPOSE_SCREEN, new NavigationData(
                new Object[] { this }, new Class[] { JPanel.class }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(lblHeadline, "headline.small");

            Styles.setStyleTo(txtSearch, "field.plain");
            Placeholder.setPlaceholderTo(txtSearch, "Buscar...");

            TableRenderer renderer = new TableRenderer();
            tblProducts.getColumnModel().getColumn(0).setCellRenderer(renderer);
            tblProducts.getColumnModel().getColumn(1).setCellRenderer(renderer);
            tblProducts.getColumnModel().getColumn(2).setCellRenderer(renderer);
            tblProducts.getColumnModel().getColumn(3).setCellRenderer(renderer);

        }

        public void initializeListeners() {

            txtSearch.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && !Character.isDigit(c))
                        e.consume();
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    String search = txtSearch.getText();
                    if (search.isEmpty())
                        viewModel.onEvent(new ProductEvent.GetProductListEvent());
                    else
                        viewModel.onEvent(new ProductEvent.GetProductListBySearchEvent(search));
                }

            });

        }

    }

    private class Shortcut {

        public void configure(JComponent component) {

            InputMap input = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

            final String SEARCH = "search";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), SEARCH);
            actionMap.put(SEARCH, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtSearch.requestFocus();
                }
            });

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

            if (column == 3) {
                setHorizontalAlignment(SwingConstants.RIGHT);
            }

            return component;

        }
    }

}