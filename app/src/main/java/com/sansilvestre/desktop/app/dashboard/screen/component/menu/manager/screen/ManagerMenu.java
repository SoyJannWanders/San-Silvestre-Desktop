package com.sansilvestre.desktop.app.dashboard.screen.component.menu.manager.screen;

import com.sansilvestre.desktop.app.dashboard.screen.component.menu.administrator.screen.*;
import com.sansilvestre.desktop.app.dashboard.screen.component.menu.employee.screen.*;
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

public class ManagerMenu extends javax.swing.JPanel {

    private final Screen screen = new Screen();

    public ManagerMenu() {
        initComponents();
        setup();
    }

    private void setup() {
        screen.assembleComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        officeLabel = new javax.swing.JLabel();
        branch = new javax.swing.JLabel();
        btnHomeScreen = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnStyle = new javax.swing.JButton();
        btnBrancheScreen = new javax.swing.JButton();
        btnShiftScreen = new javax.swing.JButton();
        btnProductScreen = new javax.swing.JButton();
        btnUserScreen = new javax.swing.JButton();
        btnClientScreen = new javax.swing.JButton();
        btnSaleScreen = new javax.swing.JButton();
        btnHistoryScreen = new javax.swing.JButton();
        btnCategoryScreen = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(192, 640));

        officeLabel.setText("Local");
        officeLabel.setPreferredSize(new java.awt.Dimension(98, 16));

        branch.setText("Jujuy");
        branch.setPreferredSize(new java.awt.Dimension(98, 16));

        btnHomeScreen.setText("Inicio");
        btnHomeScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHomeScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnHomeScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnHomeScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeScreenActionPerformed(evt);
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

