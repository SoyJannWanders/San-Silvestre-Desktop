package com.sansilvestre.desktop.app.product.add;

import com.sansilvestre.desktop.app.product.add.screen.AddProductScreen;

import javax.swing.*;
import java.awt.*;

public class AddProductWindow extends JFrame {

    private static AddProductWindow instance;

    private final short MIN_WIDTH = 384;
    private final short MIN_HEIGHT = 576;

    public AddProductWindow() {
        setSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(new AddProductScreen());
        pack();
    }

    public static AddProductWindow getInstance() {
        if (instance == null)
            instance = new AddProductWindow();
        return instance;
    }

    public void invoke() {
        EventQueue.invokeLater(() -> new AddProductWindow().setVisible(true));
    }

}