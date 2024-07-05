package com.sansilvestre.desktop.app.product.screen.add;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.category.domain.model.Category;
import com.sansilvestre.desktop.app.product.domain.model.Product;
import com.sansilvestre.desktop.app.product.domain.util.exception.InvalidBarcodeException;
import com.sansilvestre.desktop.app.product.domain.util.exception.InvalidSpentException;
import com.sansilvestre.desktop.app.product.screen.ProductEvent;
import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.util.formatter.Rounder;
import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.exception.form.BlankBarcodeException;
import com.sansilvestre.desktop.app.util.exception.form.BlankNameException;
import com.sansilvestre.desktop.app.util.exception.form.InvalidNameException;
import com.sansilvestre.desktop.app.util.exception.form.InvalidPercentageTaxException;
import com.sansilvestre.desktop.app.util.formatter.Percentage;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.product.module.ProductModule;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddProductScreen extends javax.swing.JPanel implements AddProductViewController {

    private final AddProductViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Form form = new Form();

    private final Map<Integer, Category> categories;

    private final List<JComponent> inputs = new ArrayList<>();

    public AddProductScreen(Map<Integer, Category> categories) {
        viewModel = ProductModule.getInstance().provideAddProductViewModel();
        this.categories = categories;
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        mainConteiner = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblBarcode = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        lblCategory = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        lblSpent = new javax.swing.JLabel();
        txtSpent = new javax.swing.JTextField();
        lblUnit = new javax.swing.JLabel();
        spnUnit = new javax.swing.JSpinner();
        lblStock = new javax.swing.JLabel();
        lblTaxes = new javax.swing.JLabel();
        txtTaxes = new javax.swing.JTextField();
        lblCost = new javax.swing.JLabel();
        lblEnteredCost = new javax.swing.JLabel();
        lblProfit = new javax.swing.JLabel();
        lblEnteredTaxes = new javax.swing.JLabel();
        lblEnteredProfit = new javax.swing.JLabel();
        lblEnteredTotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblEnteredPrice = new javax.swing.JLabel();
        spnStock = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        btnDispose = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(384, 555));

        lblHeadline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadline.setText("Nuevo Producto");
        lblHeadline.setPreferredSize(new java.awt.Dimension(320, 16));

        mainConteiner.setPreferredSize(new java.awt.Dimension(320, 348));

        lblName.setText("Producto");

        txtName.setPreferredSize(new java.awt.Dimension(288, 22));

        lblBarcode.setText("Codigo de Barras");

        txtBarcode.setPreferredSize(new java.awt.Dimension(136, 22));

        lblCategory.setText("Categoria");

        cmbCategory.setEditable(true);
        cmbCategory.setMaximumRowCount(5);
        cmbCategory.setPreferredSize(new java.awt.Dimension(136, 22));

        lblSpent.setText("Costo");

        txtSpent.setPreferredSize(new java.awt.Dimension(136, 22));

        lblUnit.setText("Unidades");

        lblStock.setText("Stock");

        lblTaxes.setText("Impuestos");

        txtTaxes.setPreferredSize(new java.awt.Dimension(136, 22));

        lblCost.setText("Precio C/Uni");

        lblEnteredCost.setText("$ 0");

        lblProfit.setText("Ganancias");

        lblEnteredTaxes.setText("0%");

        lblEnteredProfit.setText("$ 0");

        lblEnteredTotal.setText("$ 0");

        lblTotal.setText("Total");

        lblPrice.setText("Precio V/Uni");

        lblEnteredPrice.setText("$ 0");

        javax.swing.GroupLayout mainConteinerLayout = new javax.swing.GroupLayout(mainConteiner);
        mainConteiner.setLayout(mainConteinerLayout);
        mainConteinerLayout.setHorizontalGroup(
            mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainConteinerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainConteinerLayout.createSequentialGroup()
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEnteredTotal))
                    .addGroup(mainConteinerLayout.createSequentialGroup()
                        .addComponent(lblPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEnteredPrice))
                    .addGroup(mainConteinerLayout.createSequentialGroup()
                        .addComponent(lblProfit)
                        .addGap(4, 4, 4)
                        .addComponent(lblEnteredTaxes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEnteredProfit))
                    .addGroup(mainConteinerLayout.createSequentialGroup()
                        .addComponent(lblCost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEnteredCost))
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainConteinerLayout.createSequentialGroup()
                        .addComponent(txtSpent, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(spnUnit))
                    .addGroup(mainConteinerLayout.createSequentialGroup()
                        .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainConteinerLayout.createSequentialGroup()
                                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(mainConteinerLayout.createSequentialGroup()
                                        .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(88, 88, 88))
                                    .addGroup(mainConteinerLayout.createSequentialGroup()
                                        .addComponent(spnStock)
                                        .addGap(16, 16, 16)))
                                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTaxes)
                                    .addComponent(txtTaxes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblName)
                            .addGroup(mainConteinerLayout.createSequentialGroup()
                                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBarcode)
                                    .addComponent(lblSpent))
                                .addGap(16, 16, 16)
                                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUnit)
                                    .addComponent(lblCategory)
                                    .addComponent(cmbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        mainConteinerLayout.setVerticalGroup(
            mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainConteinerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBarcode)
                    .addComponent(lblCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSpent)
                    .addComponent(lblUnit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSpent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStock)
                    .addComponent(lblTaxes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTaxes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCost)
                    .addComponent(lblEnteredCost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfit)
                    .addComponent(lblEnteredProfit)
                    .addComponent(lblEnteredTaxes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnteredTotal)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(lblEnteredPrice))
                .addGap(16, 16, 16))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDispose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd))
                    .addComponent(lblHeadline, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainConteiner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(mainConteiner, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDispose))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
    }

    private void setValues() {

        int units = (int) spnUnit.getValue();

        double spent = Currency.toDouble(txtSpent.getText());

        double spendPerUnit = spent / units;

        lblEnteredCost.setText(Currency.format(spendPerUnit));

        double taxes = Percentage.toDouble(txtTaxes.getText());

        Category category = (Category) cmbCategory.getSelectedItem();

        double totalPercentageTax = Setting.getInstance().getPercentageProfit() + category.getIncrease() + taxes;
        lblEnteredTaxes.setText(Percentage.format(totalPercentageTax));

        double profit = spendPerUnit * (totalPercentageTax / 100);
        lblEnteredProfit.setText(Currency.format(profit));

        double total = spendPerUnit + profit;
        lblEnteredTotal.setText(Currency.format(total));

        double price = Rounder.round(total);
        lblEnteredPrice.setText(Currency.format(price));

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisposeActionPerformed
        dispose();
    }//GEN-LAST:event_btnDisposeActionPerformed

    private void add() {
        Response<Product> response = form.isValid();
        response.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Product> success) {
                viewModel.onEvent(new ProductEvent.AddProductEvent(success.getObject()));
            }

            @Override
            public void visitFailure(Response.Failure<Product> failure) {
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
    private javax.swing.JComboBox<Category> cmbCategory;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblEnteredCost;
    private javax.swing.JLabel lblEnteredPrice;
    private javax.swing.JLabel lblEnteredProfit;
    private javax.swing.JLabel lblEnteredTaxes;
    private javax.swing.JLabel lblEnteredTotal;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProfit;
    private javax.swing.JLabel lblSpent;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTaxes;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUnit;
    private javax.swing.JPanel mainConteiner;
    private javax.swing.JSpinner spnStock;
    private javax.swing.JSpinner spnUnit;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSpent;
    private javax.swing.JTextField txtTaxes;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(mainConteiner, "container");

            Styles.setStyleTo(lblHeadline, "headline.small");

            Styles.setStyleTo(lblName, "label.small");

            Placeholder.setPlaceholderTo(txtName, "Coca Premiun");

            Styles.setStyleTo(lblBarcode, "label.small");

            Placeholder.setPlaceholderTo(txtBarcode, "AB1234567890");

            Styles.setStyleTo(lblCategory, "label.small");

            categories.forEach((id, category) -> cmbCategory.addItem(category));

            Styles.setStyleTo(lblSpent, "label.small");

            Placeholder.setPlaceholderTo(txtSpent, "$ 0");

            Styles.setStyleTo(lblUnit, "label.small");

            spnUnit.setValue(1);

            Styles.setStyleTo(lblStock, "label.small");

            spnStock.setValue(1);

            Styles.setStyleTo(lblTaxes, "label.small");

            Placeholder.setPlaceholderTo(txtTaxes, "0%");

            Styles.setStyleTo(lblPrice, "label.medium");

            lblEnteredTaxes.setText(Percentage.format(Setting.getInstance().getPercentageProfit()));

            Styles.setStyleTo(lblEnteredPrice, "label.medium");

            Styles.setStyleTo(btnDispose, "button.text");

            inputs.add(txtBarcode);
            inputs.add(txtSpent);
            inputs.add(spnUnit);
            inputs.add(spnStock);
            inputs.add(txtTaxes);

        }

        public void initializeListeners() {

            txtName.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != ' ' && c != '-')
                        e.consume();
                }

            });

            txtBarcode.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isAlphabetic(c) && !Character.isDigit(c))
                        e.consume();
                }

            });

            cmbCategory.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

            });

            txtSpent.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    String in = txtSpent.getText();
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
                    setValues();
                    txtSpent.setText(Currency.format(txtSpent.getText()));
                }

            });

            ((JSpinner.DefaultEditor) spnUnit.getEditor()).getTextField().addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c))
                        e.consume();
                }

            });

            spnUnit.addChangeListener(e -> {
                int unit = (int) spnUnit.getValue();
                if (unit < 1)
                    spnUnit.setValue(1);
                setValues();
            });

            ((JSpinner.DefaultEditor) spnStock.getEditor()).getTextField().addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c))
                        e.consume();
                }

            });

            spnStock.addChangeListener(e -> {
                int stock = (int) spnStock.getValue();
                if (stock < 1)
                    spnStock.setValue(1);
            });

            txtTaxes.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    txtTaxes.setText(Percentage.removeFormat(txtTaxes.getText()));
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    String in = txtTaxes.getText();
                    char c = e.getKeyChar();
                    if (Character.isDigit(c) || c == ',' || c == '.') {
                        if (c == '.' || c == ',') {
                            e.setKeyChar(',');
                            if (in.isEmpty() || in.contains(","))
                                e.consume();
                        }
                        if (c == '0') {
                            if (in.equals("0%") || in.equals("0"))
                                e.consume();
                        }
                    } else {
                        e.consume();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    setValues();
                    txtTaxes.setText(Percentage.format(txtTaxes.getText()));
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

        public Response<Product> isValid() {

            try {

                final String name = isValidName(txtName.getText());

                final String barcode = isValidBarcode(txtBarcode.getText());

                final Category category = (Category) cmbCategory.getSelectedItem();
                final int categoryId = category.getId();

                final double spent = isValidSpent(txtSpent.getText());

                final int units = (int) spnUnit.getValue();

                final int stock = (int) spnStock.getValue();

                final double taxes = isValidTaxes(txtTaxes.getText());

                return new Response.Success<>(new Product(barcode, name, spent, units, taxes, stock, categoryId, 1, 2));

            } catch (Exception e) {

                return new Response.Failure<>(e);

            }

        }

        private String isValidName(String text) throws BlankNameException, InvalidNameException {
            if (isBlank(text))
                throw new BlankNameException();
            if (text.chars().anyMatch(c -> !Character.isAlphabetic(c) && !Character.isDigit(c) && c != ' ' && c != '-'))
                throw new InvalidNameException();
            return text.trim();
        }

        private String isValidBarcode(String text) throws BlankBarcodeException, InvalidBarcodeException {
            if (isBlank(text))
                throw new BlankBarcodeException();
            if (text.chars().anyMatch(c -> !Character.isAlphabetic(c) && !Character.isDigit(c)))
                throw new InvalidBarcodeException();
            return text.trim();
        }

        private double isValidSpent(String text) throws InvalidSpentException {
            double spent = Currency.toDouble(text);
            if (spent < 0)
                throw new InvalidSpentException();
            return spent;
        }

        private double isValidTaxes(String text) throws InvalidPercentageTaxException {
            double percentage = Percentage.toDouble(text);
            if (percentage < 0)
                throw new InvalidPercentageTaxException();
            return percentage;
        }

        private boolean isBlank(String input) {
            return input == null || input.trim().isEmpty();
        }

    }

}