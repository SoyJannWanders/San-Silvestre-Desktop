package com.sansilvestre.desktop.app.user.screen.update;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.user.domain.util.exception.InvalidIncreaseInputException;
import com.sansilvestre.desktop.app.user.module.UserModule;
import com.sansilvestre.desktop.app.user.screen.UserEvent;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.formatter.Percentage;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateUserSalaryScreen extends javax.swing.JPanel implements UpdateUserSalaryViewController {

    private final UpdateUserSalaryViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Form form = new Form();

    private final int id;
    private final double salary;

    public UpdateUserSalaryScreen(int id, double salary) {
        viewModel = UserModule.getInstance().provideUpdateUserSalaryViewModel();
        this.id = id;
        this.salary = salary;
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgMethod = new javax.swing.ButtonGroup();
        lblHeadline = new javax.swing.JLabel();
        lblMethods = new javax.swing.JLabel();
        rbFixedAmount = new javax.swing.JRadioButton();
        rbPercentage = new javax.swing.JRadioButton();
        lblAmount = new javax.swing.JLabel();
        btnIncrease = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtIncrease = new javax.swing.JTextField();
        pnlContainer = new javax.swing.JPanel();
        lblCurrentSalary = new javax.swing.JLabel();
        lblEnteredCurrentSalary = new javax.swing.JLabel();
        lblIncrease = new javax.swing.JLabel();
        lblEnteredIncrease = new javax.swing.JLabel();
        lblNewSalary = new javax.swing.JLabel();
        lblEnteredNewSalary = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(272, 434));

        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Nuevo Aumento");
        lblHeadline.setMaximumSize(new java.awt.Dimension(256, 16));
        lblHeadline.setPreferredSize(new java.awt.Dimension(224, 16));

        lblMethods.setText("Metodo");

        bgMethod.add(rbFixedAmount);
        rbFixedAmount.setSelected(true);
        rbFixedAmount.setText("Monto Fijo");
        rbFixedAmount.setToolTipText("");

        bgMethod.add(rbPercentage);
        rbPercentage.setText("Porcentual");

        lblAmount.setText("Monto");

        btnIncrease.setText("Aceptar");
        btnIncrease.setPreferredSize(new java.awt.Dimension(224, 23));
        btnIncrease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncreaseActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.setContentAreaFilled(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setPreferredSize(new java.awt.Dimension(224, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtIncrease.setPreferredSize(new java.awt.Dimension(224, 22));

        pnlContainer.setPreferredSize(new java.awt.Dimension(224, 98));

        lblCurrentSalary.setText("Actual S.");

        lblEnteredCurrentSalary.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEnteredCurrentSalary.setText("$ 0");
        lblEnteredCurrentSalary.setMaximumSize(new java.awt.Dimension(72, 16));
        lblEnteredCurrentSalary.setPreferredSize(new java.awt.Dimension(108, 16));

        lblIncrease.setText("Aumento");

        lblEnteredIncrease.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEnteredIncrease.setText("$ 0");
        lblEnteredIncrease.setMaximumSize(new java.awt.Dimension(72, 16));
        lblEnteredIncrease.setPreferredSize(new java.awt.Dimension(108, 16));

        lblNewSalary.setText("Nuevo S.");

        lblEnteredNewSalary.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEnteredNewSalary.setText("$ 0");
        lblEnteredNewSalary.setMaximumSize(new java.awt.Dimension(72, 16));
        lblEnteredNewSalary.setPreferredSize(new java.awt.Dimension(108, 16));

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIncrease)
                    .addComponent(lblNewSalary)
                    .addComponent(lblCurrentSalary))
                .addGap(18, 34, Short.MAX_VALUE)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnteredCurrentSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnteredNewSalary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnteredIncrease, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentSalary)
                    .addComponent(lblEnteredCurrentSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIncrease)
                    .addComponent(lblEnteredIncrease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewSalary)
                    .addComponent(lblEnteredNewSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbPercentage)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblAmount, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblHeadline, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbFixedAmount, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMethods, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnIncrease, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIncrease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMethods)
                .addGap(16, 16, 16)
                .addComponent(rbFixedAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPercentage)
                .addGap(16, 16, 16)
                .addComponent(lblAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIncrease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(pnlContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnIncrease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
    }

    private void btnIncreaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncreaseActionPerformed
        Response<Void> response = form.isValid();
        response.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                viewModel.onEvent(new UserEvent.UpdateUserSalaryByIDEvent(Currency.toDouble(lblEnteredNewSalary.getText()), id));
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                ViewStateController.getInstance().isFailure(failure.getException());
            }

        });
    }//GEN-LAST:event_btnIncreaseActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    @Override
    public void dispose() {
        NavigationController.getInstance().navigate(NavigationController.Route.DISPOSE_SCREEN, new NavigationData(
                new Object[] { this }, new Class[] { JPanel.class }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgMethod;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnIncrease;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCurrentSalary;
    private javax.swing.JLabel lblEnteredCurrentSalary;
    private javax.swing.JLabel lblEnteredIncrease;
    private javax.swing.JLabel lblEnteredNewSalary;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblIncrease;
    private javax.swing.JLabel lblMethods;
    private javax.swing.JLabel lblNewSalary;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JRadioButton rbFixedAmount;
    private javax.swing.JRadioButton rbPercentage;
    private javax.swing.JTextField txtIncrease;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(pnlContainer, "container");

            Styles.setStyleTo(lblHeadline, "label.large");

            Styles.setStyleTo(lblMethods, "label.small");

            Styles.setStyleTo(lblAmount, "label.small");

            Placeholder.setPlaceholderTo(txtIncrease, "$ 0");

            lblEnteredCurrentSalary.setText(Currency.format(salary));

            Styles.setStyleTo(lblNewSalary, "label.medium");

            Styles.setStyleTo(lblEnteredNewSalary, "label.medium");

            lblEnteredNewSalary.setText(Currency.format(salary));

            Styles.setStyleTo(btnCancel, "button.text");

        }

        public void initializeListeners() {

            rbFixedAmount.addActionListener(e -> {
                Placeholder.setPlaceholderTo(txtIncrease, "$ 0");
                txtIncrease.setText("");
            });

            rbPercentage.addActionListener(e -> {
                Placeholder.setPlaceholderTo(txtIncrease, "0%");
                txtIncrease.setText("");
            });

            txtIncrease.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    String in = txtIncrease.getText();
                    if (rbPercentage.isSelected())
                        txtIncrease.setText(Percentage.removeFormat(in));
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    String in = txtIncrease.getText();
                    char c = e.getKeyChar();
                    if (Character.isDigit(c) || c == ',' || c == '.') {
                        if (c == '.' || c == ',') {
                            e.setKeyChar(',');
                            if (in.isEmpty() || in.contains(","))
                                e.consume();
                        }
                        if (c == '0') {
                            if (in.equals("$ 0") || in.equals("0%") || in.equals("0"))
                                e.consume();
                        }
                    } else {
                        e.consume();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    String in = txtIncrease.getText();
                    String formattedText;
                    double increase;
                    if (rbFixedAmount.isSelected()) {
                        formattedText = Currency.format(in);
                        increase = Currency.toDouble(in);
                        lblEnteredIncrease.setText(Currency.format(increase));
                    } else {
                        formattedText = Percentage.format(in);
                        increase = salary * ( Percentage.toDouble(in) / 100 );
                        lblEnteredIncrease.setText(Currency.format(increase));
                    }
                    txtIncrease.setText(formattedText);
                    lblEnteredNewSalary.setText(Currency.format(salary + increase));
                }

            });

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

    private class Form {

        public Response<Void> isValid() {

            try {

                validateIncrease(txtIncrease.getText());

                return new Response.Success<>(null);

            } catch (Exception e) {

                return new Response.Failure<>(e);

            }

        }

        private void validateIncrease(String increase) throws InvalidIncreaseInputException {
            if (isBlank(increase))
                throw new InvalidIncreaseInputException();
        }

        private boolean isBlank(String input) {
            return input == null || input.trim().isEmpty();
        }

    }

}