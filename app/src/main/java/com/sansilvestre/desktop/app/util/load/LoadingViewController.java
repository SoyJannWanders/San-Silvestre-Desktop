package com.sansilvestre.desktop.app.util.load;

import javax.swing.*;

public class LoadingViewController {

    private static LoadingViewController instance;

    private JDialog view;

    private LoadingViewController() {}

    public static synchronized LoadingViewController getInstance() {
        if (instance == null)
            instance = new LoadingViewController();
        return instance;
    }

    public void setHost(JFrame host) {
        if (host == null)
            throw new IllegalStateException();
        if (view != null)
            view.dispose();
        SwingUtilities.invokeLater(() -> {
            view = new JDialog(host, null, true);
            view.setUndecorated(true);
            view.setSize(128, 128);
            view.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            view.setLocationRelativeTo(host);
            view.add(new LoadingView());
        });
    }

    public void showLoading() {
        if (view == null)
            throw new IllegalStateException();
        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }

    public void hideLoading() {
        if (view == null)
            throw new IllegalStateException();
        SwingUtilities.invokeLater(() -> view.dispose());
    }

}