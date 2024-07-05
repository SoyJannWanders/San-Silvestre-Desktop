package com.sansilvestre.desktop.app.util.load;

import com.sansilvestre.desktop.app.util.ui.component.spinner.SpinnerProgress;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;

public class LoadingView extends javax.swing.JPanel {

    public LoadingView() {
        initComponents();
        LoadingViewBuilder builder = new LoadingViewBuilder();
        builder.build(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spinner = new SpinnerProgress();

        setPreferredSize(new java.awt.Dimension(128, 128));
        setLayout(new java.awt.GridBagLayout());

        spinner.setIndeterminate(true);
        spinner.setPreferredSize(new java.awt.Dimension(64, 64));
        add(spinner, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SpinnerProgress spinner;
    // End of variables declaration//GEN-END:variables

    private static class LoadingViewBuilder {

        public void build(JPanel parent) {

            Styles.setStyleTo(parent, "container.variant");

        }

    }

}