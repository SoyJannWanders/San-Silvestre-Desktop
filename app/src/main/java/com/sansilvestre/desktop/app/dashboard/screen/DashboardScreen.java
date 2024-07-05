package com.sansilvestre.desktop.app.dashboard.screen;

import com.sansilvestre.desktop.app.branch.screen.BranchScreen;
import com.sansilvestre.desktop.app.checkout.screen.CheckoutScreen;
import com.sansilvestre.desktop.app.dashboard.screen.component.menu.administrator.screen.AdministratorMenu;
import com.sansilvestre.desktop.app.dashboard.screen.component.menu.def.screen.DefaultMenu;
import com.sansilvestre.desktop.app.dashboard.screen.component.menu.employee.screen.EmployeeMenu;
import com.sansilvestre.desktop.app.dashboard.screen.component.menu.manager.screen.ManagerMenu;
import com.sansilvestre.desktop.app.dashboard.screen.component.menu.moderator.screen.ModeratorMenu;
import com.sansilvestre.desktop.app.dashboard.util.KeyBinds;
import com.sansilvestre.desktop.app.home.screen.HomeScreen;
import com.sansilvestre.desktop.app.setting.screen.SettingScreen;
import com.sansilvestre.desktop.app.user.domain.model.Role;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DashboardScreen extends javax.swing.JPanel {

    private static DashboardScreen instance;

    public DashboardScreen(Role role) {
        initComponents();
        instance = this;
        switch (role) {
            case ADMINISTRATOR -> {
                insertContent(new HomeScreen());
                insertMenu(new AdministratorMenu());
            }
            case MANAGER -> {
                insertContent(new HomeScreen());
                insertMenu(new ManagerMenu());
            }
            case MODERATOR -> {
                insertContent(new HomeScreen());
                insertMenu(new ModeratorMenu());
            }
            case EMPLOYEE -> {
                insertContent(new CheckoutScreen());
                insertMenu(new EmployeeMenu());
            }
        }
    }

    public DashboardScreen() {
        KeyBinds.getInstance().setComponent(this);
        initComponents();
        setFocusable(true);
        menuSection.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Menu");
            }
        });
        menuSection.setFocusable(true);
        contentSection.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Content");
            }
        });
        contentSection.setFocusable(true);
        contentSection.requestFocusInWindow();
    }

    public static DashboardScreen getInstance() {
        if (instance == null)
            instance = new DashboardScreen();
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuSection = new javax.swing.JPanel();
        contentSection = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(960, 640));

        menuSection.setFocusable(false);
        menuSection.setMinimumSize(new java.awt.Dimension(0, 0));
        menuSection.setPreferredSize(new java.awt.Dimension(192, 640));

        javax.swing.GroupLayout menuSectionLayout = new javax.swing.GroupLayout(menuSection);
        menuSection.setLayout(menuSectionLayout);
        menuSectionLayout.setHorizontalGroup(
            menuSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        menuSectionLayout.setVerticalGroup(
            menuSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        contentSection.setFocusable(false);
        contentSection.setMinimumSize(new java.awt.Dimension(0, 0));
        contentSection.setPreferredSize(new java.awt.Dimension(768, 640));

        javax.swing.GroupLayout contentSectionLayout = new javax.swing.GroupLayout(contentSection);
        contentSection.setLayout(contentSectionLayout);
        contentSectionLayout.setHorizontalGroup(
            contentSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentSectionLayout.setVerticalGroup(
            contentSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void navigateTo(Component screen) {
        insertContent(screen);
    }

    private void insertMenu(Component menu) {
        menuSection.removeAll();
        javax.swing.GroupLayout menuSectionLayout = new javax.swing.GroupLayout(menuSection);
        menuSection.setLayout(menuSectionLayout);
        menuSectionLayout.setHorizontalGroup(
            menuSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuSectionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuSectionLayout.setVerticalGroup(
            menuSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuSectionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuSection.revalidate();
        menuSection.repaint();
    }

    private void insertContent(Component content) {
        contentSection.removeAll();
        javax.swing.GroupLayout contentSectionLayout = new javax.swing.GroupLayout(contentSection);
        contentSection.setLayout(contentSectionLayout);
        contentSectionLayout.setHorizontalGroup(
            contentSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentSectionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        contentSectionLayout.setVerticalGroup(
            contentSectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentSectionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentSection.revalidate();
        contentSection.repaint();
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentSection;
    private javax.swing.JPanel menuSection;
    // End of variables declaration//GEN-END:variables
}