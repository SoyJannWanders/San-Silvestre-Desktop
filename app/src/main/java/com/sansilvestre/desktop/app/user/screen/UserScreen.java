package com.sansilvestre.desktop.app.user.screen;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.domain.model.Branch;
import com.sansilvestre.desktop.app.util.data.sync.AsyncTaskManager;
import com.sansilvestre.desktop.app.util.exception.NoItemSelectedException;
import com.sansilvestre.desktop.app.util.exception.UserActionNotAllowedException;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.user.domain.model.User;
import com.sansilvestre.desktop.app.user.domain.util.Salary;
import com.sansilvestre.desktop.app.user.module.UserModule;
import com.sansilvestre.desktop.app.util.log.Console;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class UserScreen extends javax.swing.JPanel implements UserViewController {

    private final UserViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcuts shortcuts = new Shortcuts();

    private List<User> users;

    private List<Role> roles;
    private Map<Integer, Branch> branches;

    private final CountDownLatch screenSynchronizer = new CountDownLatch(2);
    private final CountDownLatch listenersSynchronizer = new CountDownLatch(1);

    private final JPopupMenu popupEmployeeActions = new JPopupMenu();

    private final JMenuItem mniCalculateSalary = new JMenuItem("Calcular sueldo");
    private final JMenuItem mniIncreaseSalary = new JMenuItem("Aumentar sueldo");
    private final JMenuItem mniUpdateEmployee = new JMenuItem("Editar");
    private final JMenuItem mniDeleteEmployee = new JMenuItem("Eliminar");

    private final JPopupMenu popupOtherUserActions = new JPopupMenu();
    private final JMenuItem mniUpdateOtherUser = new JMenuItem("Editar");
    private final JMenuItem mniDeleteOtherUser = new JMenuItem("Eliminar");

    public UserScreen() {
        viewModel = UserModule.getInstance().provideUserViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblBody = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblEmployees = new javax.swing.JLabel();
        lblQuantityEmployees = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblSalaries = new javax.swing.JLabel();
        lblTotalSalaries = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cmbRole = new javax.swing.JComboBox<>();
        cmbBranch = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnUpdateUsersSalaries = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pnlDetail = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblEnteredName = new javax.swing.JLabel();
        lblEnteredRole = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(768, 640));

        lblHeadline.setText("Gestión de Usuarios");

        lblBody.setText("Administra los perfiles y permisos de los usuarios");

        jPanel1.setPreferredSize(new java.awt.Dimension(231, 82));

        lblEmployees.setText("Empleados");

        lblQuantityEmployees.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuantityEmployees)
                    .addComponent(lblEmployees))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblEmployees)
                .addGap(6, 6, 6)
                .addComponent(lblQuantityEmployees)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(231, 82));

        lblSalaries.setText("Costos Salariales");

        lblTotalSalaries.setText("$ 0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalSalaries)
                    .addComponent(lblSalaries))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblSalaries)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalSalaries)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        txtSearch.setPreferredSize(new java.awt.Dimension(160, 22));

        cmbRole.setEditable(true);
        cmbRole.setPreferredSize(new java.awt.Dimension(160, 22));

        cmbBranch.setEditable(true);
        cmbBranch.setPreferredSize(new java.awt.Dimension(160, 22));

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Clave", "Salario", "Cargo", "Sucursal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsers.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblUsers);
        if (tblUsers.getColumnModel().getColumnCount() > 0) {
            tblUsers.getColumnModel().getColumn(0).setMinWidth(64);
            tblUsers.getColumnModel().getColumn(0).setPreferredWidth(64);
            tblUsers.getColumnModel().getColumn(0).setMaxWidth(64);
            tblUsers.getColumnModel().getColumn(1).setPreferredWidth(128);
            tblUsers.getColumnModel().getColumn(2).setPreferredWidth(128);
            tblUsers.getColumnModel().getColumn(3).setMinWidth(96);
            tblUsers.getColumnModel().getColumn(3).setPreferredWidth(96);
            tblUsers.getColumnModel().getColumn(3).setMaxWidth(96);
            tblUsers.getColumnModel().getColumn(4).setMinWidth(96);
            tblUsers.getColumnModel().getColumn(4).setPreferredWidth(96);
            tblUsers.getColumnModel().getColumn(4).setMaxWidth(96);
            tblUsers.getColumnModel().getColumn(5).setMinWidth(128);
            tblUsers.getColumnModel().getColumn(5).setPreferredWidth(128);
            tblUsers.getColumnModel().getColumn(5).setMaxWidth(128);
            tblUsers.getColumnModel().getColumn(6).setMinWidth(96);
            tblUsers.getColumnModel().getColumn(6).setPreferredWidth(96);
            tblUsers.getColumnModel().getColumn(6).setMaxWidth(96);
        }

        btnUpdateUsersSalaries.setText("Aumento");
        btnUpdateUsersSalaries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUsersSalariesActionPerformed(evt);
            }
        });

        btnAdd.setText("Añadir nuevo usuario");
        btnAdd.setContentAreaFilled(false);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel4.setText("¿Necesitas un nuevo usuario?");

        pnlDetail.setPreferredSize(new java.awt.Dimension(718, 82));

        btnUpdate.setText("Editar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblName.setText("Nombre del Usuario");

        lblRole.setText("Cargo del Usuario");

        lblEnteredName.setText("-");

        lblEnteredRole.setText("-");

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblEnteredName))
                .addGap(64, 64, 64)
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnteredRole)
                    .addComponent(lblRole))
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
                            .addComponent(lblName)
                            .addComponent(lblRole))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEnteredName)
                            .addComponent(lblEnteredRole))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(231, 82));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(btnAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdateUsersSalaries))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                            .addComponent(pnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBody)
                                    .addComponent(lblHeadline)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline)
                .addGap(6, 6, 6)
                .addComponent(lblBody)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBranch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateUsersSalaries))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        shortcuts.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new UserEvent.GetRoleListEvent());
        viewModel.onEvent(new UserEvent.GetBranchListEvent());
        viewModel.onEvent(new UserEvent.GetUserListEvent());
        initializeListeners();
    }

    @Override
    public void setRoleList(List<Role> roles) {
        this.roles = roles;
        roles.forEach(role -> cmbRole.addItem(role));
        screenSynchronizer.countDown();
    }

    @Override
    public void setBranchMap(Map<Integer, Branch> branches) {
        this.branches = branches;
        branches.forEach((id, branch) -> cmbBranch.addItem(branch));
        screenSynchronizer.countDown();
    }

    @Override
    public void setUserList(List<User> users) {

        try {
            screenSynchronizer.await();
        } catch (InterruptedException e) {
            Console.warn(Console.WarnCode.W001, "ERROR: Screen Synchronizer");
        }

        this.users = users;

        DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
        model.setRowCount(0);

        double salary = 0;

        boolean isFirst = true;

        for (User user: users) {

            salary = salary + user.getSalary();

            model.addRow(new Object[] {
                    user.getUserId(),
                    user.getName(),
                    user.getSurname(),
                    user.getPassword().isEmpty() ? "Ninguna" : user.getPassword(),
                    user.getSalary() == 0 ? "No posee" : Currency.format(user.getSalary()),
                    user.getRole(),
                    branches.get(user.getBranchId()).getName()
            });

            if (isFirst) {
                tblUsers.setRowSelectionInterval(0, 0);
                setUser();
            }

            isFirst = false;

        }

        lblQuantityEmployees.setText(String.valueOf(users.size()));
        lblTotalSalaries.setText(Salary.calculate(salary));

        listenersSynchronizer.countDown();

    }

    private void setUser() {

        int row = tblUsers.getSelectedRow();

        if (row > -1) {
            User user = users.get(row);
            lblEnteredName.setText(user.getCompleteName());
            lblEnteredRole.setText(user.getRole().toString());
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
        addUser();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateUsersSalariesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUsersSalariesActionPerformed
        updateUserSalaries();
    }//GEN-LAST:event_btnUpdateUsersSalariesActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void addUser() {
        NavigationController.getInstance().navigate(NavigationController.Route.ADD_USER_SCREEN, new NavigationData(
                new Object[] { roles, branches }, new Class[] { List.class, List.class }
        ));
    }

    private void update() {
        try {
            int row = tblUsers.getSelectedRow();
            if (row > -1) {
                NavigationController.getInstance().navigate(NavigationController.Route.UPDATE_USER_SCREEN, new NavigationData(
                        new Object[] { roles, branches, users.get(row) }, new Class[] { List.class, List.class, User.class }
                ));
            } else {
                throw new NoItemSelectedException();
            }
        } catch (NoItemSelectedException e) {
            ViewStateController.getInstance().isFailure(e);
        }
    }

    private void updateUserSalary() {
        try {
            int row = tblUsers.getSelectedRow();
            if (row > -1) {
                User user = users.get(row);
                if (user.getRole() == Role.EMPLOYEE) {
                    NavigationController.getInstance().navigate(NavigationController.Route.UPDATE_USER_SALARY_SCREEN, new NavigationData(
                            new Object[] { user.getUserId(), user.getSalary() }, new Class[] { Integer.class, Double.class }
                    ));
                } else {
                    throw new UserActionNotAllowedException();
                }
            } else {
                throw new NoItemSelectedException();
            }
        } catch (Exception e) {
            ViewStateController.getInstance().isFailure(e);
        }
    }

    private void updateUserSalaries() {
        NavigationController.getInstance().navigate(NavigationController.Route.UPDATE_USERS_SALARIES_SCREEN, new NavigationData(
                new Object[] { branches }, new Class[] { Map.class }
        ));
    }

    private void calculateSalary() {
        int row = tblUsers.getSelectedRow();
        if (row != -1) {
            User user = users.get(row);
            NavigationController.getInstance().navigate(NavigationController.Route.CALCULATE_USER_SALARY_SCREEN, new NavigationData(
                    new Object[] { user.getCompleteName(), user.getSalary() }, new Class[] { String.class, Double.class }
            ));
        }
    }

    private void delete() {
        try {
            int row = tblUsers.getSelectedRow();
            if (row > -1) {
                Runnable task = () -> {
                    int id = users.get(row).getUserId();
                    viewModel.onEvent(new UserEvent.DeleteUserByIdEvent(id));
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateUsersSalaries;
    private javax.swing.JComboBox<Branch> cmbBranch;
    private javax.swing.JComboBox<Role> cmbRole;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblEmployees;
    private javax.swing.JLabel lblEnteredName;
    private javax.swing.JLabel lblEnteredRole;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblQuantityEmployees;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSalaries;
    private javax.swing.JLabel lblTotalSalaries;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(jPanel1, "container");
            Styles.setStyleTo(jPanel4, "container");
            Styles.setStyleTo(pnlDetail, "container");
            Styles.setStyleTo(jPanel5, "container");

            Styles.setStyleTo(lblHeadline, "headline.large");

            Styles.setStyleTo(lblBody, "body.small");

            Styles.setStyleTo(lblQuantityEmployees, "title.small");

            Styles.setStyleTo(lblTotalSalaries, "title.small");

            Styles.setStyleTo(txtSearch, "field.plain");
            Placeholder.setPlaceholderTo(txtSearch, "Buscar...");

            Styles.setStyleTo(cmbRole, "combo.box.variant");

            Styles.setStyleTo(cmbBranch, "combo.box.variant");

            popupEmployeeActions.add(mniCalculateSalary);
            popupEmployeeActions.add(mniIncreaseSalary);
            popupEmployeeActions.add(new JSeparator());
            popupEmployeeActions.add(mniUpdateEmployee);
            popupEmployeeActions.add(mniDeleteEmployee);

            mniUpdateEmployee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
            mniDeleteEmployee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

            popupOtherUserActions.add(mniUpdateOtherUser);
            popupOtherUserActions.add(mniDeleteOtherUser);

            mniUpdateOtherUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
            mniDeleteOtherUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

            TableRenderer renderer = new TableRenderer();
            tblUsers.getColumnModel().getColumn(0).setCellRenderer(renderer);
            tblUsers.getColumnModel().getColumn(1).setCellRenderer(renderer);
            tblUsers.getColumnModel().getColumn(2).setCellRenderer(renderer);
            tblUsers.getColumnModel().getColumn(3).setCellRenderer(renderer);
            tblUsers.getColumnModel().getColumn(4).setCellRenderer(renderer);
            tblUsers.getColumnModel().getColumn(5).setCellRenderer(renderer);
            tblUsers.getColumnModel().getColumn(6).setCellRenderer(renderer);

            Styles.setStyleTo(lblEnteredName, "title.small");

            Styles.setStyleTo(lblEnteredRole, "title.small");

            Styles.setStyleTo(btnAdd, "button.text");
            Styles.setStyleTo(btnUpdate, "button.outline");
            Styles.setStyleTo(btnUpdateUsersSalaries, "button.outline");
            Styles.setStyleTo(btnDelete, "button.outline.danger");

        }

        public void initializeListeners() {

            mniCalculateSalary.addActionListener(e -> calculateSalary());

            mniIncreaseSalary.addActionListener(e -> updateUserSalary());

            mniUpdateEmployee.addActionListener(e -> update());

            mniDeleteEmployee.addActionListener(e -> delete());

            mniUpdateOtherUser.addActionListener(e -> update());

            mniDeleteOtherUser.addActionListener(e -> delete());

            txtSearch.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && c != ' ')
                        e.consume();
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    String search = txtSearch.getText();
                    if (search.isEmpty())
                        viewModel.onEvent(new UserEvent.GetUserListEvent());
                    else
                        viewModel.onEvent(new UserEvent.GetUserListBySearchEvent(search));
                }

            });

            cmbRole.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    e.consume();
                }

            });

            cmbRole.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Role role = (Role) cmbRole.getSelectedItem();
                    viewModel.onEvent(new UserEvent.GetUserListByRoleEvent(role));
                }
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

            cmbBranch.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Branch branch = (Branch) cmbBranch.getSelectedItem();
                    viewModel.onEvent(new UserEvent.GetUserListByBranchIDEvent(branch.getId()));
                }
            });

            tblUsers.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    setUser();
                }
            });

            tblUsers.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        int row = tblUsers.getSelectedRow();
                        if (row != -1)
                            if (users.get(row).getRole() == Role.EMPLOYEE)
                                popupEmployeeActions.show(tblUsers, e.getX(), e.getY());
                            else
                                popupOtherUserActions.show(tblUsers, e.getX(), e.getY());
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

            if (column == 0 || column == 5 || column == 6) {
                return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }

            if (column == 1 || column == 2 || column == 3) {
                setHorizontalAlignment(SwingConstants.LEFT);
            }

            if (column == 4) {
                setHorizontalAlignment(SwingConstants.RIGHT);
            }

            return component;

        }
    }

    private class Shortcuts {

        public void configure(JComponent component) {

            InputMap input = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

            final String INCREASE_USER_SALARY = "increaseUserSalary";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), INCREASE_USER_SALARY);
            actionMap.put(INCREASE_USER_SALARY, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateUserSalary();
                }
            });

            final String INCREASE_ALL_USERS_SALARIES = "increaseAllUsersSalaries";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, InputEvent.CTRL_DOWN_MASK), INCREASE_ALL_USERS_SALARIES);
            actionMap.put(INCREASE_ALL_USERS_SALARIES, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateUserSalaries();
                }
            });

            final String ADD = "add";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK), ADD);
            actionMap.put(ADD, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addUser();
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

            final String THREAD_STATUS = "threadStatus";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.ALT_DOWN_MASK), THREAD_STATUS);
            actionMap.put(THREAD_STATUS, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AsyncTaskManager.log();
                }
            });

        }

    }

}