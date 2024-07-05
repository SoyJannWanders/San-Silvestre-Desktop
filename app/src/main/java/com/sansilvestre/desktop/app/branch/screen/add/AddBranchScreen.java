package com.sansilvestre.desktop.app.branch.screen.add;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.branch.domain.util.exception.InvalidAddressException;
import com.sansilvestre.desktop.app.branch.module.BranchModule;
import com.sansilvestre.desktop.app.branch.screen.BranchEvent;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.exception.form.BlankAddressException;
import com.sansilvestre.desktop.app.util.exception.form.BlankNameException;
import com.sansilvestre.desktop.app.util.exception.form.InvalidNameException;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class AddBranchScreen extends javax.swing.JPanel implements AddBranchViewController {

    private final AddBranchViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Form form = new Form();

    private final List<JComponent> inputs = new ArrayList<>();

    public AddBranchScreen() {
        viewModel = BranchModule.getInstance().provideAddBranchViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDispose = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(256, 312));

        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Nueva Sucursal");

        btnAdd.setText("Guardar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDispose.setText("Cancelar");
        btnDispose.setContentAreaFilled(false);
        btnDispose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisposeActionPerformed(evt);
            }
        });

        lblName.setText("Nombre");

        txtName.setPreferredSize(new java.awt.Dimension(192, 22));

        txtAddress.setPreferredSize(new java.awt.Dimension(160, 22));

        lblAddress.setText("Dirección");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblName)
                    .addComponent(lblAddress)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDispose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblHeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDispose)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisposeActionPerformed
        dispose();
    }//GEN-LAST:event_btnDisposeActionPerformed

    private void add() {
        Response<Branch> response = form.isValid();
        response.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Branch> success) {
                viewModel.onEvent(new BranchEvent.AddBranchEvent(success.getObject()));
            }

            @Override
            public void visitFailure(Response.Failure<Branch> failure) {
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDispose;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(lblHeadline, "label.large");

            Styles.setStyleTo(lblName, "label.small");

            Styles.setStyleTo(txtName, "field.plain");
            Placeholder.setPlaceholderTo(txtName, "Jujuy");
            
            Styles.setStyleTo(lblAddress, "label.small");

            Styles.setStyleTo(txtAddress, "field.plain");
            Placeholder.setPlaceholderTo(txtAddress, "Av. Jujuy 745");

            Styles.setStyleTo(btnDispose, "button.text");

            inputs.add(txtAddress);

        }

        public void initializeListeners() {

            txtName.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && c != ' ')
                        e.consume();
                }

            });

            txtAddress.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != ' ' && c != '.')
                        e.consume();
                }

            });

        }

    }

    private class Shortcut {

        public void configure(JComponent component) {

            InputMap input = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

            final String ADD = "add";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), ADD);
            actionMap.put(ADD, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!inputs.isEmpty()) {
                        inputs.getFirst().requestFocus();
                        inputs.removeFirst();
                    } else {
                        add();
                    }
                }
            });

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

        public Response<Branch> isValid() {

            try {

                String name = isValidName(txtName.getText());

                String address = isValidAddress(txtAddress.getText());

                return new Response.Success<>(new Branch(name, address));

            } catch (Exception e) {

                return new Response.Failure<>(e);

            }

        }

        private String isValidName(String text) throws BlankNameException, InvalidNameException {
            if (isBlank(text))
                throw new BlankNameException();
            if (text.chars().anyMatch(c -> !Character.isAlphabetic(c) && c != ' '))
                throw new InvalidNameException();
            return text.trim();
        }

        private String isValidAddress(String text) throws BlankAddressException, InvalidAddressException {
            if (isBlank(text))
                throw new BlankAddressException();
            if (text.chars().anyMatch(c -> !Character.isAlphabetic(c) && c != ' ' && c != '.'))
                throw new InvalidAddressException();
            return text;
        }

        private boolean isBlank(String input) {
            return input == null || input.trim().isEmpty();
        }

    }

}