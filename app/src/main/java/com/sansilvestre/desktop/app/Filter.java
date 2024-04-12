package com.sansilvestre.desktop.app;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Filter {

    public enum Type {
        NUMERIC,
        ALPHABETICAL,
        SELECT,
        CURRENCY
    }

    public void setTo(JTextField in, Type type) {
        in.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (type) {
                    case NUMERIC ->
                            applyNumericFilter(e);
                    case ALPHABETICAL ->
                            applyAlphabeticalFilter(e);
                    case SELECT ->
                            applySelectFilter(e);
                    case CURRENCY ->
                            applyCurrencyFilter(e, in.getText());
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    private void applyNumericFilter(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar()))
            e.consume();
    }

    private void applyAlphabeticalFilter(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar()))
            e.consume();
    }

    private void applySelectFilter(KeyEvent e) {
        e.consume();
    }

    private void applyCurrencyFilter(KeyEvent e, String currency) {
        char c = e.getKeyChar();
        if (Character.isDigit(c) || c == ',' || c == '.' || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (c == '.' || c == ',') {
                e.setKeyChar(',');
                if (currency.isBlank() || currency.contains(","))
                    e.consume();
            }
            if (currency.equals("$ 0") && c == '0')
                e.consume();
        } else
            e.consume();
    }

    public static boolean isValidInput(String input) {
        return !input.isEmpty() && !input.isBlank();
    }

    public void setPriceFilter(JTextField input, Runnable event) {
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String i = input.getText();
                char c = e.getKeyChar();
                if (Character.isDigit(c) || c == ',' || c == '.' || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (c == '.' || c == ',') {
                        e.setKeyChar(',');
                        if (input.getText().isBlank() || input.getText().contains(","))
                            e.consume();
                    }
                    if (c == '0' && input.getText().equals("$ 0")) {
                        e.consume();
                    }
                } else
                    e.consume();
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {
                event.run();
            }
        });
    }

}