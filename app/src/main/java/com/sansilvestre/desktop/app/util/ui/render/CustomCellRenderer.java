package com.sansilvestre.desktop.app.util.ui.render;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {

    private final DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

    public CustomCellRenderer() {
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Alinea las celdas de las columnas 0, 2 y 3 al centro
        if (column == 0 || column == 2 || column == 5) {
            return centerRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

        if (column == 1) {
            setHorizontalAlignment(SwingConstants.LEFT);
        }

        // Alinea las celdas de las columnas 4 y 5 a la derecha
        if (column == 3 || column == 4) {
            setHorizontalAlignment(SwingConstants.RIGHT);
        }

        return component;
    }

}