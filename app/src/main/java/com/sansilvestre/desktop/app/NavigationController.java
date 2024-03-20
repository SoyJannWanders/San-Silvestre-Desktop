package com.sansilvestre.desktop.app;

import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import java.awt.EventQueue;
import javax.swing.JComponent;

public class NavigationController {
    
    private static NavigationController instance;
    private App app;
    
    private NavigationController() {}
    
    public static NavigationController getInstance() {
        if (instance == null) 
            instance = new NavigationController();
        return instance;
    }
    
    public void initApp(App app) {
        this.app = app;
    }
    
    public void navigateTo(JComponent route) {
        EventQueue.invokeLater(() -> {
            FlatAnimatedLafChange.showSnapshot();
            app.setContentPane(route);
            app.revalidate();
            app.repaint();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        });
    }
    
}