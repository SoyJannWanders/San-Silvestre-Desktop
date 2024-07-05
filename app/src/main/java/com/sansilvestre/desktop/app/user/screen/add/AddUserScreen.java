package com.sansilvestre.desktop.app.user.screen.add;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.util.exception.*;
import com.sansilvestre.desktop.app.util.exception.form.*;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.user.screen.UserEvent;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.formatter.Phone;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.user.module.UserModule;
import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.domain.util.exception.*;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddUserScreen extends javax.swing.JPanel implements AddUserViewController {

    private final AddUserViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Form form = new Form();

    private final List<Role> roles;
    private final Map<Integer, Branch> branches;

    private final List<JComponent> inputs = new ArrayList<>();

    public AddUserScreen(List<Role> roles, Map<Integer, Branch> branches) {
        viewModel = UserModule.getInstance().provideAddUserViewModel();
        this.roles = roles;
        this.branches = branches;
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        lblRole = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox<>();
        lblPassword = new javax.swing.JLabel();
        pwdPassword = new javax.swing.JPasswordField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblBranch = new javax.swing.JLabel();
        cmbBranch = new javax.swing.JComboBox<>();
        lblSalary = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        pnlDetail = new javax.swing.JPanel();
        lblEnteredName = new javax.swing.JLabel();
        lblEnteredRole = new javax.swing.JLabel();
        lblSalaryForWeek = new javax.swing.JLabel();
        lblEnteredSalary = new javax.swing.JLabel();
        btnSignUp = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(352, 545));

        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Nuevo Usuario");

        lblName.setText("Nombre");

        txtName.setPreferredSize(new java.awt.Dimension(136, 22));

        lblSurname.setText("Apellido");

        txtSurname.setPreferredSize(new java.awt.Dimension(136, 22));

        lblRole.setText("Cargo");

        cmbRole.setEditable(true);

        lblPassword.setText("Contraseña");

        pwdPassword.setEnabled(false);
        pwdPassword.setPreferredSize(new java.awt.Dimension(136, 22));

        lblPhone.setText("Telefono");

        txtPhone.setPreferredSize(new java.awt.Dimension(136, 22));

        lblBranch.setText("Sucursal");

        cmbBranch.setEditable(true);
        cmbBranch.setPreferredSize(new java.awt.Dimension(136, 22));

        lblSalary.setText("Salario");

        txtSalary.setPreferredSize(new java.awt.Dimension(288, 22));

        lblEnteredName.setText("Nombre del Empleado");
        lblEnteredName.setMaximumSize(new java.awt.Dimension(152, 16));
        lblEnteredName.setPreferredSize(new java.awt.Dimension(152, 16));

        lblEnteredRole.setText("Sin Cargo");

        lblSalaryForWeek.setText("Sueldo/Semana");

        lblEnteredSalary.setText("$ 0,00");

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEnteredSalary)
                            .addComponent(lblSalaryForWeek))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addComponent(lblEnteredName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEnteredRole)
                        .addGap(16, 16, 16))))
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnteredName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnteredRole))
                .addGap(16, 16, 16)
                .addComponent(lblSalaryForWeek)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEnteredSalary)
                .addGap(16, 16, 16))
        );

        btnSignUp.setText("Registrar");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSignUp))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalary)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName)
                                        .addComponent(lblRole))
                                    .addGap(16, 16, 16)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblSurname)
                                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPassword)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblPhone)
                                        .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblBranch)))
                                .addComponent(pnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(cmbBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblSurname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSurname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(lblBranch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBranch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSalary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(pnlDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignUp)
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

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        add();
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void add() {
        Response<User> response = form.isValid();
        response.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<User> success) {
                viewModel.onEvent(new UserEvent.AddUserEvent(success.getObject()));
            }

            @Override
            public void visitFailure(Response.Failure<User> failure) {
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
    private javax.swing.JButton btnSignUp;
    private javax.swing.JComboBox<Branch> cmbBranch;
    private javax.swing.JComboBox<Role> cmbRole;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblEnteredName;
    private javax.swing.JLabel lblEnteredRole;
    private javax.swing.JLabel lblEnteredSalary;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblSalaryForWeek;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(pnlDetail, "container");

            Styles.setStyleTo(lblHeadline, "headline.small");

            Styles.setStyleTo(lblName, "label.small");

            Placeholder.setPlaceholderTo(txtName, "Acosta");
            
            Styles.setStyleTo(lblSurname, "label.small");

            Placeholder.setPlaceholderTo(txtSurname, "Silvetti");

            Styles.setStyleTo(lblRole, "label.small");

            roles.forEach(role -> cmbRole.addItem(role));

            Styles.setStyleTo(lblPassword, "label.small");

            Styles.setStyleTo(lblPhone, "label.small");

            Placeholder.setPlaceholderTo(txtPhone, "(123) 4 567890");

            Styles.setStyleTo(lblBranch, "label.small");

            branches.forEach((integer, branch) -> cmbBranch.addItem(branch));

            Styles.setStyleTo(lblSalary, "label.small");

            Placeholder.setPlaceholderTo(txtSalary, "$ 0");

            Styles.setStyleTo(lblEnteredName, "label.medium");

            Styles.setStyleTo(lblEnteredRole, "label.medium");

            Styles.setStyleTo(lblSalaryForWeek, "body.small");

            Styles.setStyleTo(lblEnteredSalary, "title.large");

            Styles.setStyleTo(btnCancel, "button.outline");

            inputs.add(txtSurname);
            inputs.add(pwdPassword);
            inputs.add(txtPhone);
            inputs.add(txtSalary);

        }

        private void initializeListeners() {

            txtName.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && c != ' ')
                        e.consume();
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    final String surname = txtSurname.getText().trim();
                    final String name = txtName.getText().trim();
                    if (surname.isEmpty())
                        lblEnteredName.setText(name);
                    else
                        lblEnteredName.setText(name.concat(' ' + surname));
                }

            });

            txtSurname.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && c != ' ')
                        e.consume();
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    final String name = txtName.getText().trim();
                    final String surname = txtSurname.getText().trim();
                    if (name.isEmpty())
                        lblEnteredName.setText(surname);
                    else
                        lblEnteredName.setText(name.concat(' ' + surname));
                }

            });

            cmbRole.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

            });

            cmbRole.addItemListener(e -> {
                Role role = (Role) cmbRole.getSelectedItem();
                if (role != null) {
                    lblEnteredRole.setText(role.toString());
                    if (role != Role.EMPLOYEE) {
                        Placeholder.setPlaceholderTo(pwdPassword, "2wsxzaq1!");
                        Placeholder.setPlaceholderTo(txtSalary, "");
                        lblEnteredSalary.setText("No posee");
                        pwdPassword.setEnabled(true);
                        txtSalary.setEnabled(false);
                    } else {
                        pwdPassword.setText("");
                        Placeholder.setPlaceholderTo(pwdPassword, "");
                        Placeholder.setPlaceholderTo(txtSalary, "$ 0");
                        lblEnteredSalary.setText("$ 0");
                        txtSalary.setEnabled(true);
                        pwdPassword.setEnabled(false);
                    }
                }
            });

            pwdPassword.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (c == ' ')
                        e.consume();
                }

            });

            txtPhone.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c) || txtPhone.getText().length() > 13)
                        e.consume();
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    txtPhone.setText(Phone.formatPhoneNumber(txtPhone.getText()));
                }

            });


            cmbBranch.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

            });

            txtSalary.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    String in = txtSalary.getText();
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
                    String in = txtSalary.getText();
                    double salary = Currency.toDouble(in);
                    txtSalary.setText(Currency.format(in));
                    lblEnteredSalary.setText(Currency.format(salary));
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

        public Response<User> isValid() {

            try {

                final String name = isValidName(txtName.getText());

                final String surname = isValidSurname(txtSurname.getText());

                final Role role = (Role) cmbRole.getSelectedItem();

                final String password = isValidPasswordIfNeeded(role, pwdPassword.getPassword());

                final String phone = isValidPhone(txtPhone.getText());

                final int branchId = isValidRoleAndBranch(role, (Branch) cmbBranch.getSelectedItem());

                final double salary = validateSalaryIfNeeded(role, txtSalary.getText());

                return new Response.Success<>(new User(name, surname, password, phone, salary, role, branchId));

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

        private String isValidSurname(String text) throws BlankSurnameException, InvalidSurnameException {
            if (isBlank(text))
                throw new BlankSurnameException();
            if (text.chars().anyMatch(c -> !Character.isAlphabetic(c) && c != ' '))
                throw new InvalidSurnameException();
            return text.trim();
        }

        private String isValidPasswordIfNeeded(Role role, char[] chars) throws BlankPasswordException, InvalidPasswordException {
            String text = String.valueOf(chars);
            if (role != Role.EMPLOYEE && isBlank(text))
                throw new BlankPasswordException();
            if (text.chars().anyMatch(c -> c == ' '))
                throw new InvalidPasswordException();
            return text.trim();
        }

        private String isValidPhone(String text) throws BlankPhoneException, InvalidPhoneException {
            if (isBlank(text))
                throw new BlankPhoneException();
            if (text.chars().anyMatch(c -> !Character.isDigit(c) && c != '(' && c != ')' && c != ' '))
                throw new InvalidPhoneException();
            return text.trim();
        }

        private int isValidRoleAndBranch(Role role, Branch branch) throws LowRoleException {
            if (branch.getId() == 1 && (role == Role.EMPLOYEE || role == Role.MODERATOR))
                throw new LowRoleException();
            return branch.getId();
        }

        private double validateSalaryIfNeeded(Role role, String salary) throws InvalidSalaryInputException {
            if (role == Role.EMPLOYEE && isBlank(salary))
                throw new InvalidSalaryInputException();
            return Currency.toDouble(salary);
        }

        private boolean isBlank(String input) {
            return input == null || input.trim().isEmpty();
        }

    }

}