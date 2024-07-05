package com.sansilvestre.desktop.app.util.ui.window.error;

import com.sansilvestre.desktop.app.NavigationController;
import com.sansilvestre.desktop.app.NavigationData;
import com.sansilvestre.desktop.app.util.ui.Styles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ErrorScreen extends javax.swing.JPanel {

    private final Screen screen = new Screen();
    private final Shortcut shortcut = new Shortcut();

    private final Exception e;

    public ErrorScreen(Exception e) {
        this.e = e;
        initComponents();
        setup();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeadline = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        btnDispose = new javax.swing.JButton();
        lblDetail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetail = new javax.swing.JTextPane();

        setPreferredSize(new java.awt.Dimension(384, 259));

        lblHeadline.setText("Ups! Lo sentimos");

        lblMessage.setText("-");
        lblMessage.setMaximumSize(new java.awt.Dimension(448, 16));
        lblMessage.setPreferredSize(new java.awt.Dimension(336, 16));

        btnDispose.setText("Accept");
        btnDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisposeActionPerformed(evt);
            }
        });

        lblDetail.setText("Detalles");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(128, 48));

        txtDetail.setPreferredSize(new java.awt.Dimension(62, 32));
        jScrollPane1.setViewportView(txtDetail);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnDispose)
                    .addComponent(lblHeadline, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDetail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblHeadline)
                .addGap(8, 8, 8)
                .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnDispose)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setup() {
        screen.assembleComponents();
        screen.initializeListeners();
        shortcut.configure(this);
    }

    private void btnDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisposeActionPerformed
        dispose();
    }//GEN-LAST:event_btnDisposeActionPerformed

    private void dispose() {
        NavigationController.getInstance().navigate(NavigationController.Route.DISPOSE_SCREEN, new NavigationData(
                new Object[] { this }, new Class[] { JPanel.class }
        ));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDispose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTextPane txtDetail;
    // End of variables declaration//GEN-END:variables

    public class Screen {

        public void assembleComponents() {

            Random random = new Random();

            List<String> headlines = new ArrayList<>();
            headlines.add("Ups...");
            headlines.add("Ups! Lo sentimos");
            headlines.add("Ups! Algo anda mal");
            headlines.add("¿Qué hiciste?");
            headlines.add("Oh vaya...");

            Styles.setStyleTo(lblHeadline, "headline.small");
            lblHeadline.setText(headlines.get(random.nextInt(headlines.size())));

            Styles.setStyleTo(lblMessage, "body.small");

            lblMessage.setText(e.getMessage());

            Styles.setStyleTo(lblDetail, "label.small");

            txtDetail.setText(e.toString());

            Styles.setStyleTo(btnDispose, "button.outline.danger");

        }

        public void initializeListeners() {

            txtDetail.addKeyListener(new KeyAdapter() {

                @Override
                public void keyPressed(KeyEvent e) {
                    e.consume();
                }

                @Override
                public void keyTyped(KeyEvent e) {
                    e.consume();
                }

            });

        }

    }

    private class Shortcut {

        public void configure(JComponent component) {

            InputMap input = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = component.getActionMap();

            final String DISPOSE = "dispose";
            input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), DISPOSE);
            actionMap.put(DISPOSE, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

        }

    }

}
