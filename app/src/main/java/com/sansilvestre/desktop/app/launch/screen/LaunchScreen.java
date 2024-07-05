package com.sansilvestre.desktop.app.launch.screen;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.shift.domain.model.Shift;
import com.sansilvestre.desktop.app.util.log.Console;
import com.sansilvestre.desktop.app.util.ui.Styles;
import com.sansilvestre.desktop.app.launch.module.LaunchModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.List;

public class LaunchScreen extends javax.swing.JPanel implements LaunchViewController {

    private final LaunchViewModel viewModel;

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    public LaunchScreen() {
        viewModel = LaunchModule.getInstance().provideLaunchViewModel();
        initComponents();
        setup();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formContainer = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        headline = new javax.swing.JLabel();
        body = new javax.swing.JLabel();
        shiftLabel = new javax.swing.JLabel();
        cmbShifts = new javax.swing.JComboBox<>();
        btnAccept = new javax.swing.JButton();
        loginContainer = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        beautifierContainer = new Background();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(896, 640));

        formContainer.setPreferredSize(new java.awt.Dimension(416, 640));

        logo.setText("San Silvestre Store");
        logo.setMaximumSize(new java.awt.Dimension(320, 16));
        logo.setPreferredSize(new java.awt.Dimension(320, 16));

        headline.setText("¿Que tal estas?");
        headline.setMaximumSize(new java.awt.Dimension(128, 16));
        headline.setPreferredSize(new java.awt.Dimension(128, 16));

        body.setText("Seleccionamos automaticamente el turno para ti.");
        body.setMaximumSize(new java.awt.Dimension(128, 16));
        body.setPreferredSize(new java.awt.Dimension(128, 16));

        shiftLabel.setText("Turnos");
        shiftLabel.setMaximumSize(new java.awt.Dimension(128, 16));
        shiftLabel.setMinimumSize(new java.awt.Dimension(16, 16));
        shiftLabel.setOpaque(true);
        shiftLabel.setPreferredSize(new java.awt.Dimension(128, 16));

        cmbShifts.setEditable(true);
        cmbShifts.setMaximumSize(new java.awt.Dimension(128, 32767));
        cmbShifts.setPreferredSize(new java.awt.Dimension(128, 22));

        btnAccept.setText("Abrir Caja");
        btnAccept.setMaximumSize(new java.awt.Dimension(128, 23));
        btnAccept.setPreferredSize(new java.awt.Dimension(128, 23));
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        loginContainer.setPreferredSize(new java.awt.Dimension(320, 23));
        loginContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        loginLabel.setText("¿Tienes un Usuario?");
        loginLabel.setMaximumSize(new java.awt.Dimension(192, 16));
        loginContainer.add(loginLabel);

        btnSignIn.setText("Sí, tengo un Usuario");
        btnSignIn.setContentAreaFilled(false);
        btnSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignIn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSignIn.setMaximumSize(new java.awt.Dimension(192, 23));
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        loginContainer.add(btnSignIn);

        javax.swing.GroupLayout formContainerLayout = new javax.swing.GroupLayout(formContainer);
        formContainer.setLayout(formContainerLayout);
        formContainerLayout.setHorizontalGroup(
            formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formContainerLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(headline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shiftLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbShifts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAccept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        formContainerLayout.setVerticalGroup(
            formContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formContainerLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(headline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(shiftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(cmbShifts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAccept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(loginContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        beautifierContainer.setName(""); // NOI18N
        beautifierContainer.setPreferredSize(new java.awt.Dimension(480, 640));

        javax.swing.GroupLayout beautifierContainerLayout = new javax.swing.GroupLayout(beautifierContainer);
        beautifierContainer.setLayout(beautifierContainerLayout);
        beautifierContainerLayout.setHorizontalGroup(
            beautifierContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        beautifierContainerLayout.setVerticalGroup(
            beautifierContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(formContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(beautifierContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(beautifierContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
        viewModel.setViewController(this);
        viewModel.onEvent(new LaunchEvent.GetShiftList());
        viewModel.onEvent(new LaunchEvent.GetCurrentShift());
    }

    @Override
    public void setShiftList(List<Shift> shifts) {
        shifts.forEach(shift -> cmbShifts.addItem(shift));
    }

    @Override
    public void setShift(Shift shift) {
        cmbShifts.setSelectedItem(shift);
    }

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        open();
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        signIn();
    }//GEN-LAST:event_btnSignInActionPerformed

    private void open() {
        Shift shift = (Shift) cmbShifts.getSelectedItem();
        NavigationController.getInstance().navigate(NavigationController.Route.OPEN_SESSION_SCREEN, new NavigationData(
                new Object[] { shift.getCheckoutId() }, new Class[] { Integer.class }
        ));
    }

    private void signIn() {
        NavigationController.getInstance().navigate(NavigationController.Route.AUTH_SCREEN, null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel beautifierContainer;
    private javax.swing.JLabel body;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JComboBox<Shift> cmbShifts;
    private javax.swing.JPanel formContainer;
    private javax.swing.JLabel headline;
    private javax.swing.JPanel loginContainer;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel shiftLabel;
    // End of variables declaration//GEN-END:variables

    private class Screen {

        public void assembleComponents() {

            Styles.setStyleTo(logo, "logo");

            Styles.setStyleTo(headline, "headline.large");

            Styles.setStyleTo(shiftLabel, "label.small");

            Styles.setStyleTo(cmbShifts, "combo.box.variant");

            Styles.setStyleTo(btnSignIn, "button.text");

        }

        public void initializeListeners() {

            cmbShifts.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (shortcut.isNotConfigured(e))
                        e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

            });

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

            final String OPEN = "open";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), OPEN);
            actionMap.put(OPEN, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    open();
                }
            });

            final String SIGN_IN = "signIn";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK), SIGN_IN);
            actionMap.put(SIGN_IN, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    signIn();
                }
            });

        }

        public boolean isNotConfigured(KeyEvent e) {
            return e.getKeyCode() != KeyEvent.VK_ENTER;
        }

    }

}