package com.sansilvestre.desktop.app;

import com.sansilvestre.desktop.app.util.ui.window.error.ErrorScreen;
import com.sansilvestre.desktop.app.util.load.LoadingView;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewStateController {

    private App app;
    private JDialog loadingView;
    private JDialog failureView;

    private final AtomicInteger loadingCounter = new AtomicInteger(0);

    private ViewStateController() {}

    private static final class InstanceHolder {
        private static final ViewStateController instance = new ViewStateController();
    }

    public static ViewStateController getInstance() {
        return InstanceHolder.instance;
    }

    public void initApp(App app) {
        this.app = app;
    }

    public void isLoading() {
        if (loadingCounter.getAndIncrement() == 0) {
            SwingUtilities.invokeLater(() -> {
                if (loadingView == null) {
                    loadingView = new JDialog(app, null, true);
                    loadingView.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    loadingView.setUndecorated(true);
                    loadingView.setResizable(false);
                    loadingView.add(new LoadingView());
                    loadingView.pack();
                    loadingView.setLocationRelativeTo(app);
                }
                loadingView.setVisible(true);
            });
        }
    }

    public void isSuccess() {
        SwingUtilities.invokeLater(() -> {
            if (loadingCounter.decrementAndGet() <= 0) {
                loadingCounter.set(0);
                if (loadingView != null && loadingView.isShowing())
                    loadingView.dispose();
            }
        });
    }

    public void isFailure(Exception e) {
        SwingUtilities.invokeLater(() -> {
            if (loadingCounter.decrementAndGet() <= 0) {
                loadingCounter.set(0);
                if (loadingView != null && loadingView.isShowing())
                    loadingView.dispose();
                if (failureView == null) {
                    failureView = new JDialog(app, null, true);
                    failureView.setIconImage(new ImageIcon(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)).getImage());
                    failureView.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    failureView.setResizable(false);
                }
                failureView.getContentPane().removeAll();
                failureView.add(new ErrorScreen(e));
                failureView.pack();
                failureView.setLocationRelativeTo(app);
                failureView.setVisible(true);
            }
        });
    }

}