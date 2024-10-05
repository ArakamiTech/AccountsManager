package com.arakamitech.accountsmanager.view.swing;

import com.arakamitech.accountsmanager.logic.conection.ManagerConectionBD;
import com.arakamitech.accountsmanager.logic.dto.ClavesDto;

import java.awt.*;
import java.io.Serial;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 *
 * @author cristhian
 */
public class FormHome extends javax.swing.JPanel {

	@Serial
	private static final long serialVersionUID = 1L;

	public FormHome(String group) throws SQLException {
		initComponents();
		jScrollPane1.setVerticalScrollBar(new JScrollBar());
		jScrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
		jScrollPane1.getViewport().setBackground(Color.WHITE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		jScrollPane1.setCorner(javax.swing.ScrollPaneConstants.UPPER_RIGHT_CORNER, panel);
		addRow(group);
		jLabelTitle.setText("Cuentas Guardadas de " + group);
	}

	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		final com.arakamitech.accountsmanager.view.swing.PanelBorder panelBorder1;
		panelBorder1 = new com.arakamitech.accountsmanager.view.swing.PanelBorder();
		jLabelTitle = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new com.arakamitech.accountsmanager.view.swing.Table();

		setBackground(new java.awt.Color(204, 204, 204));

		panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

		jLabelTitle.setBackground(new java.awt.Color(127, 127, 127));
		jLabelTitle.setFont(new java.awt.Font("SansSerif", Font.PLAIN, 18)); // NOI18N

		jScrollPane1.setBorder(null);

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Aplicación", "Usuario", "Correo", "Contraseña", "Descripción" }) {
			@Serial
			private static final long serialVersionUID = 1L;
			final boolean[] canEdit = new boolean[] { false, false, false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(table);

		javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
		panelBorder1.setLayout(panelBorder1Layout);
		panelBorder1Layout.setHorizontalGroup(panelBorder1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelBorder1Layout.createSequentialGroup()
						.addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(panelBorder1Layout.createSequentialGroup().addGap(20, 20, 20)
										.addComponent(jLabelTitle))
								.addGroup(panelBorder1Layout.createSequentialGroup().addContainerGap().addComponent(
										jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)))
						.addContainerGap()));
		panelBorder1Layout.setVerticalGroup(panelBorder1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelBorder1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(jLabelTitle)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(20, 20, 20).addComponent(panelBorder1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(20, 20, 20)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(panelBorder1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(20, 20, 20)));
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabelTitle;
	private javax.swing.JScrollPane jScrollPane1;
	private com.arakamitech.accountsmanager.view.swing.Table table;
	// End of variables declaration//GEN-END:variables

	private static final Logger LOGGER = Logger.getLogger("FormHome");

	public void addRow(String group) throws SQLException {
		LOGGER.info("Inicio metodo addRow llenando la tabla");
                ManagerConectionBD managerConectionBD = ManagerConectionBD.getInstance();
		var clavesDtoList = managerConectionBD.getClaves(group);
        for (ClavesDto clavesDto : clavesDtoList) {
            table.addRow(new Object[]{clavesDto.getNameApplication(), clavesDto.getUser(),
                    clavesDto.getEmail(), clavesDto.getPassword(),
                    clavesDto.getDescription()});
        }
		LOGGER.info("Inicio metodo addRow llenando la tabla");
	}

}
