package com.sansilvestre.desktop.app.launch.screens;

import com.formdev.flatlaf.FlatClientProperties;
import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.AppStrings;
import com.sansilvestre.desktop.app.AppThemes;
import com.sansilvestre.desktop.app.auth.screens.AuthScreen;
import com.sansilvestre.desktop.app.launch.screens.resources.LaunchStrings;
import com.sansilvestre.desktop.app.launch.util.LaunchDI;
import com.sansilvestre.desktop.app.launch.screens.viewmodels.LaunchViewModel;

import java.awt.*;
import java.time.LocalTime;

public class LaunchScreen extends javax.swing.JPanel implements LaunchEvents {

    private final LaunchDI injector = LaunchDI.getInstance();

    private final LaunchViewModel viewModel = injector.provideLaunchViewModel();

    private final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);

    public LaunchScreen() {
        setUpViewModel();
        initComponents();
        initUIStyles();
        loadUIData();
    }

    private void setUpViewModel() {
        viewModel.setEvent(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainConteiner = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        headline = new javax.swing.JLabel();
        body = new javax.swing.JLabel();
        scheduleLabel = new javax.swing.JLabel();
        scheduleInput = new javax.swing.JComboBox<>();
        employeeScreenButton = new javax.swing.JButton();
        authScreenLabel = new javax.swing.JLabel();
        authScreenButton = new javax.swing.JButton();
        subConteiner = new javax.swing.JPanel();
        image = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 238));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1200, 700));

        mainConteiner.setBackground(new java.awt.Color(250, 250, 238));
        mainConteiner.setPreferredSize(new java.awt.Dimension(512, 700));

        logo.setText("Logo");
        logo.setMaximumSize(new java.awt.Dimension(384, 16));
        logo.setPreferredSize(new java.awt.Dimension(384, 16));

        headline.setText("Headline");
        headline.setMaximumSize(new java.awt.Dimension(384, 16));
        headline.setPreferredSize(new java.awt.Dimension(384, 16));

        body.setText("Body");
        body.setMaximumSize(new java.awt.Dimension(384, 16));
        body.setPreferredSize(new java.awt.Dimension(384, 16));

        scheduleLabel.setText("Schedule");
        scheduleLabel.setMaximumSize(new java.awt.Dimension(384, 16));
        scheduleLabel.setMinimumSize(new java.awt.Dimension(16, 16));
        scheduleLabel.setOpaque(true);
        scheduleLabel.setPreferredSize(new java.awt.Dimension(384, 16));

        scheduleInput.setEditable(true);
        scheduleInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turno 1 ~ 22:30 - 7:00", "Turno 2 ~ 7:00 - 14:00", "Turno 3 ~ 14:00 - 22:30" }));
        scheduleInput.setMaximumSize(new java.awt.Dimension(384, 32767));
        scheduleInput.setPreferredSize(new java.awt.Dimension(384, 22));

        employeeScreenButton.setText("jButton1");
        employeeScreenButton.setMaximumSize(new java.awt.Dimension(384, 23));
        employeeScreenButton.setPreferredSize(new java.awt.Dimension(384, 23));
        employeeScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeScreenButtonActionPerformed(evt);
            }
        });

        authScreenLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        authScreenLabel.setText("jLabel6");
        authScreenLabel.setMaximumSize(new java.awt.Dimension(192, 16));
        authScreenLabel.setPreferredSize(new java.awt.Dimension(192, 16));

        authScreenButton.setText("jButton2");
        authScreenButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        authScreenButton.setMaximumSize(new java.awt.Dimension(192, 23));
        authScreenButton.setPreferredSize(new java.awt.Dimension(192, 23));
        authScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authScreenButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainConteinerLayout = new javax.swing.GroupLayout(mainConteiner);
        mainConteiner.setLayout(mainConteinerLayout);
        mainConteinerLayout.setHorizontalGroup(
            mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainConteinerLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainConteinerLayout.createSequentialGroup()
                        .addComponent(authScreenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(authScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(headline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scheduleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scheduleInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeScreenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        mainConteinerLayout.setVerticalGroup(
            mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainConteinerLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(scheduleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(scheduleInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(employeeScreenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authScreenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authScreenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        subConteiner.setBackground(new java.awt.Color(250, 250, 238));
        subConteiner.setName(""); // NOI18N
        subConteiner.setPreferredSize(new java.awt.Dimension(688, 700));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/daniil-silantev-F6Da4r2x5to-unsplash.jpg"))); // NOI18N
        image.setMinimumSize(new java.awt.Dimension(560, 572));
        image.setPreferredSize(new java.awt.Dimension(688, 700));

        javax.swing.GroupLayout subConteinerLayout = new javax.swing.GroupLayout(subConteiner);
        subConteiner.setLayout(subConteinerLayout);
        subConteinerLayout.setHorizontalGroup(
            subConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subConteinerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
        subConteinerLayout.setVerticalGroup(
            subConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(subConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainConteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subConteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initUIStyles() {
        logo.putClientProperty(FlatClientProperties.STYLE, AppThemes.applyLogoStyle());
        logo.setText(AppStrings.getAppName());
        headline.putClientProperty(FlatClientProperties.STYLE, AppThemes.applyHeadlineStyle());
        headline.setText(LaunchStrings.getHeadline());
        body.putClientProperty(FlatClientProperties.STYLE, AppThemes.applyBodyStyle());
        body.setText(LaunchStrings.getBody());
        scheduleLabel.putClientProperty(FlatClientProperties.STYLE, AppThemes.applyDefaultStyle());
        scheduleLabel.setText(LaunchStrings.getScheduleLabel());
        employeeScreenButton.setText(LaunchStrings.getEmployeeScreenButton());
        authScreenLabel.putClientProperty(FlatClientProperties.STYLE, AppThemes.applyDefaultStyle());
        authScreenLabel.setText(LaunchStrings.getAuthScreenLabel());
        authScreenButton.setText(LaunchStrings.getAuthScreenButton());
        authScreenButton.setContentAreaFilled(false);
        authScreenButton.setCursor(HAND_CURSOR);
        authScreenButton.putClientProperty(FlatClientProperties.STYLE, AppThemes.applySupportingButtonStyle());
    }

    private void loadUIData() {
        viewModel.getSchedule(LocalTime.now());
    }

    @Override
    public void onGetSchedule(String schedule) {
        scheduleInput.setSelectedItem(schedule);
    }

    private void employeeScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeScreenButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeScreenButtonActionPerformed

    private void authScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authScreenButtonActionPerformed
        NavigationController.getInstance().navigateTo(new AuthScreen());
    }//GEN-LAST:event_authScreenButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authScreenButton;
    private javax.swing.JLabel authScreenLabel;
    private javax.swing.JLabel body;
    private javax.swing.JButton employeeScreenButton;
    private javax.swing.JLabel headline;
    private javax.swing.JLabel image;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainConteiner;
    private javax.swing.JComboBox<String> scheduleInput;
    private javax.swing.JLabel scheduleLabel;
    private javax.swing.JPanel subConteiner;
    // End of variables declaration//GEN-END:variables
}
