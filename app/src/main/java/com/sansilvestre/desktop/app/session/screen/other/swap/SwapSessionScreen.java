package com.sansilvestre.desktop.app.session.screen.other.swap;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.session.module.SessionModule;
import com.sansilvestre.desktop.app.session.screen.SessionEvent;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SwapSessionScreen extends javax.swing.JPanel implements SwapSessionViewController {

    private final SwapSessionViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Session session;
    private final int checkoutId;

    private double closeAmount;

    public SwapSessionScreen(Session session, int checkoutId) {
        viewModel = SessionModule.getInstance().provideSwapSessionViewModel();
        this.session = session;
        this.checkoutId = checkoutId;
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblBody = new javax.swing.JLabel();
        btnArch = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(384, 133));

        lblHeadline.setText("Ya es hora de descansar");

        lblBody.setText("Finalizo tu turno ¿Qué deseas hacer ahora?");
        lblBody.setPreferredSize(new java.awt.Dimension(336, 16));

        btnArch.setText("Arqueo de Caja");
        btnArch.setPreferredSize(new java.awt.Dimension(165, 23));
        btnArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchActionPerformed(evt);
            }
        });

        btnClose.setText("Cerrar Caja");
        btnClose.setPreferredSize(new java.awt.Dimension(165, 23));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnArch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHeadline)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblHeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void setup() {
        screen.assembleComponents();
        shortcut.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new SessionEvent.GetTotalAmountBySessionIDEvent(session.getId()));
    }

    @Override
    public void setCloseAmount(double closeAmount) {
        this.closeAmount = closeAmount;
    }

    private void btnArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchActionPerformed
        NavigationController.getInstance().navigate(NavigationController.Route.ARCH_SESSION_SCREEN, new NavigationData(
                new Object[] { session, checkoutId, closeAmount }, new Class[] { Integer.class, Integer.class, Double.class }
        ));
    }//GEN-LAST:event_btnArchActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        NavigationController.getInstance().navigate(NavigationController.Route.CLOSE_SESSION_SCREEN, new NavigationData(
                new Object[] { session.getId(), closeAmount }, new Class[] { Integer.class, Integer.class }
        ));
    }//GEN-LAST:event_btnCloseActionPerformed

    public void dispose() {
        NavigationController.getInstance().navigate(NavigationController.Route.DISPOSE_SCREEN, new NavigationData(
                new Object[] { this }, new Class[] { JPanel.class }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArch;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblHeadline;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(lblHeadline, "label.large");

            Styles.setStyleTo(btnClose, "button.outline.danger");

            Styles.setStyleTo(btnArch, "button.outline");

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