package com.sansilvestre.desktop.app.dashboard.screen.component.menu.employee.screen;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.dashboard.screen.component.menu.employee.module.EmployeeMenuModule;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.util.ui.Theme;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EmployeeMenu extends javax.swing.JPanel implements EmployeeMenuViewController {

    private final EmployeeMenuViewModel viewModel;

    private final Screen screen = new Screen();

    private Session session;

    private Shift shiftCache;
    private Shift shift;

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public EmployeeMenu() {
        viewModel = EmployeeMenuModule.getInstance().provideEmployeeMenuViewModel();
        initComponents();
        setup();
    }

    private void setup() {
        screen.assembleComponents();
        viewModel.setViewController(this);
        viewModel.onEvent(new EmployeeMenuEvent.GetSessionEvent());
        viewModel.onEvent(new EmployeeMenuEvent.GetShiftEvent());
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void setShift(Shift shift) {

        this.shift = shift;

        if (shiftCache == null) {
            shiftCache = shift;
            repeat();
        }

        if (shift.getId() != shiftCache.getId()) {
            swap();
            scheduler.shutdown();
        }

    }

    private void repeat() {
        Runnable task = () -> {
            viewModel.onEvent(new EmployeeMenuEvent.GetShiftEvent());
        };
        scheduler.scheduleAtFixedRate(task, 30, 30, TimeUnit.SECONDS);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        officeLabel = new javax.swing.JLabel();
        branch = new javax.swing.JLabel();
        btnCheckoutScreen = new javax.swing.JButton();
        btnSaleScreen = new javax.swing.JButton();
        btnProductScreen = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnStyle = new javax.swing.JButton();
        btnNoteScreen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(192, 640));

        officeLabel.setText("Local");
        officeLabel.setPreferredSize(new java.awt.Dimension(98, 16));

        branch.setText("jLabel2");
        branch.setPreferredSize(new java.awt.Dimension(98, 16));

        btnCheckoutScreen.setText("Inicio");
        btnCheckoutScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCheckoutScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCheckoutScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnCheckoutScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutScreenActionPerformed(evt);
            }
        });

        btnSaleScreen.setText("Ventas");
        btnSaleScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaleScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSaleScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnSaleScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleScreenActionPerformed(evt);
            }
        });

        btnProductScreen.setText("Productos");
        btnProductScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnProductScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnProductScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductScreenActionPerformed(evt);
            }
        });

        btnLogout.setText("Cerrar Sesion");
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnLogout.setPreferredSize(new java.awt.Dimension(98, 23));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnStyle.setText("Cambiar de Tema");
        btnStyle.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnStyle.setPreferredSize(new java.awt.Dimension(98, 23));
        btnStyle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStyleActionPerformed(evt);
            }
        });

        btnNoteScreen.setText("Nota");
        btnNoteScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNoteScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnNoteScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnNoteScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoteScreenActionPerformed(evt);
            }
        });

        jSeparator1.setPreferredSize(new java.awt.Dimension(150, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(branch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(officeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStyle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNoteScreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProductScreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaleScreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCheckoutScreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(officeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(branch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnCheckoutScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnSaleScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNoteScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                .addComponent(btnStyle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckoutScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutScreenActionPerformed
        screen.reset();
        Styles.setStyleTo(btnCheckoutScreen, "button.menu.active");
    }//GEN-LAST:event_btnCheckoutScreenActionPerformed

    private void btnSaleScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleScreenActionPerformed
        NavigationController.getInstance().navigate(NavigationController.Route.LOCALE_SALE_SCREEN, new NavigationData(
                new Object[] { 5 }, new Class[] { Integer.class }
        ));
    }//GEN-LAST:event_btnSaleScreenActionPerformed

    private void btnProductScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductScreenActionPerformed
        NavigationController.getInstance().navigate(NavigationController.Route.SEARCH_PRODUCT_SCREEN, null);
    }//GEN-LAST:event_btnProductScreenActionPerformed

    private void btnNoteScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoteScreenActionPerformed

    }//GEN-LAST:event_btnNoteScreenActionPerformed

    private void btnStyleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStyleActionPerformed
        Theme.swap();
    }//GEN-LAST:event_btnStyleActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        swap();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void swap() {
        NavigationController.getInstance().navigate(NavigationController.Route.SWAP_SESSION_SCREEN, new NavigationData(
                new Object[] { session, shift.getCheckoutId() }, new Class[] { Session.class, Integer.class }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel branch;
    private javax.swing.JButton btnCheckoutScreen;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNoteScreen;
    private javax.swing.JButton btnProductScreen;
    private javax.swing.JButton btnSaleScreen;
    private javax.swing.JButton btnStyle;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel officeLabel;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(officeLabel, "body.small");
            officeLabel.setText("Local");

            Styles.setStyleTo(branch, "headline.small");
            branch.setText("Jujuy");

            Styles.setStyleTo(btnCheckoutScreen, "button.menu.active");
            Styles.setStyleTo(btnSaleScreen, "button.menu");
            Styles.setStyleTo(btnProductScreen, "button.menu");
            Styles.setStyleTo(btnNoteScreen, "button.menu");
            Styles.setStyleTo(btnStyle, "button.menu");
            Styles.setStyleTo(btnLogout, "button.menu");

        }

        public void reset() {

            Styles.setStyleTo(btnCheckoutScreen, "button.menu");
            Styles.setStyleTo(btnSaleScreen, "button.menu");
            Styles.setStyleTo(btnProductScreen, "button.menu");
            Styles.setStyleTo(btnNoteScreen, "button.menu");
            Styles.setStyleTo(btnStyle, "button.menu");
            Styles.setStyleTo(btnLogout, "button.menu");

        }

    }

}