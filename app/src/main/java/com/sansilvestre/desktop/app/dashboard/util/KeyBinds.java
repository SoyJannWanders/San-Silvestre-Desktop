package com.sansilvestre.desktop.app.dashboard.util;

import java.awt.*;

public class KeyBinds {

    private static KeyBinds instance;

    private Component component;

    private KeyBinds() {}

    public static KeyBinds getInstance() {
        if (instance == null)
            instance = new KeyBinds();
        return instance;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public void restartKeyBindsService() {
        component.requestFocusInWindow();
    }

}