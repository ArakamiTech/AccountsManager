package com.arakamitech.accountsmanager.view.components;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

    private final com.arakamitech.accountsmanager.view.components.Button button;

    public ButtonEditor(ActionListener actionListener) {
        button = new com.arakamitech.accountsmanager.view.components.Button();
        button.setOpaque(true);
        button.addActionListener(actionListener);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (value instanceof JButton) {
            JButton originalButton = (JButton) value;
            button.setIcon(originalButton.getIcon());
            button.setBackground(originalButton.getBackground());

            button.setPreferredSize(new Dimension(40, 20));
        }
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button;
    }
}
