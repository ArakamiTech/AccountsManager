package com.arakamitech.accountsmanager.view.swing;

import com.arakamitech.accountsmanager.logic.conection.ManagerConectionBD;
import com.arakamitech.accountsmanager.logic.dto.ClavesDto;
import com.arakamitech.accountsmanager.view.components.ButtonEditor;
import com.arakamitech.accountsmanager.view.components.ButtonRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 * @author cristhian
 */
public class FormTable extends javax.swing.JPanel {

    @Serial
    private static final long serialVersionUID = 1L;
    int isEdit = 0;
    private int editingRow = -1;

    public FormTable(String group) throws SQLException {
        initComponents();
        try {
            managerConectionBD = ManagerConectionBD.getInstance();
        } catch (SQLException e) {
            LOGGER.severe("Error Inicializando ManagerConectionBD: " + e.getMessage());
        }

        editButton = new com.arakamitech.accountsmanager.view.components.Button();
        javax.swing.ImageIcon editIcon = new javax.swing.ImageIcon("src/main/java/com/arakamitech/accountsmanager/view/icons/Edit.PNG");
        editButton.setIcon(editIcon);

        deleteButton = new com.arakamitech.accountsmanager.view.components.Button();
        javax.swing.ImageIcon deleteIcon = new javax.swing.ImageIcon("src/main/java/com/arakamitech/accountsmanager/view/icons/Delete.PNG");
        deleteButton.setIcon(deleteIcon);

        jScrollPane1.setVerticalScrollBar(new JScrollBar());
        jScrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        jScrollPane1.setCorner(javax.swing.ScrollPaneConstants.UPPER_RIGHT_CORNER, panel);

        addRow(group);
        jLabelTitle.setText("Cuentas Guardadas de " + group);
        table.setRowHeight(50);

        table.getColumn("Edit").setCellRenderer(new ButtonRenderer());
        table.getColumn("Edit").setCellEditor(new ButtonEditor(e -> {
            int selectedRow = table.getSelectedRow();
            System.out.println((Integer) table.getValueAt(selectedRow, 0));
            System.out.println((String) table.getValueAt(selectedRow, 2));
            System.out.println((String) table.getValueAt(selectedRow, 3));
            System.out.println((String) table.getValueAt(selectedRow, 4));
            System.out.println((String) table.getValueAt(selectedRow, 5));
            System.out.println((String) table.getValueAt(selectedRow, 1));
            ClavesDto clavesDto = ClavesDto.builder()
                    .user((String) table.getValueAt(selectedRow, 2))
                    .email((String) table.getValueAt(selectedRow, 3))
                    .password((String) table.getValueAt(selectedRow, 4))
                    .description((String) table.getValueAt(selectedRow, 5))
                    .nameApplication((String) table.getValueAt(selectedRow, 1))
                    //.iv((String) table.getValueAt(selectedRow, 5))
                    //.key((String) table.getValueAt(selectedRow, 7))
                    .build();
            managerConectionBD.editRegister(clavesDto);
            table.repaint();
        }));

        table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
        table.getColumn("Delete").setCellEditor(new ButtonEditor(e ->
        {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String nameApplication = (String) table.getValueAt(selectedRow, 1);
                String user = (String) table.getValueAt(selectedRow, 2);
                String email = (String) table.getValueAt(selectedRow, 3);
                String password = (String) table.getValueAt(selectedRow, 4);
                String description = (String) table.getValueAt(selectedRow, 5);
                managerConectionBD.deleteRegister(nameApplication, user, email, password, description);
            }
            table.repaint();
        }));
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.arakamitech.accountsmanager.view.swing.PanelBorder();
        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new com.arakamitech.accountsmanager.view.swing.Table();

        setBackground(new java.awt.Color(204, 204, 204));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitle.setBackground(new java.awt.Color(127, 127, 127));
        jLabelTitle.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jScrollPane1.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Aplicación", "Usuario", "Correo", "Contraseña", "Descripción", "Key", "Iv", "Edit", "Delete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(1).setMinWidth(120);
            table.getColumnModel().getColumn(1).setPreferredWidth(120);
            table.getColumnModel().getColumn(1).setMaxWidth(120);
            table.getColumnModel().getColumn(2).setMinWidth(120);
            table.getColumnModel().getColumn(2).setPreferredWidth(120);
            table.getColumnModel().getColumn(2).setMaxWidth(120);
            table.getColumnModel().getColumn(3).setMinWidth(120);
            table.getColumnModel().getColumn(3).setPreferredWidth(120);
            table.getColumnModel().getColumn(3).setMaxWidth(120);
            table.getColumnModel().getColumn(6).setMinWidth(0);
            table.getColumnModel().getColumn(6).setPreferredWidth(0);
            table.getColumnModel().getColumn(6).setMaxWidth(0);
            table.getColumnModel().getColumn(7).setMinWidth(0);
            table.getColumnModel().getColumn(7).setPreferredWidth(0);
            table.getColumnModel().getColumn(7).setMaxWidth(0);
            table.getColumnModel().getColumn(8).setMinWidth(20);
            table.getColumnModel().getColumn(8).setPreferredWidth(20);
            table.getColumnModel().getColumn(8).setMaxWidth(20);
            table.getColumnModel().getColumn(9).setMinWidth(20);
            table.getColumnModel().getColumn(9).setPreferredWidth(20);
            table.getColumnModel().getColumn(9).setMaxWidth(20);
        }

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelTitle))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private com.arakamitech.accountsmanager.view.swing.PanelBorder panelBorder1;
    private com.arakamitech.accountsmanager.view.swing.Table table;
    // End of variables declaration//GEN-END:variables

    private static final Logger LOGGER = Logger.getLogger("FormHome");
    private JButton editButton;
    private JButton deleteButton;
    private ManagerConectionBD managerConectionBD;

    public void addRow(String group) throws SQLException {
        LOGGER.info("Inicio metodo addRow llenando la tabla");
        var clavesDtoList = managerConectionBD.getClaves(group);
        for (ClavesDto clavesDto : clavesDtoList) {
            LOGGER.info("Inicio metodo addRow llenando la tabla");
            table.addRow(new Object[]{
                    clavesDto.getIdClaves(),
                    clavesDto.getNameApplication(),
                    clavesDto.getUser(),
                    clavesDto.getEmail(),
                    clavesDto.getPassword(),
                    clavesDto.getDescription(),
                    clavesDto.getKey(),
                    clavesDto.getIv(),
                    add(editButton),
                    add(deleteButton)
            });
        }
        LOGGER.info("Fin metodo addRow llenando la tabla");
    }

}
