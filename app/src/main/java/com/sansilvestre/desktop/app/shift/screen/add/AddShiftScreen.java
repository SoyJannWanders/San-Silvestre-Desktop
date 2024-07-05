package com.sansilvestre.desktop.app.shift.screen.add;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.checkout.domain.model.Checkout;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.shift.module.ShiftModule;
import com.sansilvestre.desktop.app.shift.screen.ShiftEvent;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.exception.form.BlankNameException;
import com.sansilvestre.desktop.app.util.exception.form.InvalidNameException;
import com.sansilvestre.desktop.app.util.exception.form.InvalidTimeException;
import com.sansilvestre.desktop.app.util.parser.Time;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.util.ui.component.picker.time.TimePicker;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AddShiftScreen extends javax.swing.JPanel implements AddShiftViewController {

    private final AddShiftViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Form form = new Form();

    private final Shift shift = new Shift();
    private final Checkout checkout = new Checkout();

    private final TimePicker startPicker = new TimePicker();
    private final TimePicker endPicker = new TimePicker();

    private final List<JComponent> inputs = new ArrayList<>();

    public AddShiftScreen() {
        viewModel = ShiftModule.getInstance().provideAddShiftViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblShift = new javax.swing.JLabel();
        pnlShiftContainer = new javax.swing.JPanel();
        lblShiftName = new javax.swing.JLabel();
        txtShiftName = new javax.swing.JTextField();
        lblStartTime = new javax.swing.JLabel();
        lblEndTime = new javax.swing.JLabel();
        txtStarTime = new javax.swing.JFormattedTextField();
        txtEndTime = new javax.swing.JFormattedTextField();
        lblCheckout = new javax.swing.JLabel();
        pnlCheckoutContainer = new javax.swing.JPanel();
        lblCheckoutName = new javax.swing.JLabel();
        txtCheckoutName = new javax.swing.JTextField();
        lblBranches = new javax.swing.JLabel();
        cmbBranches = new javax.swing.JComboBox<>();
        btnDispose = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        lblHeadline.setText("Nuevo Turno y Caja");

        lblShift.setText("Turno");

        lblShiftName.setText("Nombre");

        txtShiftName.setPreferredSize(new java.awt.Dimension(256, 22));

        lblStartTime.setText("Hora de Inicio");

        lblEndTime.setText("Hora de Finalizacion");

        javax.swing.GroupLayout pnlShiftContainerLayout = new javax.swing.GroupLayout(pnlShiftContainer);
        pnlShiftContainer.setLayout(pnlShiftContainerLayout);
        pnlShiftContainerLayout.setHorizontalGroup(
            pnlShiftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShiftContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlShiftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtShiftName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShiftName)
                    .addGroup(pnlShiftContainerLayout.createSequentialGroup()
                        .addGroup(pnlShiftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStartTime)
                            .addComponent(txtStarTime, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlShiftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEndTime)
                            .addComponent(txtEndTime))))
                .addGap(16, 16, 16))
        );
        pnlShiftContainerLayout.setVerticalGroup(
            pnlShiftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShiftContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblShiftName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtShiftName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlShiftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStartTime)
                    .addComponent(lblEndTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlShiftContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStarTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblCheckout.setText("Caja");

        lblCheckoutName.setText("Nombre");

        txtCheckoutName.setPreferredSize(new java.awt.Dimension(128, 22));

        lblBranches.setText("Sucursal");

        cmbBranches.setEditable(true);

        javax.swing.GroupLayout pnlCheckoutContainerLayout = new javax.swing.GroupLayout(pnlCheckoutContainer);
        pnlCheckoutContainer.setLayout(pnlCheckoutContainerLayout);
        pnlCheckoutContainerLayout.setHorizontalGroup(
            pnlCheckoutContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCheckoutContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlCheckoutContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBranches)
                    .addComponent(txtCheckoutName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCheckoutName)
                    .addComponent(cmbBranches, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        pnlCheckoutContainerLayout.setVerticalGroup(
            pnlCheckoutContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCheckoutContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblCheckoutName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCheckoutName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBranches)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBranches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        btnDispose.setText("Cancelar");
        btnDispose.setContentAreaFilled(false);
        btnDispose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisposeActionPerformed(evt);
            }
        });

        btnAdd.setText("Guardar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setText("Registra un nuevo turno laboral y asocia una caja para el control de efectivo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblHeadline)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnDispose)
                            .addGap(3, 3, 3)
                            .addComponent(btnAdd))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pnlShiftContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblShift))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCheckout)
                                .addComponent(pnlCheckoutContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShift)
                    .addComponent(lblCheckout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCheckoutContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlShiftContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDispose)
                    .addComponent(btnAdd))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new ShiftEvent.GetBranchListEvent());
    }

    @Override
    public void setBranchList(List<Branch> branches) {
        branches.removeFirst();
        branches.forEach(branch -> cmbBranches.addItem(branch));
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisposeActionPerformed
        dispose();
    }//GEN-LAST:event_btnDisposeActionPerformed

    private void add() {
        Response<Void> response = form.isValid();
        response.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                Branch branch = (Branch) cmbBranches.getSelectedItem();
                checkout.setBranchId(branch.getId());
                viewModel.onEvent(new ShiftEvent.AddShiftEvent(checkout, shift));
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDispose;
    private javax.swing.JComboBox<Branch> cmbBranches;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBranches;
    private javax.swing.JLabel lblCheckout;
    private javax.swing.JLabel lblCheckoutName;
    private javax.swing.JLabel lblEndTime;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblShift;
    private javax.swing.JLabel lblShiftName;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JPanel pnlCheckoutContainer;
    private javax.swing.JPanel pnlShiftContainer;
    private javax.swing.JTextField txtCheckoutName;
    private javax.swing.JFormattedTextField txtEndTime;
    private javax.swing.JTextField txtShiftName;
    private javax.swing.JFormattedTextField txtStarTime;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(pnlShiftContainer, "container");
            Styles.setStyleTo(pnlCheckoutContainer, "container");

            Styles.setStyleTo(lblHeadline, "headline.small");

            Styles.setStyleTo(lblShift, "label.small");

            Styles.setStyleTo(lblShiftName, "label.small");

            Placeholder.setPlaceholderTo(txtShiftName, "Turno 1, Turno Mañana");

            Styles.setStyleTo(lblStartTime, "label.small");

            startPicker.setOrientation(SwingConstants.HORIZONTAL);
            startPicker.setEditor(txtStarTime);
            startPicker.setEditorIcon(null);
            startPicker.set24HourView(true);

            Styles.setStyleTo(lblEndTime, "label.small");

            endPicker.setOrientation(SwingConstants.HORIZONTAL);
            endPicker.setEditor(txtEndTime);
            endPicker.setEditorIcon(null);
            endPicker.set24HourView(true);

            Styles.setStyleTo(lblCheckout, "label.small");

            Styles.setStyleTo(lblCheckoutName, "label.small");

            Placeholder.setPlaceholderTo(txtCheckoutName, "Caja 1");

            Styles.setStyleTo(lblBranches, "label.small");

            Styles.setStyleTo(btnDispose, "button.text");

            inputs.add(txtStarTime);
            inputs.add(txtEndTime);
            inputs.add(txtCheckoutName);

        }

        public void initializeListeners() {

            txtShiftName.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != ' ')
                        e.consume();
                }

            });

            txtStarTime.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e))
                        startPicker.showPopup();
                }

            });

            txtEndTime.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e))
                        endPicker.showPopup();
                }

            });

            txtCheckoutName.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != ' ')
                        e.consume();
                }

            });

            cmbBranches.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    e.consume();
                }
                @Override
                public void keyTyped(KeyEvent e) {
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

        public Response<Void> isValid() {

            try {

                shift.setName(isValidName(txtShiftName.getText()));

                shift.setStartTime(isValidTime(txtStarTime.getValue()));

                shift.setEndTime(isValidTime(txtEndTime.getValue()));

                checkout.setName(isValidName(txtCheckoutName.getText()));

                return new Response.Success<>(null);

            } catch (Exception e) {

                return new Response.Failure<>(e);

            }

        }

        private String isValidName(String text) throws BlankNameException, InvalidNameException {
            if (isBlank(text))
                throw new BlankNameException();
            if (text.chars().anyMatch(c -> !Character.isAlphabetic(c) && !Character.isDigit(c) && c != ' '))
                throw new InvalidNameException();
            return text.trim();
        }

        private LocalTime isValidTime(Object time) throws InvalidTimeException {
            if (time == null)
                throw new InvalidTimeException();
            return Time.valueOf(time);
        }

        private boolean isBlank(String input) {
            return input == null || input.trim().isEmpty();
        }

    }

}