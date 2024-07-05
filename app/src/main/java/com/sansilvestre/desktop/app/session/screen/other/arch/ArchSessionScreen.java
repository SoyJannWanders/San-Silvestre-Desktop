package com.sansilvestre.desktop.app.session.screen.other.arch;

import com.formdev.flatlaf.FlatClientProperties;
import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.util.exception.form.BlankAmountException;
import com.sansilvestre.desktop.app.session.module.SessionModule;
import com.sansilvestre.desktop.app.session.screen.SessionEvent;
import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.formatter.SalePoint;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.util.formatter.Date;

import javax.swing.*;
import java.awt.event.*;

public class ArchSessionScreen extends javax.swing.JPanel implements ArchSessionViewController {

    private final ArchSessionViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Form form = new Form();

    private final Session session;
    private final int checkoutId;

    private final double closeAmount;

    public ArchSessionScreen(Session session, int checkoutId, double closeAmount) {
        viewModel = SessionModule.getInstance().provideArchSessionViewModel();
        this.session = session;
        this.checkoutId = checkoutId;
        this.closeAmount = closeAmount;
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblCheckout = new javax.swing.JLabel();
        lblEnteredPreviousCheckout = new javax.swing.JLabel();
        lblDateTime = new javax.swing.JLabel();
        lblEnteredDateTime = new javax.swing.JLabel();
        pnlContainer = new javax.swing.JPanel();
        lblAmount = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        btnOpen = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblEnteredNextCheckout = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(384, 307));

        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Arqueo de Caja");
        lblHeadline.setPreferredSize(new java.awt.Dimension(320, 16));

        lblCheckout.setLabelFor(lblEnteredPreviousCheckout);
        lblCheckout.setText("Caja");

        lblEnteredPreviousCheckout.setText("0001");

        lblDateTime.setLabelFor(lblEnteredDateTime);
        lblDateTime.setText("Fecha y Hora");

        lblEnteredDateTime.setText("11/11/11 · 11:11");

        lblAmount.setLabelFor(txtAmount);
        lblAmount.setText("Monto");

        txtAmount.setPreferredSize(new java.awt.Dimension(288, 22));

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAmount)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblAmount)
                .addGap(8, 8, 8)
                .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        btnOpen.setText("Arqueo");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.setContentAreaFilled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setText(">");

        lblEnteredNextCheckout.setText("0002");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOpen))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblEnteredPreviousCheckout)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblEnteredNextCheckout)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEnteredDateTime))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblCheckout)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDateTime))
                        .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCheckout)
                    .addComponent(lblDateTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnteredPreviousCheckout)
                    .addComponent(lblEnteredDateTime)
                    .addComponent(jLabel1)
                    .addComponent(lblEnteredNextCheckout))
                .addGap(24, 24, 24)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen)
                    .addComponent(btnCancel))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
    }

    @Override
    public void archSession() {
        NavigationController.getInstance().navigate(NavigationController.Route.DASHBOARD_SCREEN, new NavigationData(
                new Object[] { Role.EMPLOYEE }, new Class[] { Role.class }
        ));
        dispose();
    }

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        arch();
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void arch() {
        Response<Void> response = form.isValid();
        response.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                double openAmount = Currency.toDouble(txtAmount.getText());
                viewModel.onEvent(new SessionEvent.ArchSessionEvent(session.getId(), checkoutId, openAmount, closeAmount));
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                ViewStateController.getInstance().isFailure(failure.getException());
            }

        });
    }

    @Override
    public void dispose() {
        NavigationController.getInstance().navigate(NavigationController.Route.DISPOSE_SCREEN, new NavigationData(
                new Object[] { this }, new Class[] { JPanel.class }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOpen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCheckout;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JLabel lblEnteredDateTime;
    private javax.swing.JLabel lblEnteredNextCheckout;
    private javax.swing.JLabel lblEnteredPreviousCheckout;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(pnlContainer, "container");

            Styles.setStyleTo(lblHeadline, "headline.small");

            Styles.setStyleTo(lblCheckout, "label.small");

            Styles.setStyleTo(lblEnteredPreviousCheckout, "body.small");
            lblEnteredPreviousCheckout.setText(SalePoint.format(session.getCheckoutId()));

            lblEnteredNextCheckout.setText(SalePoint.format(checkoutId));

            Styles.setStyleTo(lblDateTime, "label.small");

            Styles.setStyleTo(lblEnteredDateTime, "body.small");
            lblEnteredDateTime.setText(Date.now());

            Styles.setStyleTo(lblAmount, "label.small");

            txtAmount.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "$ 0");
            txtAmount.setText("$ 6000");

            Styles.setStyleTo(btnCancel, "button.text");

        }

        public void initializeListeners() {

            txtAmount.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    String in = txtAmount.getText();
                    char c = e.getKeyChar();
                    if (Character.isDigit(c) || c == ',' || c == '.') {
                        if (c == '.' || c == ',') {
                            e.setKeyChar(',');
                            if (in.isEmpty() || in.contains(","))
                                e.consume();
                        }
                        if (c == '0') {
                            if (in.equals("$ 0") || in.equals("0"))
                                e.consume();
                        }
                    } else {
                        e.consume();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    String in = txtAmount.getText();
                    txtAmount.setText(Currency.format(in));
                }

            });

            txtAmount.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseReleased(MouseEvent e) {
                    txtAmount.setText("");
                }

            });

        }

    }

    private class Shortcut {

        public void configure(JPanel component) {

            InputMap input = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

            final String NAVIGATE_BACK_ACTION = "navigateBack";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), NAVIGATE_BACK_ACTION);
            actionMap.put(NAVIGATE_BACK_ACTION, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            final String NAVIGATE_TO_DASHBOARD_ACTION = "navigateToDashboard";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), NAVIGATE_TO_DASHBOARD_ACTION);
            actionMap.put(NAVIGATE_TO_DASHBOARD_ACTION, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    arch();
                }
            });

        }

    }

    private class Form {

        public Response<Void> isValid() {

            try {

                isValidAmount(txtAmount.getText());

                return new Response.Success<>(null);

            } catch (Exception e) {

                return new Response.Failure<>(e);

            }

        }

        private void isValidAmount(String amount) throws BlankAmountException {
            if (isBlank(amount))
                throw new BlankAmountException();
        }

        private boolean isBlank(String input) {
            return input == null || input.trim().isEmpty();
        }

    }

}