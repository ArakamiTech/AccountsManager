package com.arakamitech.accountsmanager.view.components;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.Dimension;

public class ButtonRenderer extends com.arakamitech.accountsmanager.view.components.Button implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        if (value instanceof JButton) {
            JButton button = (JButton) value;
            setText(button.getText());
            setIcon(button.getIcon());

            setPreferredSize(new Dimension(40, 20));
            setHorizontalAlignment(JButton.CENTER);
        }
        return this;
    }

}
