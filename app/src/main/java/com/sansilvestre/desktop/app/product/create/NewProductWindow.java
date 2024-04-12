package com.sansilvestre.desktop.app.product.create;

import com.sansilvestre.desktop.app.product.create.screen.AddProductScreen;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class NewProductWindow extends JFrame {

    private static NewProductWindow instance;

    private final short MIN_WIDTH = 384;
    private final short MIN_HEIGHT = 576;

    public NewProductWindow() {
        setSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(new AddProductScreen());
        pack();
    }

    public static NewProductWindow getInstance() {
        if (instance == null)
            instance = new NewProductWindow();
        return instance;
    }

    public void invoke() {
        EventQueue.invokeLater(() -> new NewProductWindow().setVisible(true));
    }

}