package com.sansilvestre.desktop.app.branch.screen;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.module.BranchModule;
import com.sansilvestre.desktop.app.util.exception.NoItemSelectedException;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class BranchScreen extends javax.swing.JPanel implements BranchViewController {

    private final BranchViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private List<Branch> branches;

    private final JPopupMenu popupBranchAction = new JPopupMenu();

    private final JMenuItem mniGetSalesByBranchID = new JMenuItem("Ver Ventas");
    private final JMenuItem mniUpdateBranch = new JMenuItem("Editar");

    public BranchScreen() {
        viewModel = BranchModule.getInstance().provideBranchViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblBody = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblBranches = new javax.swing.JLabel();
        lblQuantityBranches = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBranches = new javax.swing.JTable();
        pnlDetail = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        lblBranch = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblEnteredBranch = new javax.swing.JLabel();
        lblEnteredAddress = new javax.swing.JLabel();
        pnlPending = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(768, 640));

        lblHeadline.setText("Gestión de Locales");

        lblBody.setText("Administra y organiza todas tus ubicaciones de manera eficiente");

        jPanel1.setPreferredSize(new java.awt.Dimension(231, 82));

        lblBranches.setText("Sucursales");

        lblQuantityBranches.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuantityBranches)
                    .addComponent(lblBranches))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblBranches)
                .addGap(6, 6, 6)
                .addComponent(lblQuantityBranches)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        txtSearch.setPreferredSize(new java.awt.Dimension(160, 22));

        tblBranches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Local", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
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
        tblBranches.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBranches);
        if (tblBranches.getColumnModel().getColumnCount() > 0) {
            tblBranches.getColumnModel().getColumn(0).setMinWidth(64);
            tblBranches.getColumnModel().getColumn(0).setPreferredWidth(64);
            tblBranches.getColumnModel().getColumn(0).setMaxWidth(64);
            tblBranches.getColumnModel().getColumn(1).setPreferredWidth(256);
            tblBranches.getColumnModel().getColumn(2).setPreferredWidth(256);
        }

        pnlDetail.setPreferredSize(new java.awt.Dimension(718, 82));

        btnUpdate.setText("Editar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblBranch.setText("Nombre del Local");

        lblAddress.setText("Direccion del Local");

        lblEnteredBranch.setText("-");

        lblEnteredAddress.setText("-");

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBranch)
                    .addComponent(lblEnteredBranch))
                .addGap(64, 64, 64)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnteredAddress)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(24, 24, 24))
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnUpdate))
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBranch)
                            .addComponent(lblAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEnteredBranch)
                            .addComponent(lblEnteredAddress))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnlPending.setPreferredSize(new java.awt.Dimension(32, 82));

        javax.swing.GroupLayout pnlPendingLayout = new javax.swing.GroupLayout(pnlPending);
        pnlPending.setLayout(pnlPendingLayout);
        pnlPendingLayout.setHorizontalGroup(
            pnlPendingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        pnlPendingLayout.setVerticalGroup(
            pnlPendingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                            .addComponent(pnlDetail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblBody, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHeadline, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pnlPending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline)
                .addGap(6, 6, 6)
                .addComponent(lblBody)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPending, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new BranchEvent.GetBranchListEvent());
    }

    @Override
    public void setBranchList(List<Branch> branches) {

        this.branches = branches;

        DefaultTableModel model = (DefaultTableModel) tblBranches.getModel();
        model.setRowCount(0);

        boolean isFirst = true;

        for (Branch branch: branches) {

            model.addRow(new Object[] {
                    branch.getId(),
                    branch.getName(),
                    branch.getAddress()
            });

            if (isFirst) {
                tblBranches.setRowSelectionInterval(0, 0);
                setBranch();
            }

            isFirst = false;

        }

        lblQuantityBranches.setText(branches.size() + "");

    }

    private void setBranch() {

        int row = tblBranches.getSelectedRow();
        if (row > -1) {

            Branch branch = branches.get(row);

            lblEnteredBranch.setText(branch.getName());
            lblEnteredAddress.setText(branch.getAddress());

        }
    }

    private void add() {
        Runnable requestPermission = () -> {
            NavigationController.getInstance().navigate(NavigationController.Route.ADD_BRANCH_SCREEN, null);
        };
        NavigationController.getInstance().navigate(NavigationController.Route.DEVELOPMENT_SCREEN, new NavigationData(
                new Object[] { requestPermission }, new Class[] { Runnable.class }
        ));
    }

    private void update() {
        try {
            int row = tblBranches.getSelectedRow();
            if (row > -1) {
                Branch branch = branches.get(row);
                if (branch.getId() == 1) {
                    Runnable requestPermission = () -> {
                        NavigationController.getInstance().navigate(NavigationController.Route.UPDATE_BRANCH_SCREEN, new NavigationData(
                                new Object[] { branch }, new Class[] { Branch.class }
                        ));
                    };
                    NavigationController.getInstance().navigate(NavigationController.Route.DEVELOPMENT_SCREEN, new NavigationData(
                            new Object[] { requestPermission }, new Class[] { Runnable.class }
                    ));
                } else {
                    NavigationController.getInstance().navigate(NavigationController.Route.UPDATE_BRANCH_SCREEN, new NavigationData(
                            new Object[] { branch }, new Class[] { Branch.class }
                    ));
                }
            } else {
                throw new NoItemSelectedException();
            }
        } catch (NoItemSelectedException e) {
            ViewStateController.getInstance().isFailure(e);
        }
    }

    private void delete() {
        try {
            int row = tblBranches.getSelectedRow();
            if (row > -1) {
                Runnable requestPermission = () -> {
                    Runnable task = () -> {
                        int id = branches.get(row).getId();
                        viewModel.onEvent(new BranchEvent.DeleteBranchByIDEvent(id));
                    };
                    NavigationController.getInstance().navigate(NavigationController.Route.DELETE_SCREEN, new NavigationData(
                            new Object[] { task }, new Class[] { Runnable.class }
                    ));
                };
                NavigationController.getInstance().navigate(NavigationController.Route.DEVELOPMENT_SCREEN, new NavigationData(
                        new Object[] { requestPermission }, new Class[] { Runnable.class }
                ));
            } else {
                throw new NoItemSelectedException();
            }
        } catch (NoItemSelectedException e) {
            ViewStateController.getInstance().isFailure(e);
        }
    }

    private void fetchSalesByBranchID() {
        try {
            int row = tblBranches.getSelectedRow();
            if (row > -1) {
                NavigationController.getInstance().navigate(NavigationController.Route.LOCALE_SALE_SCREEN, new NavigationData(
                        new Object[] { branches.get(row).getId() }, new Class[] { Integer.class }
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
        viewModel.onEvent(new BranchEvent.GetBranchListEvent());
        txtSearch.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblBranches;
    private javax.swing.JLabel lblEnteredAddress;
    private javax.swing.JLabel lblEnteredBranch;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblQuantityBranches;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPanel pnlPending;
    private javax.swing.JTable tblBranches;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(jPanel1, "container");
            Styles.setStyleTo(pnlPending, "container");
            Styles.setStyleTo(pnlDetail, "container");

            Styles.setStyleTo(lblHeadline, "headline.large");

            Styles.setStyleTo(lblBody, "body.small");

            Styles.setStyleTo(txtSearch, "field.plain");
            Placeholder.setPlaceholderTo(txtSearch, "Buscar...");

            popupBranchAction.add(mniGetSalesByBranchID);
            popupBranchAction.add(new JSeparator());
            popupBranchAction.add(mniUpdateBranch);

            mniUpdateBranch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

            Styles.setStyleTo(lblQuantityBranches, "title.small");

            Styles.setStyleTo(lblEnteredBranch, "title.small");

            Styles.setStyleTo(lblEnteredAddress, "title.small");

            Styles.setStyleTo(btnUpdate, "button.outline");

        }

        public void initializeListeners() {

            mniUpdateBranch.addActionListener(e -> update());

            mniGetSalesByBranchID.addActionListener(e -> fetchSalesByBranchID());

            txtSearch.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && c != ' ')
                        e.consume();
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    String search = txtSearch.getText();
                    if (search.isEmpty())
                        viewModel.onEvent(new BranchEvent.GetBranchListEvent());
                    else
                        viewModel.onEvent(new BranchEvent.GetBranchListBySearchEvent(search));
                }

            });

            tblBranches.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    setBranch();
                }
            });

            tblBranches.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        int row = tblBranches.getSelectedRow();
                        if (row != -1)
                            popupBranchAction.show(tblBranches, e.getX(), e.getY());
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
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_DOWN_MASK), ADD);
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
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.ALT_DOWN_MASK), DELETE);
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

    }

}