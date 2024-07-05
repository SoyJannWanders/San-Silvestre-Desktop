package com.sansilvestre.desktop.app.home.screen;

import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.home.module.HomeModule;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.sale.domain.model.Sale;
import com.sansilvestre.desktop.app.util.formatter.Date;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class HomeScreen extends javax.swing.JPanel implements HomeViewController {

    private final HomeViewModel viewModel;

    private final Screen screen = new Screen();

    private List<Sale> sales;
    private Map<Integer, Branch> branches;

    private final CountDownLatch salesSynchronizer = new CountDownLatch(1);

    public HomeScreen() {
        viewModel = HomeModule.getInstance().provideHomeViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlProfit = new javax.swing.JPanel();
        lblProfit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        pnlProfit1 = new javax.swing.JPanel();
        lblProfit1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlProfit2 = new javax.swing.JPanel();
        lblProfit2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnUserScreen = new javax.swing.JButton();
        btnProductScreen = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(768, 640));

        jLabel1.setText("Bienvenido ¿Qué tal el día?");

        jLabel2.setText("Tenemos todo organizado para ti");

        pnlProfit.setPreferredSize(new java.awt.Dimension(231, 82));

        lblProfit.setText("$ 0");

        jLabel4.setText("Ganancias");

        javax.swing.GroupLayout pnlProfitLayout = new javax.swing.GroupLayout(pnlProfit);
        pnlProfit.setLayout(pnlProfitLayout);
        pnlProfitLayout.setHorizontalGroup(
            pnlProfitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfitLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlProfitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblProfit))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        pnlProfitLayout.setVerticalGroup(
            pnlProfitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfitLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProfit)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel3.setText("Ultimas Ventas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Monto", "Sucursal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(128);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(128);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(128);
            jTable1.getColumnModel().getColumn(2).setMinWidth(96);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(96);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(96);
        }

        jLabel7.setText("Ultimos Mensajes");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Motivo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        pnlProfit1.setPreferredSize(new java.awt.Dimension(232, 82));

        lblProfit1.setText("0");

        jLabel5.setText("Ventas");

        javax.swing.GroupLayout pnlProfit1Layout = new javax.swing.GroupLayout(pnlProfit1);
        pnlProfit1.setLayout(pnlProfit1Layout);
        pnlProfit1Layout.setHorizontalGroup(
            pnlProfit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfit1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlProfit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProfit1)
                    .addComponent(jLabel5))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        pnlProfit1Layout.setVerticalGroup(
            pnlProfit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfit1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProfit1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pnlProfit2.setPreferredSize(new java.awt.Dimension(231, 82));

        lblProfit2.setText("0");

        jLabel9.setText("Sucursales");

        javax.swing.GroupLayout pnlProfit2Layout = new javax.swing.GroupLayout(pnlProfit2);
        pnlProfit2.setLayout(pnlProfit2Layout);
        pnlProfit2Layout.setHorizontalGroup(
            pnlProfit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfit2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlProfit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lblProfit2))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        pnlProfit2Layout.setVerticalGroup(
            pnlProfit2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfit2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProfit2)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(475, 100));

        jLabel6.setText("Menu Rapido");

        btnUserScreen.setText("Administrar Usuarios");

        btnProductScreen.setText("Administrar Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUserScreen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProductScreen))
                    .addComponent(jLabel6))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserScreen)
                    .addComponent(btnProductScreen))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlProfit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlProfit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(pnlProfit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlProfit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlProfit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlProfit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        viewModel.setViewController(this);
        viewModel.onEvent(new HomeEvent.GetMapBranchEvent());
        viewModel.onEvent(new HomeEvent.GetSaleListEvent());
    }

    @Override
    public void setBranchMap(Map<Integer, Branch> branches) {

        this.branches = branches;

        salesSynchronizer.countDown();

    }

    @Override
    public void setSaleList(List<Sale> sales) {

        this.sales = sales;

        try {
            salesSynchronizer.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        double profits = 0;
        int pageLimit = 10;

        for (Sale sale: sales) {

            profits += sale.hasDiscount() ? sale.getTotalWithDiscount() : sale.getTotal();

            if (pageLimit > 0)
                model.addRow(new Object[] {
                        Date.formatDateTime(sale.getCreatedAt()),
                        Currency.format(sale.getTotal()),
                        branches.get(sale.getBranchId()).getName()
                });

            pageLimit--;

        }

        lblProfit2.setText(branches.size() - 1 + "");
        lblProfit1.setText(sales.size() + "");
        lblProfit.setText(Currency.format(profits));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProductScreen;
    private javax.swing.JButton btnUserScreen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblProfit;
    private javax.swing.JLabel lblProfit1;
    private javax.swing.JLabel lblProfit2;
    private javax.swing.JPanel pnlProfit;
    private javax.swing.JPanel pnlProfit1;
    private javax.swing.JPanel pnlProfit2;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(jPanel1, "container");

            Styles.setStyleTo(jLabel1, "headline.large");

            Styles.setStyleTo(pnlProfit, "container");

            Styles.setStyleTo(lblProfit, "title.small");

            Styles.setStyleTo(pnlProfit1, "container");

            Styles.setStyleTo(lblProfit1, "title.small");

            Styles.setStyleTo(pnlProfit2, "container");

            Styles.setStyleTo(lblProfit2, "title.small");

            Styles.setStyleTo(jLabel6, "label.medium");

            TableRenderer renderer = new TableRenderer();
            jTable1.getColumnModel().getColumn(0).setCellRenderer(renderer);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(renderer);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(renderer);

            Styles.setStyleTo(btnUserScreen, "button.group");
            Styles.setStyleTo(btnProductScreen, "button.group");

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