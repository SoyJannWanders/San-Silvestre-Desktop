package com.sansilvestre.desktop.app;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.sansilvestre.desktop.app.auth.screen.AuthScreen;
import com.sansilvestre.desktop.app.dashboard.screen.DashboardScreen;
import com.sansilvestre.desktop.app.launch.screen.LaunchScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Jan
 */
public class App extends JFrame {

    private final short MIN_WIDTH = 896;
    private final short MIN_HEIGHT = 640;

    public App() {
        setTitle("San Silvestre");
        setSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new DashboardScreen());
        pack();
        NavigationController.getInstance().initApp(this);
    }

    public static void main(String[] args) {
        initFlatlaf();
        EventQueue.invokeLater(() -> new App().setVisible(true));
    }
    
    private static void initFlatlaf() {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource(Theme.DEFAULT_THEMES_ROUTE);
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 12));
        FlatMacDarkLaf.setup();
    }

}
