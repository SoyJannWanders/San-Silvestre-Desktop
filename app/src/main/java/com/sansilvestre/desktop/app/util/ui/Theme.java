package com.sansilvestre.desktop.app.util.ui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;

public enum Theme {

    LIGHT("Claro"),
    DARK("Oscuro");

    private final String name;

    Theme(String name) {
        this.name = name;
    }


    public static void swap() {
        if (FlatLaf.isLafDark()) {
            try {
                UIManager.setLookAndFeel(new FlatMacLightLaf());
                SwingUtilities.updateComponentTreeUI(JFrame.getFrames()[0]);
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                UIManager.setLookAndFeel(new FlatMacDarkLaf());
                SwingUtilities.updateComponentTreeUI(JFrame.getFrames()[0]);
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }
        }
    }



    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}