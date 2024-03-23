package com.sansilvestre.desktop.app.auth.screen;

import com.formdev.flatlaf.FlatClientProperties;
import com.sansilvestre.desktop.app.AppStrings;
import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.Theme;
import com.sansilvestre.desktop.app.auth.screen.resource.AuthStrings;
import com.sansilvestre.desktop.app.auth.screen.viewmodel.AuthViewModel;
import com.sansilvestre.desktop.app.auth.util.AuthDI;
import com.sansilvestre.desktop.app.launch.screen.LaunchScreen;

import java.awt.*;
import java.util.Arrays;

public class AuthScreen extends javax.swing.JPanel implements AuthEvent {

    private final AuthDI injector = AuthDI.getInstance();

    private final AuthViewModel viewModel = injector.provideAuthViewModel();

    private final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);

    public AuthScreen() {
        setUpViewModel();
        initComponents();
        initUIStyles();
    }

    public void setUpViewModel() {
        viewModel.setEvent(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainConteiner = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        headline = new javax.swing.JLabel();
        body = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailInput = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        signInButton = new javax.swing.JButton();
        launchScreenConteiner = new javax.swing.JPanel();
        launchScreenLabel = new javax.swing.JLabel();
        launchScreenButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 700));

        mainConteiner.setMinimumSize(new java.awt.Dimension(512, 700));
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

        emailLabel.setText("Email");
        emailLabel.setMaximumSize(new java.awt.Dimension(384, 16));
        emailLabel.setPreferredSize(new java.awt.Dimension(384, 16));

        emailInput.setText("jTextField1");
        emailInput.setMaximumSize(new java.awt.Dimension(384, 2147483647));
        emailInput.setPreferredSize(new java.awt.Dimension(384, 22));
        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });

        passwordLabel.setText("Password");
        passwordLabel.setMaximumSize(new java.awt.Dimension(384, 16));
        passwordLabel.setPreferredSize(new java.awt.Dimension(384, 16));

        passwordInput.setText("jPasswordField1");
        passwordInput.setMaximumSize(new java.awt.Dimension(384, 2147483647));
        passwordInput.setPreferredSize(new java.awt.Dimension(384, 22));

        signInButton.setText("jButton1");
        signInButton.setMaximumSize(new java.awt.Dimension(384, 23));
        signInButton.setPreferredSize(new java.awt.Dimension(384, 23));
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        launchScreenConteiner.setPreferredSize(new java.awt.Dimension(384, 23));
        launchScreenConteiner.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        launchScreenLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        launchScreenLabel.setText("jLabel1");
        launchScreenLabel.setMaximumSize(new java.awt.Dimension(192, 16));
        launchScreenConteiner.add(launchScreenLabel);

        launchScreenButton.setText("jButton1");
        launchScreenButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        launchScreenButton.setMaximumSize(new java.awt.Dimension(192, 23));
        launchScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchScreenButtonActionPerformed(evt);
            }
        });
        launchScreenConteiner.add(launchScreenButton);

        javax.swing.GroupLayout mainConteinerLayout = new javax.swing.GroupLayout(mainConteiner);
        mainConteiner.setLayout(mainConteinerLayout);
        mainConteinerLayout.setHorizontalGroup(
            mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainConteinerLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(launchScreenConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(emailInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(passwordInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(signInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(launchScreenConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainConteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initUIStyles() {
        logo.putClientProperty(FlatClientProperties.STYLE, Theme.applyLogoStyle());
        logo.setText(AppStrings.getAppName());
        headline.putClientProperty(FlatClientProperties.STYLE, Theme.applyHeadlineStyle());
        headline.setText(AuthStrings.getHeadline());
        body.putClientProperty(FlatClientProperties.STYLE, Theme.applyBodyStyle());
        body.setText(AuthStrings.getBody());
        emailLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyDefaultStyle());
        emailLabel.setText(AuthStrings.getEmailLabel());
        emailInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, AuthStrings.getEmailPlaceholder());
        emailInput.setText(AuthStrings.getDefaultText());
        passwordLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applyDefaultStyle());
        passwordLabel.setText(AuthStrings.getPasswordLabel());
        passwordInput.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, AuthStrings.getPasswordPlaceholder());
        passwordInput.setText(AuthStrings.getDefaultText());
        signInButton.setText(AppStrings.getLoginButton());
        launchScreenLabel.putClientProperty(FlatClientProperties.STYLE, Theme.applySupportingTextStyle());
        launchScreenLabel.setText(AuthStrings.getLaunchScreenLabel());
        launchScreenButton.putClientProperty(FlatClientProperties.STYLE, Theme.applySupportingButtonStyle());
        launchScreenButton.setContentAreaFilled(false);
        launchScreenButton.setCursor(HAND_CURSOR);
        launchScreenButton.setText(AuthStrings.getLaunchScreenButton());
    }

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        viewModel.signIn(getUser(), getPassword());
    }//GEN-LAST:event_signInButtonActionPerformed

    private String getUser() {
        return emailInput.getText();
    }

    private String getPassword() {
        StringBuilder password = new StringBuilder();
        for (char character: passwordInput.getPassword()) {
            password.append(character);
        }
        return password.toString();
    }

    @Override
    public void onSignInLoading() {
        System.out.println("Cargando...");
    }

    @Override
    public void onSignInSuccess() {
        System.out.println("Acceso Exitoso");
    }

    @Override
    public void onSignInFailure() {
        System.out.println("Acceso Erroneo");
    }

    private void launchScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchScreenButtonActionPerformed
        NavigationController.getInstance().navigateTo(new LaunchScreen());
    }//GEN-LAST:event_launchScreenButtonActionPerformed

    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInputActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel body;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel headline;
    private javax.swing.JButton launchScreenButton;
    private javax.swing.JPanel launchScreenConteiner;
    private javax.swing.JLabel launchScreenLabel;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainConteiner;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton signInButton;
    // End of variables declaration//GEN-END:variables
}
