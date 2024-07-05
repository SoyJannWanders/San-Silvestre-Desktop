package com.sansilvestre.desktop.app.splash.screen;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.session.domain.model.Session;
import com.sansilvestre.desktop.app.setting.domain.model.Setting;
import com.sansilvestre.desktop.app.setting.screen.SettingScreen;
import com.sansilvestre.desktop.app.setting.screen.other.init.InitSettingScreen;
import com.sansilvestre.desktop.app.splash.module.SplashModule;
import com.sansilvestre.desktop.app.user.domain.model.Role;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SplashScreen extends javax.swing.JPanel implements SplashViewController {

    private final SplashViewModel viewModel;

    public SplashScreen() {
        viewModel = SplashModule.getInstance().provideSplashViewModel();
        initComponents();
        setup();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new Background();

        setPreferredSize(new java.awt.Dimension(512, 352));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        viewModel.setViewController(this);
        viewModel.onEvent(new SplashEvent.GetSettingEvent());
    }

    @Override
    public void getSetting() {
        if (Setting.getInstance() == null) {
            NavigationController.getInstance().navigateTo(new InitSettingScreen());
        } else {
            viewModel.onEvent(new SplashEvent.GetSessionEvent());
        }
    }

    @Override
    public void setSession(Session session) {
        if (session == null) {
            NavigationController.getInstance().navigate(NavigationController.Route.LAUNCH_SCREEN, null);
        } else {
            NavigationController.getInstance().navigate(NavigationController.Route.DASHBOARD_SCREEN, new NavigationData(
                    new Object[] { Role.EMPLOYEE }, new Class[] { Role.class }
            ));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private static class Background extends JPanel {

        @Override
        public void paint(Graphics g) {

            setOpaque(false);

            URL url = getClass().getResource("/drawable/logo.jpg");
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

}