/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sansilvestre.desktop.app;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.sansilvestre.desktop.app.launch.screens.LaunchScreen;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Jan
 */
public class App extends JFrame {

    private final short MIN_WIDTH = 1200;
    private final short MIN_HEIGHT = 700;

    private static final String FLATLAF_PROPIERTIES_FOLDER = "themes";

    public App() {
        setTitle("San Silvestre");
        setSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new LaunchScreen());
    }

    public static void main(String[] args) {
        initFlatlaf();
        EventQueue.invokeLater(() -> new App().setVisible(true));
    }

    private static void initFlatlaf() {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource(FLATLAF_PROPIERTIES_FOLDER);
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 14));
        FlatMacLightLaf.setup();
    }

}
