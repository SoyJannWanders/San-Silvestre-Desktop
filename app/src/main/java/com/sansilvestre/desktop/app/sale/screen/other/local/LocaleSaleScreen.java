package com.sansilvestre.desktop.app.sale.screen.other.local;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.checkout.domain.model.Item;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.sale.module.SaleModule;
import com.sansilvestre.desktop.app.sale.screen.SaleEvent;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.util.formatter.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public class LocaleSaleScreen extends javax.swing.JPanel implements LocaleSaleViewController {

    private final LocaleSaleViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private List<Sale> sales;

    private final int branchId;

    public LocaleSaleScreen(int branchId) {
        viewModel = SaleModule.getInstance().provideLocaleSaleViewModel();
        this.branchId = branchId;
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        lblBody = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();

        lblHeadline.setText("Registro de Ventas");

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Monto", "Fecha y Hora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSales.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSales);
        if (tblSales.getColumnModel().getColumnCount() > 0) {
            tblSales.getColumnModel().getColumn(0).setMinWidth(64);
            tblSales.getColumnModel().getColumn(0).setPreferredWidth(64);
            tblSales.getColumnModel().getColumn(0).setMaxWidth(64);
            tblSales.getColumnModel().getColumn(1).setMinWidth(96);
            tblSales.getColumnModel().getColumn(1).setPreferredWidth(96);
            tblSales.getColumnModel().getColumn(2).setMinWidth(128);
            tblSales.getColumnModel().getColumn(2).setPreferredWidth(128);
        }

        lblBody.setText("Aquí encontraras todas las ventas de hoy.");

        btnView.setText("Ver Detalles");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBody)
                    .addComponent(lblHeadline)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnView)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnView)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        shortcut.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new SaleEvent.GetSaleListByBranchIDEvent(branchId));
    }

    @Override
    public void setSaleList(List<Sale> sales) {

        this.sales = sales;

        DefaultTableModel model = (DefaultTableModel) tblSales.getModel();
        model.setRowCount(0);

        for (Sale sale: sales) {

            model.addRow(new Object[] {
                    sale.getId(),
                    sale.getTotal(),
                    Date.formatDateTime(sale.getCreatedAt())
            });

        }

    }

    @Override
    public void setItemList(List<Item> items) {
        Sale sale = sales.get(tblSales.getSelectedRow());
        sale.setItemList(items);
        NavigationController.getInstance().navigate(NavigationController.Route.DETAIL_SALE_SCREEN, new NavigationData(
                new Object[] { sale }, new Class[] { Sale.class }
        ));
    }

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int row = tblSales.getSelectedRow();
        if (row != -1)
            viewModel.onEvent(new SaleEvent.GetSaleItemListBySaleIDEvent(sales.get(row).getId()));
    }//GEN-LAST:event_btnViewActionPerformed

    private void dispose() {
        NavigationController.getInstance().navigate(NavigationController.Route.DISPOSE_SCREEN, new NavigationData(
                new Object[] { this }, new Class[] { JPanel.class }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JTable tblSales;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(lblHeadline, "headline.small");

            TableRenderer renderer = new TableRenderer();
            tblSales.getColumnModel().getColumn(0).setCellRenderer(renderer);
            tblSales.getColumnModel().getColumn(1).setCellRenderer(renderer);
            tblSales.getColumnModel().getColumn(2).setCellRenderer(renderer);

            Styles.setStyleTo(btnView, "button.outline");

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
                setHorizontalAlignment(SwingConstants.RIGHT);
            }

            return component;

        }
    }

}