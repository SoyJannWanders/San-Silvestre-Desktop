package com.sansilvestre.desktop.app.user.screen.update;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.user.domain.util.exception.InvalidIncreaseInputException;
import com.sansilvestre.desktop.app.user.module.UserModule;
import com.sansilvestre.desktop.app.user.screen.UserEvent;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.formatter.Percentage;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.util.objects.IncreaseType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

public class UpdateUsersSalariesScreen extends javax.swing.JPanel implements UpdateUsersSalariesViewController {

    private final UpdateUsersSalariesViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Form form = new Form();

    private final Map<Integer, Branch> branches;

    public UpdateUsersSalariesScreen(Map<Integer, Branch> branches) {
        viewModel = UserModule.getInstance().provideUpdateUsersSalariesViewModel();
        this.branches = branches;
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
        lblBranch = new javax.swing.JLabel();
        cmbBranch = new javax.swing.JComboBox<>();
        lblIncrease = new javax.swing.JLabel();
        txtIncrease = new javax.swing.JTextField();
        btnIncrease = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(272, 368));

        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Nuevo Aumento");
        lblHeadline.setMaximumSize(new java.awt.Dimension(224, 16));
        lblHeadline.setPreferredSize(new java.awt.Dimension(224, 16));

        lblMethods.setText("Metodo");

        bgMethod.add(rbFixedAmount);
        rbFixedAmount.setSelected(true);
        rbFixedAmount.setText("Monto Fijo");
        rbFixedAmount.setToolTipText("");

        bgMethod.add(rbPercentage);
        rbPercentage.setText("Porcentual");

        lblBranch.setText("Sucursal");

        cmbBranch.setEditable(true);
        cmbBranch.setPreferredSize(new java.awt.Dimension(224, 22));

        lblIncrease.setText("Aumento");

        txtIncrease.setPreferredSize(new java.awt.Dimension(224, 22));

        btnIncrease.setText("Aceptar");
        btnIncrease.setPreferredSize(new java.awt.Dimension(224, 23));
        btnIncrease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncreaseActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.setContentAreaFilled(false);
        btnCancel.setPreferredSize(new java.awt.Dimension(224, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIncrease)
                    .addComponent(rbPercentage)
                    .addComponent(lblBranch)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbFixedAmount)
                    .addComponent(lblMethods)
                    .addComponent(cmbBranch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncrease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIncrease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(lblBranch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBranch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIncrease)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIncrease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                Branch branch = (Branch) cmbBranch.getSelectedItem();
                if (rbFixedAmount.isSelected())
                    viewModel.onEvent(new UserEvent.UpdateUsersSalariesByBranchIDEvent(
                            IncreaseType.FIXED,
                            Currency.toDouble(txtIncrease.getText()),
                            branch.getId()
                    ));
                else
                    viewModel.onEvent(new UserEvent.UpdateUsersSalariesByBranchIDEvent(
                            IncreaseType.PERCENTAGE,
                            Percentage.toDouble(txtIncrease.getText()),
                            branch.getId()
                    ));
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
    private javax.swing.JComboBox<Branch> cmbBranch;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblIncrease;
    private javax.swing.JLabel lblMethods;
    private javax.swing.JRadioButton rbFixedAmount;
    private javax.swing.JRadioButton rbPercentage;
    private javax.swing.JTextField txtIncrease;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(lblHeadline, "label.large");

            Styles.setStyleTo(lblMethods, "label.small");

            Styles.setStyleTo(lblBranch, "label.small");

            branches.forEach((id, branch) -> cmbBranch.addItem(branch));

            Placeholder.setPlaceholderTo(txtIncrease, "$ 0");

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

            cmbBranch.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    e.consume();
                }

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
                            if (in.equals("$ 0") || in.equals("0"))
                                e.consume();
                        }
                    } else {
                        e.consume();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if (rbFixedAmount.isSelected())
                        txtIncrease.setText(Currency.format(txtIncrease.getText()));
                    else
                        txtIncrease.setText(Percentage.format(txtIncrease.getText()));
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