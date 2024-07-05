package com.sansilvestre.desktop.app.util.filter;

import com.sansilvestre.desktop.app.product.util.Billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Filter {

    private final Billing billing = new Billing();

    public enum Type {
        SELECT,
        ALPHABETICAL,
        NUMERIC,
        CURRENCY
    }

    public void setTo(Component in) {
        in.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!isAllowedKey(e))
                    e.consume();
            }
            @Override
            public void keyTyped(KeyEvent e) {
                if (!isAllowedKey(e))
                    e.consume();
            }

            private boolean isAllowedKey(KeyEvent e) {
                int keyCode = e.getKeyCode();
                return keyCode == KeyEvent.VK_F1;
            }

        });
    }

    public void setTo(JComponent in, Type type) {
        in.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (type) {
                    case ALPHABETICAL ->
                            applyAlphabeticalFilter(e);
                    case NUMERIC ->
                            applyNumericFilter(e);
                    case CURRENCY -> {}
                }
            }
        });
    }

    public void filterForName(JTextField in) {
        in.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int c = e.getKeyChar();
                if (!Character.isAlphabetic(c) && c != ' ')
                    e.consume();
            }

        });
    }

    public void filterForAddress(JTextField in) {
        in.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int c = e.getKeyChar();
                if (!Character.isAlphabetic(c) && !Character.isDigit(c) && c != ' ' && c != '.')
                    e.consume();
            }

        });
    }

    public void filterForPhone(JTextField in) {
        in.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()))
                    e.consume();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String text = in.getText().replaceAll("[^\\d]", "");
                StringBuilder formatted = new StringBuilder();

                int length = text.length();
                if (length > 0) {
                    formatted.append('(');
                    formatted.append(text.substring(0, Math.min(3, length)));
                    if (length >= 3) {
                        formatted.append(") ");
                        if (length >= 4) {
                            formatted.append(text.substring(3, Math.min(5, length)));
                            if (length >= 5) {
                                formatted.append('-');
                                if (length > 5) {
                                    formatted.append(text.substring(5, Math.min(9, length)));
                                }
                            }
                        } else {
                            formatted.append(text.substring(3));
                        }
                    } else {
                        formatted.append(text.substring(0));
                    }
                }

                // Remove the key listener to prevent infinite loop
                in.removeKeyListener(this);
                // Update the text field with the formatted text
                in.setText(formatted.toString());
                // Set the caret position to the end of the text
                in.setCaretPosition(in.getText().length());
                // Re-add the key listener
                in.addKeyListener(this);
            }

        });
    }

    public void setBarcode(JTextField in) {
        in.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int c = e.getKeyChar();
                if (!Character.isDigit(c))
                    e.consume();
            }

        });
    }

    public void setItemSearch(JTextField in) {
        in.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int c = e.getKeyChar();
                if (!Character.isDigit(c) && !Character.isAlphabetic(c))
                    e.consume();
            }

        });
    }

    public void putCurrencyControlIn(JTextField in) {
        in.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String currency = in.getText();
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
            @Override
            public void keyReleased(KeyEvent e) {
                billing.build(in.getText());
                in.setText(billing.getInput());
            }
        });
    }

    private void applyAlphabeticalFilter(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar()))
            e.consume();
    }

    private void applyNumericFilter(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar()))
            e.consume();
    }

    public static boolean isValidInput(String input) {
        return !input.isEmpty() && !input.isBlank();
    }

}