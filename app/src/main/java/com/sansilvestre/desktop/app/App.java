package com.sansilvestre.desktop.app;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.sansilvestre.desktop.app.util.data.sync.AsyncTaskManager;
import com.sansilvestre.desktop.app.splash.screen.SplashScreen;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Jan
 */
public class App extends JFrame {

    private static App instance;

    public App() {
        setTitle("SanSilStore · 1.0");
        setIconImage(new ImageIcon(getClass().getResource("/drawable/xd.png")).getImage());
        NavigationController.getInstance().initApp(this);
        ViewStateController.getInstance().initApp(this);
        AsyncTaskManager.setOff(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        add(new SplashScreen());
        pack();
        setLocationRelativeTo(null);
    }

    public static App getInstance() {
        if (instance == null)
            instance = new App();
        return instance;
    }

    public static void main(String[] args) {
        initFlatlaf();
        App.getInstance();
        EventQueue.invokeLater(() -> App.getInstance().setVisible(true));
    }
    
    private static void initFlatlaf() {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource(Styles.DEFAULT_THEMES_ROUTE);
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 12));
        FlatMacDarkLaf.setup();
    }

}
