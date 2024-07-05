package com.sansilvestre.desktop.app.shift.screen;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.shift.module.ShiftModule;
import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.util.exception.NoItemSelectedException;
import com.sansilvestre.desktop.app.util.log.Console;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ShiftScreen extends javax.swing.JPanel implements ShiftViewController {

    private final ShiftViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private List<Shift> shifts;
    private List<Checkout> checkouts;

    private final CountDownLatch listenersSynchronizer = new CountDownLatch(2);

    private final JPopupMenu popupShiftOrCheckoutAction = new JPopupMenu();

    private final JMenuItem mniUpdateShiftOrCheckout = new JMenuItem("Editar");
    private final JMenuItem mniDeleteShiftOrCheckout = new JMenuItem("Eliminar");

    public ShiftScreen() {
        viewModel = ShiftModule.getInstance().provideShiftViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblBody = new javax.swing.JLabel();
        lblShifts = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCheckouts = new javax.swing.JTable();
        lblCheckouts = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblShifts = new javax.swing.JTable();
        pnlDetail = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        lblShift = new javax.swing.JLabel();
        lblCheckout = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        lblEnteredShift = new javax.swing.JLabel();
        lblEnteredCheckout = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(768, 640));

        lblHeadline.setText("Gestión de Turnos y Cajas");

        lblBody.setText("Administra y supervisa los turnos laborales y el control de cajas de cada turno");

        lblShifts.setText("Turnos Laborales");

        tblCheckouts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Caja"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCheckouts.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCheckouts);
        if (tblCheckouts.getColumnModel().getColumnCount() > 0) {
            tblCheckouts.getColumnModel().getColumn(0).setMinWidth(64);
            tblCheckouts.getColumnModel().getColumn(0).setPreferredWidth(64);
            tblCheckouts.getColumnModel().getColumn(0).setMaxWidth(64);
        }

        lblCheckouts.setText("Cajas");

        tblShifts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Turno", "Inicio", "Finalizacion"
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
        tblShifts.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblShifts);
        if (tblShifts.getColumnModel().getColumnCount() > 0) {
            tblShifts.getColumnModel().getColumn(0).setMinWidth(64);
            tblShifts.getColumnModel().getColumn(0).setPreferredWidth(64);
            tblShifts.getColumnModel().getColumn(0).setMaxWidth(64);
            tblShifts.getColumnModel().getColumn(2).setMinWidth(128);
            tblShifts.getColumnModel().getColumn(2).setPreferredWidth(128);
            tblShifts.getColumnModel().getColumn(2).setMaxWidth(128);
            tblShifts.getColumnModel().getColumn(3).setMinWidth(128);
            tblShifts.getColumnModel().getColumn(3).setPreferredWidth(128);
            tblShifts.getColumnModel().getColumn(3).setMaxWidth(128);
        }

        pnlDetail.setPreferredSize(new java.awt.Dimension(333, 82));

        btnUpdate.setText("Editar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblShift.setText("Turno");

        lblCheckout.setText("Caja");

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblEnteredShift.setText("-");

        lblEnteredCheckout.setText("-");

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblShift)
                    .addComponent(lblEnteredShift))
                .addGap(64, 64, 64)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnteredCheckout)
                    .addComponent(lblCheckout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addGap(24, 24, 24))
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)))
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblShift)
                            .addComponent(lblCheckout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEnteredShift)
                            .addComponent(lblEnteredCheckout))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnAdd.setText("Añadir nuevo turno");
        btnAdd.setContentAreaFilled(false);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setText("¿No encuentras el turno que buscas?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblShifts)
                                            .addComponent(lblBody)
                                            .addComponent(lblHeadline))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCheckouts)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                    .addComponent(lblShifts)
                    .addComponent(lblCheckouts))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        shortcut.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new ShiftEvent.GetShiftListEvent());
        viewModel.onEvent(new ShiftEvent.GetCheckoutListEvent());
        initializeListeners();
    }

    @Override
    public void setShiftList(List<Shift> shifts) {

        this.shifts = shifts;

        DefaultTableModel model = (DefaultTableModel) tblShifts.getModel();
        model.setRowCount(0);

        boolean isFirst = true;

        for (Shift shift: shifts) {

            model.addRow(new Object[] {
                    shift.getId(),
                    shift.getName(),
                    shift.getStartTime(),
                    shift.getEndTime()
            });

            if (isFirst) {
                tblShifts.setRowSelectionInterval(0, 0);
                setValues();
            }

            isFirst = false;

        }

        listenersSynchronizer.countDown();

    }

    @Override
    public void setCheckoutList(List<Checkout> checkouts) {

        this.checkouts = checkouts;

        DefaultTableModel model = (DefaultTableModel) tblCheckouts.getModel();
        model.setRowCount(0);

        boolean isFirst = true;

        for (Checkout checkout: checkouts) {

            model.addRow(new Object[] {
                    checkout.getId(),
                    checkout.getName()
            });

            if (isFirst) {
                tblCheckouts.setRowSelectionInterval(0, 0);
                setValues();
            }

            isFirst = false;

        }

        listenersSynchronizer.countDown();

    }

    private void setValues() {

        int rowShift = tblShifts.getSelectedRow();

        if (rowShift > -1) {
            Shift shift = shifts.get(rowShift);
            lblEnteredShift.setText(shift.getName());
        }

        int rowCheckout = tblCheckouts.getSelectedRow();

        if (rowCheckout > -1) {
            Checkout checkout = checkouts.get(rowCheckout);
            lblEnteredCheckout.setText(checkout.getName());
        }

    }

    private void initializeListeners() {
        try {
            listenersSynchronizer.await();
        } catch (InterruptedException e) {
            Console.warn(Console.WarnCode.W001, "ERROR: Listeners Synchronizer");
        }
        screen.initializeListeners();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void add() {
        NavigationController.getInstance().navigate(NavigationController.Route.ADD_SHIFT_SCREEN, null);
        refresh();
    }

    private void update() {
        try {
            int row = tblShifts.getSelectedRow();
            if (row != -1) {
                NavigationController.getInstance().navigate(NavigationController.Route.UPDATE_SHIFT_SCREEN, new NavigationData(
                        new Object[] { shifts.get(row), checkouts.get(row) }, new Class[] { Shift.class, Checkout.class }
                ));
                refresh();
            } else {
                throw new NoItemSelectedException();
            }
        } catch (NoItemSelectedException e) {
            ViewStateController.getInstance().isFailure(e);
        }
    }

    private void delete() {
        try {
            int row = tblShifts.getSelectedRow();
            if (row != -1) {
                Runnable task = () -> {
                    viewModel.onEvent(new ShiftEvent.DeleteShiftByIDEvent(shifts.get(row).getId(), checkouts.get(row).getId()));
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
        viewModel.onEvent(new ShiftEvent.GetShiftListEvent());
        viewModel.onEvent(new ShiftEvent.GetCheckoutListEvent());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblCheckout;
    private javax.swing.JLabel lblCheckouts;
    private javax.swing.JLabel lblEnteredCheckout;
    private javax.swing.JLabel lblEnteredShift;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblShift;
    private javax.swing.JLabel lblShifts;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JTable tblCheckouts;
    private javax.swing.JTable tblShifts;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(pnlDetail, "container");

            Styles.setStyleTo(lblHeadline, "headline.large");

            Styles.setStyleTo(lblShifts, "label.small");

            Styles.setStyleTo(lblCheckouts, "label.small");

            popupShiftOrCheckoutAction.add(mniUpdateShiftOrCheckout);
            popupShiftOrCheckoutAction.add(mniDeleteShiftOrCheckout);

            mniUpdateShiftOrCheckout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
            mniDeleteShiftOrCheckout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

            TableRenderer renderer = new TableRenderer();

            tblShifts.getColumnModel().getColumn(0).setCellRenderer(renderer);
            tblShifts.getColumnModel().getColumn(1).setCellRenderer(renderer);
            tblShifts.getColumnModel().getColumn(2).setCellRenderer(renderer);
            tblShifts.getColumnModel().getColumn(3).setCellRenderer(renderer);

            tblCheckouts.getColumnModel().getColumn(0).setCellRenderer(renderer);
            tblCheckouts.getColumnModel().getColumn(1).setCellRenderer(renderer);

            Styles.setStyleTo(lblEnteredShift, "title.small");

            Styles.setStyleTo(lblEnteredCheckout, "title.small");

            Styles.setStyleTo(btnAdd, "button.text");
            Styles.setStyleTo(btnUpdate, "button.outline");
            Styles.setStyleTo(btnDelete, "button.outline.danger");

        }

        public void initializeListeners() {

            mniUpdateShiftOrCheckout.addActionListener(e -> update());

            mniDeleteShiftOrCheckout.addActionListener(e -> delete());

            tblShifts.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int row = tblShifts.getSelectedRow();
                    if (row != -1) {
                        tblCheckouts.setRowSelectionInterval(row, row);
                        setValues();
                    }
                }
            });

            tblShifts.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        popupShiftOrCheckoutAction.show(tblShifts, e.getX(), e.getY());
                    }
                }

            });

            tblCheckouts.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int row = tblCheckouts.getSelectedRow();
                    if (row != -1) {
                        tblShifts.setRowSelectionInterval(row, row);
                        setValues();
                    }
                }
            });

            tblCheckouts.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        popupShiftOrCheckoutAction.show(tblCheckouts, e.getX(), e.getY());
                    }
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

            if (column == 0 || column == 2 || column == 3) {
                return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }

            if (column == 1) {
                setHorizontalAlignment(SwingConstants.LEFT);
            }

            return component;

        }
    }

    private class Shortcut {

        public void configure(JComponent component) {

            InputMap input = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

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

    }

}