package com.sansilvestre.desktop.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class QuickNavigation {

    public void set(Component a, Component b) {
        a.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (isEnterPressed(e.getKeyCode()))
                    b.requestFocus();
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void set(JButton button) {
        button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Boton Finalizar Presionado");
            }
        });
    }

    public void addBarcodeInput(JTextField input) {
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void inputFilter(KeyEvent e, String input) {
        char c = e.getKeyChar();
        if (Character.isDigit(c) || c == ',' || c == '.' || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (c == '.' || c == ',') {
                e.setKeyChar(',');
                if (input.isBlank() || input.contains(","))
                    e.consume();
            }
            if (c == '0' && input.equals("$ 0")) {
                e.consume();
            }
        } else
            e.consume();
    }

    private static boolean isEnterPressed(int keyCode) {
        return keyCode == KeyEvent.VK_ENTER;
    }

}