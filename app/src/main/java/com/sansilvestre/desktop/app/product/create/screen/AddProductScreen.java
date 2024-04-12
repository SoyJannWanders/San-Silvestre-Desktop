package com.sansilvestre.desktop.app.product.create.screen;

import com.formdev.flatlaf.FlatClientProperties;
import com.sansilvestre.desktop.app.AppStrings;
import com.sansilvestre.desktop.app.Filter;
import com.sansilvestre.desktop.app.QuickNavigation;
import com.sansilvestre.desktop.app.Theme;
import com.sansilvestre.desktop.app.product.create.domain.model.ProductFormData;
import com.sansilvestre.desktop.app.product.screen.resource.NewProductScreenStrings;
import com.sansilvestre.desktop.app.product.main.module.ProductModule;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddProductScreen extends javax.swing.JPanel implements AddProductState {

    private final AddProductViewModel viewModel = ProductModule.getInstance().provideAddProductViewModel();

    private final QuickNavigation quickNavigation = new QuickNavigation();
    private final Filter filter = new Filter();


    public AddProductScreen()  {
        initComponents();
        stylizeComponents();
        applyFieldFilters();
        applyQuickNavigation();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headline = new javax.swing.JLabel();
        officeLabel = new javax.swing.JLabel();
        office = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        mainConteiner = new javax.swing.JPanel();
        productLabel = new javax.swing.JLabel();
        productField = new javax.swing.JTextField();
        barcodeLabel = new javax.swing.JLabel();
        barcodeField = new javax.swing.JTextField();
        categoryLabel = new javax.swing.JLabel();
        categoryList = new javax.swing.JComboBox<>();
        purchaseCostLabel = new javax.swing.JLabel();
        purchaseCostField = new javax.swing.JTextField();
        stockLabel = new javax.swing.JLabel();
        stockField = new javax.swing.JTextField();
        additionalTaxes = new javax.swing.JCheckBox();
        costLabel = new javax.swing.JLabel();
        cost = new javax.swing.JLabel();
        profitLabel = new javax.swing.JLabel();
        profitPercentage = new javax.swing.JLabel();
        profit = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        roundedPriceLabel = new javax.swing.JLabel();
        roundedPrice = new javax.swing.JLabel();
        finishButton = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(384, 576));

        headline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headline.setText("Headline");
        headline.setPreferredSize(new java.awt.Dimension(320, 16));

        officeLabel.setText("Office");

        office.setText("Zona X");

        dateLabel.setText("Fecha");

        date.setText("20 de Enero del 2005");

        mainConteiner.setPreferredSize(new java.awt.Dimension(320, 355));

        productLabel.setText("Product");

        productField.setPreferredSize(new java.awt.Dimension(288, 22));

        barcodeLabel.setText("Barcode");

        barcodeField.setPreferredSize(new java.awt.Dimension(136, 22));

        categoryLabel.setText("Category");

        categoryList.setEditable(true);
        categoryList.setMaximumRowCount(5);
        categoryList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Furniture", "Appliances", "Electronics", "Food", "Toys" }));
        categoryList.setPreferredSize(new java.awt.Dimension(136, 22));

        purchaseCostLabel.setText("Purchase Cost");

        purchaseCostField.setPreferredSize(new java.awt.Dimension(136, 22));

        stockLabel.setText("Stock");

        stockField.setPreferredSize(new java.awt.Dimension(136, 22));

        additionalTaxes.setText("IVA");

        costLabel.setText("Price");

        cost.setText("$ 0,00");

        profitLabel.setText("Utilities");

        profitPercentage.setText("%");

        profit.setText("$ 0,00");

        price.setText("$ 0,00");

        priceLabel.setText("Total");

        roundedPriceLabel.setText("Total");

        roundedPrice.setText("$ 0,00");

        javax.swing.GroupLayout mainConteinerLayout = new javax.swing.GroupLayout(mainConteiner);
        mainConteiner.setLayout(mainConteinerLayout);
        mainConteinerLayout.setHorizontalGroup(
            mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainConteinerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(mainConteinerLayout.createSequentialGroup()
                        .addComponent(priceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(price))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainConteinerLayout.createSequentialGroup()
                        .addComponent(roundedPriceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundedPrice))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainConteinerLayout.createSequentialGroup()
                        .addComponent(profitLabel)
                        .addGap(4, 4, 4)
                        .addComponent(profitPercentage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(profit))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainConteinerLayout.createSequentialGroup()
                        .addComponent(costLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cost))
                    .addComponent(additionalTaxes, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainConteinerLayout.createSequentialGroup()
                        .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barcodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barcodeLabel)
                            .addComponent(purchaseCostLabel))
                        .addGap(16, 16, 16)
                        .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stockLabel)
                            .addComponent(categoryLabel)
                            .addComponent(categoryList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainConteinerLayout.createSequentialGroup()
                        .addComponent(purchaseCostField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(stockField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        mainConteinerLayout.setVerticalGroup(
            mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainConteinerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(productLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barcodeLabel)
                    .addComponent(categoryLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barcodeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchaseCostLabel)
                    .addComponent(stockLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchaseCostField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(additionalTaxes)
                .addGap(16, 16, 16)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costLabel)
                    .addComponent(cost))
                .addGap(8, 8, 8)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profitLabel)
                    .addComponent(profit)
                    .addComponent(profitPercentage))
                .addGap(8, 8, 8)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price)
                    .addComponent(priceLabel))
                .addGap(8, 8, 8)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roundedPriceLabel)
                    .addComponent(roundedPrice))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        finishButton.setText("Finish");
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        goBackButton.setText("Go Back");
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(goBackButton)
                        .addGap(16, 16, 16)
                        .addComponent(finishButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(office)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(officeLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateLabel))
                        .addComponent(headline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(headline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(officeLabel)
                    .addComponent(dateLabel))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(office)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(mainConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finishButton)
                    .addComponent(goBackButton))
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stylizeComponents() {
        stylizeMainConteiner();
        stylizeHeadline();
        stylizeOfficeSection();
        stylizeDateSection();
        stylizeLabelInput();
        stylizeBarcodeInput();
        stylizeCategoryInput();
        stylizeCostInput();
        stylizeStockInput();
        stylizeIVAInput();
        stylizeCostSection();
        stylizeRealSection();
        stylizeProfitSection();
        stylizePriceSection();
        stylizeFinishButton();
        stylizeGoBackButton();
    }

    private void stylizeMainConteiner() {
        mainConteiner.putClientProperty(FlatClientProperties.STYLE, Theme.applyConteinerStyle());
    }

    private void stylizeHeadline() {
        headline.putClientProperty(FlatClientProperties.STYLE, Theme.applyHeadlineSmallStyle());
        headline.setText(NewProductScreenStrings.getHeadline());
    }

    private void stylizeOfficeSection() {
        officeLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applySupportingTextStyle());
        officeLabel.setText(NewProductScreenStrings.getOfficeLabel());
        office.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelSmallStyle());
    }

    private void stylizeDateSection() {
        dateLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applySupportingTextStyle());
        dateLabel.setText(NewProductScreenStrings.getDateLabel());
        date.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelSmallStyle());
    }

    private void stylizeLabelInput() {
        productLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelSmallStyle());
        productLabel.setText(NewProductScreenStrings.getProductLabel());
        productField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, NewProductScreenStrings.getProductPlaceholder());
        productField.setText(AppStrings.getDefaultText());
    }

    private void stylizeBarcodeInput() {
        barcodeLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelSmallStyle());
        barcodeLabel.setText(NewProductScreenStrings.getBarcodeLabel());
        barcodeField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, NewProductScreenStrings.getBarcodePlaceholder());
        barcodeField.setText(AppStrings.getDefaultText());
    }

    private void stylizeCategoryInput() {
        categoryLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelSmallStyle());
        categoryLabel.setText(NewProductScreenStrings.getCategoryLabel());
    }

    private void stylizeCostInput() {
        purchaseCostLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelSmallStyle());
        purchaseCostLabel.setText(NewProductScreenStrings.getPurchaseCostLabel());
        purchaseCostField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, NewProductScreenStrings.getPurchaseCostPlaceholder());
        purchaseCostField.setText(AppStrings.getDefaultText());
    }

    private void stylizeStockInput() {
        stockLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelSmallStyle());
        stockLabel.setText(NewProductScreenStrings.getStockLabel());
        stockField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, NewProductScreenStrings.getStockPlaceholder());
        stockField.setText(AppStrings.getDefaultText());
    }

    private void stylizeIVAInput() {
        additionalTaxes.setText(NewProductScreenStrings.getTaxLabel());
    }

    private void stylizeCostSection() {
        costLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelMediumStyle());
        costLabel.setText(NewProductScreenStrings.getBasePriceLabel());
        cost.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelMediumStyle());
    }

    private void stylizeProfitSection() {
        profitLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelMediumStyle());
        profitLabel.setText(NewProductScreenStrings.getUtilitiesLabel());
        profitPercentage.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelMediumStyle());
        profit.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelMediumStyle());
    }

    private void stylizeRealSection() {
        priceLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelMediumStyle());
        price.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelMediumStyle());
    }

    private void stylizePriceSection() {
        roundedPriceLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelLargeStyle());
        roundedPriceLabel.setText(NewProductScreenStrings.getFinalPriceLabel());
        roundedPrice.putClientProperty(FlatClientProperties.STYLE, Theme.applyLabelLargeStyle());
    }

    private void stylizeGoBackButton() {
        goBackButton.putClientProperty(FlatClientProperties.STYLE, Theme.applyTextButtonStyle());
        goBackButton.setContentAreaFilled(false);
        goBackButton.setText(AppStrings.getGoBackButton());
    }

    private void stylizeFinishButton() {
        finishButton.setText(AppStrings.getFinishButton());
    }

    private void applyFieldFilters() {
        filter.setTo(barcodeField, Filter.Type.NUMERIC);
        filter.setTo(stockField, Filter.Type.NUMERIC);
        filter.setTo(purchaseCostField, Filter.Type.CURRENCY);
    }

    private void applyQuickNavigation() {
        quickNavigation.set(productField, barcodeField);
        quickNavigation.set(barcodeField, purchaseCostField);
        quickNavigation.set(purchaseCostField, stockField);
        quickNavigation.set(stockField, finishButton);
        quickNavigation.set(finishButton);
    }

    private void setup() {
        viewModel.setState(this);
        initEvents();
    }

    @Override
    public void updateOffice(String office) {
        this.office.setText(office);
    }

    @Override
    public void updateDate(String date) {
        this.date.setText(date);
    }

    @Override
    public void updateBilling(String in, String cost, String profit, String price, String roundedPrice) {
        purchaseCostField.setText(in);
        this.cost.setText(cost);
        this.profit.setText(profit);
        this.price.setText(price);
        this.roundedPrice.setText(roundedPrice);
    }

    @Override
    public void closeFormAfterInserction() {
        closeWindow();
    }

    @Override
    public void displayErrorPopup(String code) {
        System.out.println(code);
    }

    private void initEvents() {
        viewModel.onEvent(new AddProductEvent.OnDateChange());
        viewModel.onEvent(new AddProductEvent.OnOfficeChange());
        onPurchaseCostChange();
        onHasAdditionalTaxesSelected();
    }

    private void onPurchaseCostChange() {
        purchaseCostField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {
                viewModel.onEvent(new AddProductEvent.OnCostChange(purchaseCostField.getText()));
            }
        });
    }

    private void onHasAdditionalTaxesSelected() {
        additionalTaxes.addItemListener(event ->
                viewModel.onEvent(new AddProductEvent.OnApplyIVA(event.getStateChange() == ItemEvent.SELECTED))
        );
    }

    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        viewModel.onEvent(new AddProductEvent.OnAddProduct(
                new ProductFormData()
                        .setBarcode(barcodeField.getText())
                        .setLabel(productField.getText())
                        .setCost(purchaseCostField.getText())
                        .setStock(stockField.getText())
                        .setCategory(categoryList.getSelectedItem().toString())
                        .setAdditionalTaxes(additionalTaxes.isSelected())
        ));
    }//GEN-LAST:event_finishButtonActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        closeWindow();
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void closeWindow() {
        SwingUtilities.getWindowAncestor(this).dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox additionalTaxes;
    private javax.swing.JTextField barcodeField;
    private javax.swing.JLabel barcodeLabel;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JComboBox<String> categoryList;
    private javax.swing.JLabel cost;
    private javax.swing.JLabel costLabel;
    private javax.swing.JLabel date;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton finishButton;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel headline;
    private javax.swing.JPanel mainConteiner;
    private javax.swing.JLabel office;
    private javax.swing.JLabel officeLabel;
    private javax.swing.JLabel price;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField productField;
    private javax.swing.JLabel productLabel;
    private javax.swing.JLabel profit;
    private javax.swing.JLabel profitLabel;
    private javax.swing.JLabel profitPercentage;
    private javax.swing.JTextField purchaseCostField;
    private javax.swing.JLabel purchaseCostLabel;
    private javax.swing.JLabel roundedPrice;
    private javax.swing.JLabel roundedPriceLabel;
    private javax.swing.JTextField stockField;
    private javax.swing.JLabel stockLabel;
    // End of variables declaration//GEN-END:variables
}