        btnBrancheScreen.setText("Locales");
        btnBrancheScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBrancheScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnBrancheScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnBrancheScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrancheScreenActionPerformed(evt);
            }
        });

        btnShiftScreen.setText("Turnos Laborales");
        btnShiftScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShiftScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnShiftScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnShiftScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShiftScreenActionPerformed(evt);
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

        btnUserScreen.setText("Usuarios");
        btnUserScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnUserScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnUserScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserScreenActionPerformed(evt);
            }
        });

        btnClientScreen.setText("Clientes");
        btnClientScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnClientScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnClientScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientScreenActionPerformed(evt);
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

        btnHistoryScreen.setText("Historial");
        btnHistoryScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistoryScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnHistoryScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnHistoryScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryScreenActionPerformed(evt);
            }
        });

        btnCategoryScreen.setText("Categorias");
        btnCategoryScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCategoryScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnCategoryScreen.setPreferredSize(new java.awt.Dimension(98, 23));
        btnCategoryScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryScreenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(branch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(officeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStyle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHomeScreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBrancheScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShiftScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaleScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHistoryScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategoryScreen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(officeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(branch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnHomeScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrancheScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnShiftScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategoryScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUserScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaleScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistoryScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(btnStyle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeScreenActionPerformed
        screen.reset();
        Styles.setStyleTo(btnHomeScreen, "button.menu.active");
        NavigationController.getInstance().navigate(NavigationController.Route.HOME_SCREEN, null);
    }//GEN-LAST:event_btnHomeScreenActionPerformed

    private void btnBrancheScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrancheScreenActionPerformed
        screen.reset();
        Styles.setStyleTo(btnBrancheScreen, "button.menu.active");
        NavigationController.getInstance().navigate(NavigationController.Route.BRANCH_SCREEN, null);
    }//GEN-LAST:event_btnBrancheScreenActionPerformed

    private void btnShiftScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShiftScreenActionPerformed
        screen.reset();
        Styles.setStyleTo(btnShiftScreen, "button.menu.active");
        NavigationController.getInstance().navigate(NavigationController.Route.SHIFT_SCREEN, null);
    }//GEN-LAST:event_btnShiftScreenActionPerformed

    private void btnProductScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductScreenActionPerformed
        screen.reset();
        Styles.setStyleTo(btnProductScreen, "button.menu.active");
        NavigationController.getInstance().navigate(NavigationController.Route.PRODUCT_SCREEN, null);
    }//GEN-LAST:event_btnProductScreenActionPerformed

    private void btnCategoryScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryScreenActionPerformed
        screen.reset();
        Styles.setStyleTo(btnCategoryScreen, "button.menu.active");
        NavigationController.getInstance().navigate(NavigationController.Route.CATEGORY_SCREEN, null);
    }//GEN-LAST:event_btnCategoryScreenActionPerformed

    private void btnUserScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserScreenActionPerformed
        screen.reset();
        Styles.setStyleTo(btnUserScreen, "button.menu.active");
        NavigationController.getInstance().navigate(NavigationController.Route.USER_SCREEN, null);
    }//GEN-LAST:event_btnUserScreenActionPerformed

    private void btnClientScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientScreenActionPerformed
        screen.reset();
        Styles.setStyleTo(btnClientScreen, "button.menu.active");
    }//GEN-LAST:event_btnClientScreenActionPerformed

    private void btnSaleScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleScreenActionPerformed
        screen.reset();
        Styles.setStyleTo(btnSaleScreen, "button.menu.active");
    }//GEN-LAST:event_btnSaleScreenActionPerformed

    private void btnHistoryScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryScreenActionPerformed
        screen.reset();
        Styles.setStyleTo(btnHistoryScreen, "button.menu.active");
    }//GEN-LAST:event_btnHistoryScreenActionPerformed

    private void btnStyleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStyleActionPerformed
        Theme.swap();
    }//GEN-LAST:event_btnStyleActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        NavigationController.getInstance().navigate(NavigationController.Route.LAUNCH_SCREEN, null);
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel branch;
    private javax.swing.JButton btnBrancheScreen;
    private javax.swing.JButton btnCategoryScreen;
    private javax.swing.JButton btnClientScreen;
    private javax.swing.JButton btnHistoryScreen;
    private javax.swing.JButton btnHomeScreen;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProductScreen;
    private javax.swing.JButton btnSaleScreen;
    private javax.swing.JButton btnShiftScreen;
    private javax.swing.JButton btnStyle;
    private javax.swing.JButton btnUserScreen;
    private javax.swing.JLabel officeLabel;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(officeLabel, "body.small");
            officeLabel.setText("Local");

            Styles.setStyleTo(branch, "headline.small");
            branch.setText("Jujuy");

            Styles.setStyleTo(btnHomeScreen, "button.menu.active");
            Styles.setStyleTo(btnBrancheScreen, "button.menu");
            Styles.setStyleTo(btnShiftScreen, "button.menu");
            Styles.setStyleTo(btnProductScreen, "button.menu");
            Styles.setStyleTo(btnCategoryScreen, "button.menu");
            Styles.setStyleTo(btnUserScreen, "button.menu");
            Styles.setStyleTo(btnClientScreen, "button.menu");
            Styles.setStyleTo(btnSaleScreen, "button.menu");
            Styles.setStyleTo(btnHistoryScreen, "button.menu");
            Styles.setStyleTo(btnStyle, "button.menu");
            Styles.setStyleTo(btnLogout, "button.menu");

        }

        public void reset() {

            Styles.setStyleTo(btnHomeScreen, "button.menu");
            Styles.setStyleTo(btnBrancheScreen, "button.menu");
            Styles.setStyleTo(btnShiftScreen, "button.menu");
            Styles.setStyleTo(btnProductScreen, "button.menu");
            Styles.setStyleTo(btnCategoryScreen, "button.menu");
            Styles.setStyleTo(btnUserScreen, "button.menu");
            Styles.setStyleTo(btnClientScreen, "button.menu");
            Styles.setStyleTo(btnSaleScreen, "button.menu");
            Styles.setStyleTo(btnHistoryScreen, "button.menu");
            Styles.setStyleTo(btnStyle, "button.menu");
            Styles.setStyleTo(btnLogout, "button.menu");

        }

    }

}