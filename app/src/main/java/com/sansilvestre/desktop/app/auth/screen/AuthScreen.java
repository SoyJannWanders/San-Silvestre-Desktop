package com.sansilvestre.desktop.app.auth.screen;

import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.ViewStateController;
import com.sansilvestre.desktop.app.util.exception.form.BlankIDException;
import com.sansilvestre.desktop.app.util.exception.form.BlankPasswordException;
import com.sansilvestre.desktop.app.user.domain.model.Role;
import com.sansilvestre.desktop.app.util.data.response.Response;
import com.sansilvestre.desktop.app.util.data.response.ResponseVisitor;
import com.sansilvestre.desktop.app.util.ui.Placeholder;
import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.auth.util.AuthModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

public class AuthScreen extends javax.swing.JPanel implements AuthViewController {

    private final AuthViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Form form = new Form();

    public AuthScreen() {
        viewModel = AuthModule.getInstance().provideAuthViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainConteiner = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        headline = new javax.swing.JLabel();
        body = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnSignIn = new javax.swing.JButton();
        launchScreenConteiner = new javax.swing.JPanel();
        launchScreenLabel = new javax.swing.JLabel();
        btnDispose = new javax.swing.JButton();
        pnlLogo = new Background();

        setPreferredSize(new java.awt.Dimension(896, 640));

        mainConteiner.setMinimumSize(new java.awt.Dimension(384, 640));
        mainConteiner.setPreferredSize(new java.awt.Dimension(416, 640));

        logo.setText("San Silvestre Store");
        logo.setMaximumSize(new java.awt.Dimension(320, 16));
        logo.setPreferredSize(new java.awt.Dimension(320, 16));

        headline.setText("Tal vez, ¿Eres tú?");
        headline.setMaximumSize(new java.awt.Dimension(320, 16));
        headline.setPreferredSize(new java.awt.Dimension(320, 16));

        body.setText("Ingresa tus datos para acceder al sistema");
        body.setMaximumSize(new java.awt.Dimension(320, 16));
        body.setPreferredSize(new java.awt.Dimension(320, 16));

        emailLabel.setText("ID");
        emailLabel.setMaximumSize(new java.awt.Dimension(320, 16));
        emailLabel.setPreferredSize(new java.awt.Dimension(320, 16));

        txtEmail.setMaximumSize(new java.awt.Dimension(256, 2147483647));
        txtEmail.setPreferredSize(new java.awt.Dimension(320, 22));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        passwordLabel.setText("Contraseña");
        passwordLabel.setMaximumSize(new java.awt.Dimension(320, 16));
        passwordLabel.setPreferredSize(new java.awt.Dimension(320, 16));

        txtPassword.setMaximumSize(new java.awt.Dimension(320, 2147483647));
        txtPassword.setPreferredSize(new java.awt.Dimension(320, 22));

        btnSignIn.setText("Iniciar Sesion");
        btnSignIn.setMaximumSize(new java.awt.Dimension(320, 23));
        btnSignIn.setPreferredSize(new java.awt.Dimension(320, 23));
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        launchScreenConteiner.setMaximumSize(new java.awt.Dimension(320, 32767));
        launchScreenConteiner.setPreferredSize(new java.awt.Dimension(320, 23));
        launchScreenConteiner.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        launchScreenLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        launchScreenLabel.setText("¿No tienes un Usuario?");
        launchScreenLabel.setMaximumSize(new java.awt.Dimension(192, 16));
        launchScreenConteiner.add(launchScreenLabel);

        btnDispose.setText("No tengo uno");
        btnDispose.setContentAreaFilled(false);
        btnDispose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDispose.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDispose.setMaximumSize(new java.awt.Dimension(192, 23));
        btnDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisposeActionPerformed(evt);
            }
        });
        launchScreenConteiner.add(btnDispose);

        javax.swing.GroupLayout mainConteinerLayout = new javax.swing.GroupLayout(mainConteiner);
        mainConteiner.setLayout(mainConteinerLayout);
        mainConteinerLayout.setHorizontalGroup(
            mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainConteinerLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(launchScreenConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
        mainConteinerLayout.setVerticalGroup(
            mainConteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainConteinerLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(headline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(launchScreenConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainConteiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainConteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
    }

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        signIn();
    }//GEN-LAST:event_btnSignInActionPerformed

    private void btnDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisposeActionPerformed
        dispose();
    }//GEN-LAST:event_btnDisposeActionPerformed

    private void signIn() {
        Response<Void> response = form.isValid();
        response.accept(new ResponseVisitor<>() {

            @Override
            public void visitSuccess(Response.Success<Void> success) {
                viewModel.onEvent(new AuthEvent.SignInEvent(Integer.parseInt(txtEmail.getText()), String.valueOf(txtPassword.getPassword())));
            }

            @Override
            public void visitFailure(Response.Failure<Void> failure) {
                ViewStateController.getInstance().isFailure(failure.getException());
            }

        });
    }

    @Override
    public void setRole(Role role) {
        NavigationController.getInstance().navigate(NavigationController.Route.DASHBOARD_SCREEN, new NavigationData(
                new Object[] { role }, new Class[] { Role.class }
        ));
    }

    private void dispose() {
        NavigationController.getInstance().navigate(NavigationController.Route.LAUNCH_SCREEN, null);
    }

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel body;
    private javax.swing.JButton btnDispose;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel headline;
    private javax.swing.JPanel launchScreenConteiner;
    private javax.swing.JLabel launchScreenLabel;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainConteiner;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(logo, "logo");

            Styles.setStyleTo(headline, "headline.large");

            Styles.setStyleTo(emailLabel, "label.small");

            Placeholder.setPlaceholderTo(txtEmail, "1, 2, 3, 4...");

            Styles.setStyleTo(passwordLabel, "label.small");

            Placeholder.setPlaceholderTo(txtPassword, "2wsXzAq1!");

            Styles.setStyleTo(btnDispose, "button.text");

        }

        public void initializeListeners() {

            txtEmail.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c))
                        e.consume();
                }

            });

            txtPassword.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (c == ' ')
                        e.consume();
                }

            });

        }

    }

    private class Form {

        public Response<Void> isValid() {

            try {

                isValidID(txtEmail.getText());

                isValidPassword(txtPassword.getPassword());

                return new Response.Success<>(null);

            } catch (Exception e) {

                return new Response.Failure<>(e);

            }

        }

        private void isValidID(String id) throws Exception {
            if (isBlank(id))
                throw new BlankIDException();
        }

        private void isValidPassword(char[] password) throws Exception {
            if (isBlank(String.valueOf(password)))
                throw new BlankPasswordException();
        }

        private boolean isBlank(String input) {
            return input == null || input.trim().isEmpty();
        }

    }

    private static class Background extends JPanel {

        @Override
        public void paint(Graphics g) {

            setOpaque(false);

            URL url = getClass().getResource("/drawable/logo.png");
            if (url != null) {

                Image image = new ImageIcon(url).getImage();

                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int imageWidth = image.getWidth(this);
                int imageHeight = image.getHeight(this);

                if (imageWidth > 0 && imageHeight > 0) {

                    double aspectRatio = (double) imageWidth / imageHeight;

                    int drawWidth, drawHeight;

                    if (panelWidth / (double) panelHeight < aspectRatio) {
                        drawWidth = panelWidth;
                        drawHeight = (int) (panelWidth / aspectRatio);
                    } else {
                        drawHeight = panelHeight;
                        drawWidth = (int) (panelHeight * aspectRatio);
                    }

                    int x = (panelWidth - drawWidth) / 2;
                    int y = (panelHeight - drawHeight) / 2;

                    g.drawImage(image, x, y, drawWidth, drawHeight, this);

                }
            }

            super.paint(g);

        }

    }

    private class Shortcut {

        public void configure(JComponent component) {

            InputMap input = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

            final String SIGN_IN = "signIn";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), SIGN_IN);
            actionMap.put(SIGN_IN, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    signIn();
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

}