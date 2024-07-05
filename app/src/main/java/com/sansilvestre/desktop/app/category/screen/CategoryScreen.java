package com.sansilvestre.desktop.app.category.screen;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.branch.screen.BranchEvent;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.category.module.CategoryModule;
import com.sansilvestre.desktop.app.util.exception.NoItemSelectedException;
import com.sansilvestre.desktop.app.util.formatter.Percentage;
import com.sansilvestre.desktop.app.util.log.Console;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class CategoryScreen extends javax.swing.JPanel implements CategoryViewController {

    private final CategoryViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private List<Category> categories;

    private final JPopupMenu popupCategoryActions = new JPopupMenu();

    private final JMenuItem mniUpdateCategory = new JMenuItem("Editar");
    private final JMenuItem mniDeleteCategory = new JMenuItem("Eliminar");

    public CategoryScreen() {
        viewModel = CategoryModule.getInstance().provideCategoryViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblBody = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategories = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        pnlDetail = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblProfit = new javax.swing.JLabel();
        lblEnteredName = new javax.swing.JLabel();
        lblEnteredProfit = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(768, 640));

        lblHeadline.setText("Gestión de Categorias");

        lblBody.setText("Organiza tus productos de manera eficiente");

        txtSearch.setPreferredSize(new java.awt.Dimension(160, 22));

        tblCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "% Adicional"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategories.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCategories);
        if (tblCategories.getColumnModel().getColumnCount() > 0) {
            tblCategories.getColumnModel().getColumn(0).setMinWidth(64);
            tblCategories.getColumnModel().getColumn(0).setPreferredWidth(64);
            tblCategories.getColumnModel().getColumn(0).setMaxWidth(64);
            tblCategories.getColumnModel().getColumn(1).setPreferredWidth(256);
            tblCategories.getColumnModel().getColumn(2).setMinWidth(96);
            tblCategories.getColumnModel().getColumn(2).setPreferredWidth(96);
            tblCategories.getColumnModel().getColumn(2).setMaxWidth(96);
        }

        jLabel4.setText("¿No encuentras la categoría que buscas?");

        btnAdd.setText("Añadir nueva categoría");
        btnAdd.setContentAreaFilled(false);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        pnlDetail.setPreferredSize(new java.awt.Dimension(718, 82));

        btnUpdate.setText("Editar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblName.setText("Nombre de la Categoria");

        lblProfit.setText("Ganancia Adicional");

        lblEnteredName.setText("-");

        lblEnteredProfit.setText("-");

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
                    .addComponent(lblEnteredProfit)
                    .addComponent(lblProfit))
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
                            .addComponent(lblProfit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEnteredName)
                            .addComponent(lblEnteredProfit))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(0, 0, 0)
                                .addComponent(btnAdd))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblBody, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHeadline, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline)
                .addGap(6, 6, 6)
                .addComponent(lblBody)
                .addGap(32, 32, 32)
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
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
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new CategoryEvent.GetCategoryListEvent());
    }

    @Override
    public void setCategoryList(List<Category> categories) {

        this.categories = categories;

        DefaultTableModel model = (DefaultTableModel) tblCategories.getModel();
        model.setRowCount(0);

        boolean isFirst = true;

        for (Category category: categories) {

            model.addRow(new Object[] {
                    category.getId(),
                    category.getName(),
                    Percentage.format(category.getIncrease())
            });

            if (isFirst) {
                tblCategories.setRowSelectionInterval(0, 0);
                setCategory();
            }

            isFirst = false;

        }

    }

    private void setCategory() {
        int row = tblCategories.getSelectedRow();
        if (row > -1) {
            Category category = categories.get(row);
            lblEnteredName.setText(category.getName());
            lblEnteredProfit.setText(Percentage.format(category.getIncrease()));
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void add() {
        NavigationController.getInstance().navigate(NavigationController.Route.ADD_CATEGORY_SCREEN, null);
    }

    private void update() {
        try {
            int row = tblCategories.getSelectedRow();
            if (row > -1) {
                Category category = categories.get(row);
                NavigationController.getInstance().navigate(NavigationController.Route.UPDATE_CATEGORY_SCREEN, new NavigationData(
                        new Object[] { category }, new Class[] { Category.class }
                ));
            } else {
                throw new NoItemSelectedException();
            }
        } catch (NoItemSelectedException e) {
            ViewStateController.getInstance().isFailure(e);
        }
    }

    private void delete() {
        try {
            int row = tblCategories.getSelectedRow();
            if (row > -1) {
                Category category = categories.get(row);
                if (category.getId() == 1) {
                    Runnable requestPermission = () -> {
                        Runnable task = () -> {
                            int id = categories.get(row).getId();
                            viewModel.onEvent(new CategoryEvent.DeleteCategoryByIDEvent(id));
                        };
                        NavigationController.getInstance().navigate(NavigationController.Route.DELETE_SCREEN, new NavigationData(
                                new Object[] { task }, new Class[] { Runnable.class }
                        ));
                    };
                    NavigationController.getInstance().navigate(NavigationController.Route.DEVELOPMENT_SCREEN, new NavigationData(
                            new Object[] { requestPermission }, new Class[] { Runnable.class }
                    ));
                } else {
                    Runnable task = () -> {
                        int id = categories.get(row).getId();
                        viewModel.onEvent(new CategoryEvent.DeleteCategoryByIDEvent(id));
                    };
                    NavigationController.getInstance().navigate(NavigationController.Route.DELETE_SCREEN, new NavigationData(
                            new Object[] { task }, new Class[] { Runnable.class }
                    ));
                }
            } else {
                throw new NoItemSelectedException();
            }
        } catch (NoItemSelectedException e) {
            ViewStateController.getInstance().isFailure(e);
        }
    }

    @Override
    public void refresh() {
        viewModel.onEvent(new CategoryEvent.GetCategoryListEvent());
        txtSearch.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblEnteredName;
    private javax.swing.JLabel lblEnteredProfit;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProfit;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JTable tblCategories;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(pnlDetail, "container");

            Styles.setStyleTo(lblHeadline, "headline.large");

            Styles.setStyleTo(lblBody, "body.small");

            Styles.setStyleTo(txtSearch, "field.plain");
            Placeholder.setPlaceholderTo(txtSearch, "Buscar...");

            popupCategoryActions.add(mniUpdateCategory);
            popupCategoryActions.add(mniDeleteCategory);

            mniUpdateCategory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
            mniDeleteCategory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

            Styles.setStyleTo(lblEnteredName, "title.small");

            Styles.setStyleTo(lblEnteredProfit, "title.small");

            Styles.setStyleTo(btnAdd, "button.text");
            Styles.setStyleTo(btnUpdate, "button.outline");
            Styles.setStyleTo(btnDelete, "button.outline.danger");

        }

        public void initializeListeners() {

            mniUpdateCategory.addActionListener(e -> update());
            mniDeleteCategory.addActionListener(e -> delete());

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
                        viewModel.onEvent(new CategoryEvent.GetCategoryListEvent());
                    else
                        viewModel.onEvent(new CategoryEvent.GetCategoryListBySearchEvent(search));
                }

            });

            tblCategories.getSelectionModel().addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    setCategory();
                }
            });

            tblCategories.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        int row = tblCategories.getSelectedRow();
                        if (row > -1)
                            popupCategoryActions.show(tblCategories, e.getX(), e.getY());
                    }
                }

            });

        }

    }

    private class Shortcut {

        public void configure(JComponent component) {

            InputMap input = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

            final String SEARCH = "search";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), SEARCH);
            actionMap.put(SEARCH, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtSearch.requestFocus();
                }
            });

            final String ADD = "add";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK), ADD);
            actionMap.put(ADD, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    add();
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

            final String REFRESH = "refresh";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK), REFRESH);
            actionMap.put(REFRESH, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    refresh();
                }
            });

        }

    }

}