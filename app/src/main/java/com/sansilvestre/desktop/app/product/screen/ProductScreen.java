package com.sansilvestre.desktop.app.product.screen;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.util.exception.NoItemSelectedException;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.util.data.sync.AsyncTaskManager;
import com.sansilvestre.desktop.app.util.log.Console;
import com.sansilvestre.desktop.app.util.objects.Stock;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.dashboard.util.KeyBinds;
import com.sansilvestre.desktop.app.product.module.ProductModule;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ProductScreen extends javax.swing.JPanel implements ProductViewController {

    private final ProductViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private List<Product> products;

    private Map<Integer, Category> categories;
    private Map<Integer, Branch> branches;

    private final CountDownLatch screenSynchronizer = new CountDownLatch(2);
    private final CountDownLatch listenersSynchronizer = new CountDownLatch(1);

    private final JPopupMenu popupProductActions = new JPopupMenu();

    private final JMenuItem mniUpdateStock = new JMenuItem("Actualizar Stock");
    private final JMenuItem mniUpdatePrice = new JMenuItem("Actualizar Precio");
    private final JMenuItem mniUpdateProduct = new JMenuItem("Editar");
    private final JMenuItem mniDeleteProduct = new JMenuItem("Eliminar");

    public ProductScreen() {
        viewModel = ProductModule.getInstance().provideProductViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblBody = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cmbStock = new javax.swing.JComboBox<>();
        cmbCategory = new javax.swing.JComboBox<>();
        cmbBranch = new javax.swing.JComboBox<>();
        productTableScroll = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        detailsConteiner = new javax.swing.JPanel();
        lblProductName = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        lblProductStock = new javax.swing.JLabel();
        lblBarcode = new javax.swing.JLabel();
        lblProductBarcode = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        lblProductCategory = new javax.swing.JLabel();
        rightBillingSeparator = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        advancedOptionsButton = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        lblProductPrice = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(768, 640));

        lblHeadline.setText("Gestión de Productos");

        lblBody.setText("Controla y administra tu inventario de manera efectiva");

        txtSearch.setPreferredSize(new java.awt.Dimension(160, 22));

        cmbStock.setEditable(true);
        cmbStock.setPreferredSize(new java.awt.Dimension(96, 22));

        cmbCategory.setEditable(true);
        cmbCategory.setPreferredSize(new java.awt.Dimension(160, 22));

        cmbBranch.setEditable(true);
        cmbBranch.setPreferredSize(new java.awt.Dimension(160, 22));

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock", "Producto", "Codigo de Barras", "Precio C.", "Precio V.", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.getTableHeader().setReorderingAllowed(false);
        productTableScroll.setViewportView(tblProducts);
        if (tblProducts.getColumnModel().getColumnCount() > 0) {
            tblProducts.getColumnModel().getColumn(0).setMinWidth(64);
            tblProducts.getColumnModel().getColumn(0).setPreferredWidth(64);
            tblProducts.getColumnModel().getColumn(0).setMaxWidth(64);
            tblProducts.getColumnModel().getColumn(1).setMinWidth(128);
            tblProducts.getColumnModel().getColumn(1).setPreferredWidth(256);
            tblProducts.getColumnModel().getColumn(2).setMinWidth(128);
            tblProducts.getColumnModel().getColumn(2).setPreferredWidth(128);
            tblProducts.getColumnModel().getColumn(2).setMaxWidth(128);
            tblProducts.getColumnModel().getColumn(3).setMinWidth(96);
            tblProducts.getColumnModel().getColumn(3).setPreferredWidth(96);
            tblProducts.getColumnModel().getColumn(3).setMaxWidth(96);
            tblProducts.getColumnModel().getColumn(4).setMinWidth(96);
            tblProducts.getColumnModel().getColumn(4).setPreferredWidth(96);
            tblProducts.getColumnModel().getColumn(4).setMaxWidth(96);
            tblProducts.getColumnModel().getColumn(5).setMinWidth(128);
            tblProducts.getColumnModel().getColumn(5).setPreferredWidth(128);
            tblProducts.getColumnModel().getColumn(5).setMaxWidth(128);
        }

        detailsConteiner.setPreferredSize(new java.awt.Dimension(59, 128));

        lblProductName.setText("-");
        lblProductName.setPreferredSize(new java.awt.Dimension(520, 16));

        lblStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStock.setText("Stock");
        lblStock.setPreferredSize(new java.awt.Dimension(48, 16));

        lblProductStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductStock.setText("-");
        lblProductStock.setPreferredSize(new java.awt.Dimension(48, 16));

        lblBarcode.setText("Codigo de Barras");
        lblBarcode.setPreferredSize(new java.awt.Dimension(128, 16));

        lblProductBarcode.setText("-");
        lblProductBarcode.setPreferredSize(new java.awt.Dimension(128, 16));

        lblCategory.setText("Categoria");
        lblCategory.setPreferredSize(new java.awt.Dimension(128, 16));

        lblProductCategory.setText("-");
        lblProductCategory.setPreferredSize(new java.awt.Dimension(128, 16));

        rightBillingSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        rightBillingSeparator.setPreferredSize(new java.awt.Dimension(8, 96));

        btnUpdate.setText("Editar");
        btnUpdate.setPreferredSize(new java.awt.Dimension(96, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.setPreferredSize(new java.awt.Dimension(96, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        advancedOptionsButton.setText("Más");
        advancedOptionsButton.setContentAreaFilled(false);
        advancedOptionsButton.setPreferredSize(new java.awt.Dimension(96, 23));
        advancedOptionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedOptionsButtonActionPerformed(evt);
            }
        });

        lblPrice.setText("Precio");

        lblProductPrice.setText("-");

        javax.swing.GroupLayout detailsConteinerLayout = new javax.swing.GroupLayout(detailsConteiner);
        detailsConteiner.setLayout(detailsConteinerLayout);
        detailsConteinerLayout.setHorizontalGroup(
            detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailsConteinerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailsConteinerLayout.createSequentialGroup()
                        .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProductBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductPrice)
                            .addComponent(lblPrice)))
                    .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(rightBillingSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advancedOptionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        detailsConteinerLayout.setVerticalGroup(
            detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsConteinerLayout.createSequentialGroup()
                .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailsConteinerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(detailsConteinerLayout.createSequentialGroup()
                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(advancedOptionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rightBillingSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(detailsConteinerLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(detailsConteinerLayout.createSequentialGroup()
                                .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPrice))
                                .addGap(6, 6, 6)
                                .addGroup(detailsConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProductPrice)))
                            .addGroup(detailsConteinerLayout.createSequentialGroup()
                                .addComponent(lblBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lblProductBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );

        btnAdd.setText("Añadir nuevo producto");
        btnAdd.setContentAreaFilled(false);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel4.setText("¿No encuentras el producto que buscas?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBody)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(0, 0, 0)
                                .addComponent(btnAdd))
                            .addComponent(detailsConteiner, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                            .addComponent(productTableScroll, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblHeadline, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline)
                .addGap(4, 4, 4)
                .addComponent(lblBody)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBranch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(productTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailsConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        shortcut.configure(this);
        viewModel.setViewController(this);
        viewModel.getSyncInstance().start();
        viewModel.onEvent(new ProductEvent.GetCategoryMapEvent());
        viewModel.onEvent(new ProductEvent.GetBranchMapEvent());
        viewModel.onEvent(new ProductEvent.GetProductListEvent());
        viewModel.onEvent(new ProductEvent.InitializeListenersEvent());
        this.addHierarchyListener(e -> {
            if ((e.getChangeFlags() & HierarchyEvent.PARENT_CHANGED) != 0) {
                if (getParent() == null) {
                    viewModel.getSyncInstance().stop();
                }
            }
        });
    }

    @Override
    public void initializeListeners() {
        try {
            listenersSynchronizer.await();
        } catch (InterruptedException e) {
            Console.warn(Console.WarnCode.W001, "ERROR: Listeners Synchronizer");
        }
        screen.initializeListeners();
    }

    @Override
    public void setCategoryMap(Map<Integer, Category> categories) {
        this.categories = categories;
        categories.forEach((id, category) -> cmbCategory.addItem(category));
        screenSynchronizer.countDown();
    }

    @Override
    public void setBranchMap(Map<Integer, Branch> branches) {
        this.branches = branches;
        branches.forEach((id, branch) -> cmbBranch.addItem(branch));
        screenSynchronizer.countDown();
    }

    @Override
    public void setProductList(List<Product> products) {

        try {
            screenSynchronizer.await();
        } catch (InterruptedException e) {
            Console.warn(Console.WarnCode.W001, "ERROR: Screen Synchronizer");
        }


        this.products = products;

        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        model.setRowCount(0);

        boolean isFirst = true;

        for (Product product: products) {

            double spentPerUnit = product.getSpent() / product.getUnits();
            double totalTaxesPercentage = 40 + product.getTaxes();
            double priceWithTaxes = spentPerUnit * (1 + (totalTaxesPercentage / 100));

            Category category = categories.get(product.getCategoryId());

            model.addRow(new Object[] {
                    product.getStock(),
                    product.getName(),
                    product.getBarcode(),
                    Currency.format(spentPerUnit),
                    Currency.format(priceWithTaxes),
                    category.getName()
            });

            if (isFirst) {
                tblProducts.setRowSelectionInterval(0, 0);
                setProduct();
            }

            isFirst = false;

        }

        listenersSynchronizer.countDown();

    }

    private void setProduct() {

        int row = tblProducts.getSelectedRow();
        if (row > -1) {

            Product product = products.get(row);

            double spentPerUnit = product.getSpent() / product.getUnits();
            double totalTaxesPercentage = Setting.getInstance().getPercentageProfit() + categories.get(product.getCategoryId()).getIncrease() + product.getTaxes();
            double priceWithTaxes = spentPerUnit * (1 + (totalTaxesPercentage / 100));

            Category category = categories.get(product.getCategoryId());

            lblProductBarcode.setText(product.getBarcode());
            lblProductName.setText(product.getName());
            lblProductCategory.setText(category.getName());
            lblProductStock.setText(String.valueOf(product.getStock()));
            lblProductPrice.setText(Currency.format(priceWithTaxes));
        }

    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        AsyncTaskManager.log();
        KeyBinds.getInstance().restartKeyBindsService();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void advancedOptionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedOptionsButtonActionPerformed
        KeyBinds.getInstance().restartKeyBindsService();
    }//GEN-LAST:event_advancedOptionsButtonActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void add() {
        NavigationController.getInstance().navigate(NavigationController.Route.ADD_PRODUCT_SCREEN, new NavigationData(
                new Object[] { categories }, new Class[] { Map.class }
        ));
    }

    private void update() {
        try {
            int row = tblProducts.getSelectedRow();
            if (row > -1) {
                Product product = products.get(row);
                NavigationController.getInstance().navigate(NavigationController.Route.UPDATE_PRODUCT_SCREEN, new NavigationData(
                        new Object[] { categories, product }, new Class[] { Map.class, Product.class }
                ));
            } else {
                throw new NoItemSelectedException();
            }
        } catch (NoItemSelectedException e) {
            ViewStateController.getInstance().isFailure(e);
        }
    }

    private void delete() {
        try {
            int row = tblProducts.getSelectedRow();
            if (row > -1) {
                Runnable task = () -> {
                    Product product = products.get(row);
                    viewModel.onEvent(new ProductEvent.DeleteProductByBarcodeEvent(product.getBarcode()));
                };
                NavigationController.getInstance().navigate(NavigationController.Route.DELETE_SCREEN, new NavigationData(
                        new Object[] { task }, new Class[] { Runnable.class }
                ));
            } else {
                throw new NoItemSelectedException();
            }
        } catch (NoItemSelectedException e) {
            ViewStateController.getInstance().isFailure(e);
        }
    }

    @Override
    public void refresh() {
        viewModel.onEvent(new ProductEvent.GetProductListEvent());
        txtSearch.setText("");
        cmbStock.setSelectedIndex(0);
        cmbCategory.setSelectedIndex(0);
        cmbBranch.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton advancedOptionsButton;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Branch> cmbBranch;
    private javax.swing.JComboBox<Category> cmbCategory;
    private javax.swing.JComboBox<Stock> cmbStock;
    private javax.swing.JPanel detailsConteiner;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProductBarcode;
    private javax.swing.JLabel lblProductCategory;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblProductPrice;
    private javax.swing.JLabel lblProductStock;
    private javax.swing.JLabel lblStock;
    private javax.swing.JScrollPane productTableScroll;
    private javax.swing.JSeparator rightBillingSeparator;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(detailsConteiner, "container");

            Styles.setStyleTo(lblHeadline, "headline.large");

            Styles.setStyleTo(lblBody, "body.small");

            Styles.setStyleTo(txtSearch, "field.plain");
            Placeholder.setPlaceholderTo(txtSearch, "Buscar...");

            Styles.setStyleTo(cmbStock, "combo.box.variant");

            Styles.setStyleTo(cmbCategory, "combo.box.variant");

            Styles.setStyleTo(cmbBranch, "combo.box.variant");

            popupProductActions.add(mniUpdateStock);
            popupProductActions.add(mniUpdatePrice);
            popupProductActions.add(new JSeparator());
            popupProductActions.add(mniUpdateProduct);
            popupProductActions.add(mniDeleteProduct);

            mniUpdateProduct.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
            mniDeleteProduct.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

            List.of(Stock.values()).forEach(stock -> cmbStock.addItem(stock));

            TableRenderer renderer = new TableRenderer();
            tblProducts.getColumnModel().getColumn(0).setCellRenderer(renderer);
            tblProducts.getColumnModel().getColumn(1).setCellRenderer(renderer);
            tblProducts.getColumnModel().getColumn(2).setCellRenderer(renderer);
            tblProducts.getColumnModel().getColumn(3).setCellRenderer(renderer);
            tblProducts.getColumnModel().getColumn(4).setCellRenderer(renderer);
            tblProducts.getColumnModel().getColumn(5).setCellRenderer(renderer);

            Styles.setStyleTo(lblProductName, "title.small");

            Styles.setStyleTo(lblStock, "body.small");

            Styles.setStyleTo(lblProductStock, "label.medium");

            Styles.setStyleTo(lblBarcode, "body.small");

            Styles.setStyleTo(lblProductBarcode, "label.medium");

            Styles.setStyleTo(lblCategory, "body.small");

            Styles.setStyleTo(lblProductCategory, "label.medium");

            Styles.setStyleTo(lblPrice, "body.small");

            Styles.setStyleTo(lblProductPrice, "label.medium");

            Styles.setStyleTo(btnAdd, "button.text");

            Styles.setStyleTo(btnUpdate, "button.outline");

            Styles.setStyleTo(btnDelete, "button.outline.danger");

            Styles.setStyleTo(advancedOptionsButton, "button.text");

        }

        public void initializeListeners() {

            mniUpdateStock.addActionListener(e -> {

            });

            mniUpdatePrice.addActionListener(e -> {

            });

            mniUpdateProduct.addActionListener(e -> update());

            mniDeleteProduct.addActionListener(e -> delete());

            cmbStock.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (shortcut.isNotConfigured(e))
                        e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

            });

            cmbStock.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    /*Role role = (Role) cmbRole.getSelectedItem();
                    viewModel.onEvent(new UserEvent.GetUserListByRoleEvent(role));*/
                }
            });

            cmbCategory.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (shortcut.isNotConfigured(e))
                        e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

            });

            cmbCategory.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Category category = (Category) cmbCategory.getSelectedItem();
                    viewModel.onEvent(new ProductEvent.GetProductListByCategoryIDEvent(category.getId()));
                }
            });

            cmbBranch.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (shortcut.isNotConfigured(e))
                        e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

            });

            cmbBranch.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Branch branch = (Branch) cmbBranch.getSelectedItem();
                    viewModel.onEvent(new ProductEvent.GetProductListByBranchIDEvent(branch.getId()));
                }
            });

            tblProducts.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    setProduct();
                }
            });

            tblProducts.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        int row = tblProducts.getSelectedRow();
                        if (row != -1)
                            popupProductActions.show(tblProducts, e.getX(), e.getY());
                    }
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

            final String ADD = "add";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK), ADD);
            actionMap.put(ADD, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    add();
                }
            });

            final String UPDATE = "update";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK), UPDATE);
            actionMap.put(UPDATE, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    update();
                }
            });

            final String DELETE = "delete";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK), DELETE);
            actionMap.put(DELETE, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    delete();
                }
            });

            final String REFRESH = "refresh";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK), REFRESH);
            actionMap.put(REFRESH, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    refresh();
                }
            });

        }

        public boolean isNotConfigured(KeyEvent e) {
            return e.getKeyCode() != KeyEvent.VK_CONTROL &&
                    e.getKeyCode() != KeyEvent.VK_S &&
                    e.getKeyCode() != KeyEvent.VK_A &&
                    e.getKeyCode() != KeyEvent.VK_E &&
                    e.getKeyCode() != KeyEvent.VK_D &&
                    e.getKeyCode() != KeyEvent.VK_R;
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

            if (column == 0 || column == 2 || column == 5) {
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