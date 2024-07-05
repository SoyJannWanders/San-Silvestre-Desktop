package com.sansilvestre.desktop.app.util.ui;

import com.formdev.flatlaf.FlatClientProperties;

import javax.swing.*;

public class Placeholder {

    public static void setPlaceholderTo(JComponent component, String placeholder) {
        component.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, placeholder);
    }

}