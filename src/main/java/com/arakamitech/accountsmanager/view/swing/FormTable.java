package com.arakamitech.accountsmanager.view.swing;

import com.arakamitech.accountsmanager.logic.conection.ManagerConectionBD;
import com.arakamitech.accountsmanager.logic.dto.ClavesDto;
import com.arakamitech.accountsmanager.view.components.ButtonEditor;
import com.arakamitech.accountsmanager.view.components.ButtonRenderer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serial;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 * @author cristhian
 */
public class FormTable extends javax.swing.JPanel {

    @Serial
    private static final long serialVersionUID = 1L;

    public FormTable(String group) throws SQLException {
        initComponents();
        try {
            managerConectionBD = ManagerConectionBD.getInstance();
        } catch (SQLException e) {
            LOGGER.severe("Error Inicializando ManagerConectionBD: " + e.getMessage());
        }
        panelBorderConfigrations.setVisible(false);
        jLabelMinLength.setText(String.valueOf(jSliderMinLength.getValue()));
        jLabelMaxLength.setText(String.valueOf(jSliderMaxLength.getValue()));
        jLabelnumUpperCase.setText(String.valueOf(jSliderNumUpperCase.getValue()));

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
            ClavesDto clavesDto = ClavesDto.builder()
                    .user((String) table.getValueAt(selectedRow, 2))
                    .email((String) table.getValueAt(selectedRow, 3))
                    .password(passwordB64)
                    .description((String) table.getValueAt(selectedRow, 5))
                    .nameApplication((String) table.getValueAt(selectedRow, 1))
                    .iv((String) table.getValueAt(selectedRow, 6))
                    .key((String) table.getValueAt(selectedRow, 7))
                    .build();
            managerConectionBD.editRegister(clavesDto);
            table.repaint();
        }));

        table.getColumn(DELETE).setCellRenderer(new ButtonRenderer());
        table.getColumn(DELETE).setCellEditor(new ButtonEditor(e
                -> {
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
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = table.columnAtPoint(e.getPoint());

                // Verifica si se hizo clic en la columna "Contraseña"
                if (column == table.getColumnModel().getColumnIndex("Contraseña")) {
                    int selectedRow = table.getSelectedRow();
                    panelBorderConfigrations.setVisible(true);
                    jButtonGenerate.addActionListener(evt -> {
                        try {
                            jButtonGenerateActionPerformed(selectedRow);
                        } catch (InvalidAlgorithmParameterException | BadPaddingException | InvalidKeyException err) {
                            return;
                        }
                    });
                }
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        com.arakamitech.accountsmanager.view.swing.PanelBorder panelBorder1;
        javax.swing.JCheckBox jCheckBoxSpecialChars;
        javax.swing.JLabel jLabel10;
        javax.swing.JLabel jLabel6;
        javax.swing.JLabel jLabel7;
        javax.swing.JLabel jLabel8;
        javax.swing.JLabel jLabel9;

        panelBorder1 = new com.arakamitech.accountsmanager.view.swing.PanelBorder();
        jLabelTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new com.arakamitech.accountsmanager.view.swing.Table();
        panelBorderConfigrations = new com.arakamitech.accountsmanager.view.swing.PanelBorder();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCheckBoxSpecialChars = new javax.swing.JCheckBox();
        jSliderMinLength = new javax.swing.JSlider();
        jSliderMaxLength = new javax.swing.JSlider();
        jSliderNumUpperCase = new javax.swing.JSlider();
        jLabelMinLength = new javax.swing.JLabel();
        jLabelMaxLength = new javax.swing.JLabel();
        jLabelnumUpperCase = new javax.swing.JLabel();
        jTextFieldExcludeSpecialChars = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButtonGenerate = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitle.setBackground(new java.awt.Color(127, 127, 127));
        jLabelTitle.setFont(new java.awt.Font(SANSSERIF, Font.PLAIN, 18)); // NOI18N

        jScrollPane1.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Aplicación", "Usuario", "Correo", "Contraseña", "Descripción", "Key", "Iv", "Edit", DELETE
            }
        ) {
            final Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            final boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false, false, false, true, true
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
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

        panelBorderConfigrations.setBackground(new java.awt.Color(151, 196, 227));

        jLabel6.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel6.setText("Tamaño mínimo");

        jLabel7.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel7.setText("tamaño máximo");

        jLabel8.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel8.setText("Cantidad de Mayúsculas");

        jLabel9.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel9.setText("Excluir Caracteres Especiales");

        jCheckBoxSpecialChars.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jCheckBoxSpecialChars.setText("Todos");
        jCheckBoxSpecialChars.addActionListener(evt -> jCheckBoxSpecialCharsActionPerformed());

        jSliderMinLength.addChangeListener(evt -> jSliderMinLengthStateChanged());

        jSliderMaxLength.addChangeListener(evt -> jSliderMaxLengthStateChanged());

        jSliderNumUpperCase.addChangeListener(evt -> jSliderNumUpperCaseStateChanged());

        jLabelMinLength.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N

        jLabelMaxLength.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N

        jLabelnumUpperCase.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N

        jTextFieldExcludeSpecialChars.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel10.setText("Caracteres Ignorados");

        jButtonGenerate.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jButtonGenerate.setText("Generar");

        javax.swing.GroupLayout panelBorderConfigrationsLayout = new javax.swing.GroupLayout(panelBorderConfigrations);
        panelBorderConfigrations.setLayout(panelBorderConfigrationsLayout);
        panelBorderConfigrationsLayout.setHorizontalGroup(
            panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderConfigrationsLayout.createSequentialGroup()
                .addGroup(panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorderConfigrationsLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(20, 20, 20)
                        .addGroup(panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorderConfigrationsLayout.createSequentialGroup()
                                .addComponent(jCheckBoxSpecialChars)
                                .addGap(20, 20, 20)
                                .addComponent(jTextFieldExcludeSpecialChars)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel10))
                            .addGroup(panelBorderConfigrationsLayout.createSequentialGroup()
                                .addGroup(panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSliderNumUpperCase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSliderMinLength, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSliderMaxLength, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addGroup(panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMinLength, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelMaxLength, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelnumUpperCase, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(panelBorderConfigrationsLayout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jButtonGenerate)))
                .addGap(20, 20, 20))
        );
        panelBorderConfigrationsLayout.setVerticalGroup(
            panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderConfigrationsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jSliderMinLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMinLength))
                .addGap(20, 20, 20)
                .addGroup(panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSliderMaxLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMaxLength))
                .addGap(20, 20, 20)
                .addGroup(panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jSliderNumUpperCase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelnumUpperCase))
                .addGap(20, 20, 20)
                .addGroup(panelBorderConfigrationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCheckBoxSpecialChars)
                    .addComponent(jTextFieldExcludeSpecialChars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(20, 20, 20)
                .addComponent(jButtonGenerate)
                .addContainerGap(20, Short.MAX_VALUE))
        );

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
                        .addComponent(jScrollPane1))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBorderConfigrations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorderConfigrations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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

    private void jButtonGenerateActionPerformed(int selectedRow) throws InvalidAlgorithmParameterException, BadPaddingException, InvalidKeyException {
        String iVB64;
        String keyB64;// GEN-FIRST:event_jButtonGenerateActionPerformed
        if (Integer.parseInt(jLabelMinLength.getText()) > Integer.parseInt(jLabelMaxLength.getText())) {
            JOptionPane.showMessageDialog(null, "La longitud mínima no puede ser mayor que la longitud máxima.", INFORMATION, JOptionPane.INFORMATION_MESSAGE);
        }
        if (Integer.parseInt(jLabelnumUpperCase.getText()) > Integer.parseInt(jLabelMinLength.getText())) {
            JOptionPane.showMessageDialog(null, "El número de mayúsculas no puede ser mayor que la longitud mínima.", INFORMATION, JOptionPane.INFORMATION_MESSAGE);
        }

        var random = new SecureRandom();
        var charPool = new StringBuilder(LOWERCASE + DIGITS);

        if (specialChars) {
            charPool.append(SPECIAL_CHARACTERS);
        }

        var filteredPool = charPool.toString().chars()
                .filter(c -> jTextFieldExcludeSpecialChars.getText().indexOf(c) == -1)
                .mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());

        var password = new StringBuilder();
        IntStream.range(0, Integer.parseInt(jLabelnumUpperCase.getText()))
                .forEach(i -> password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length()))));

        var remainingLength = Integer.parseInt(jLabelMinLength.getText()) - Integer.parseInt(jLabelMaxLength.getText());
        if (filteredPool.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El conjunto de caracteres disponible está vacío. Ajuste las configuraciones.", INFORMATION, JOptionPane.INFORMATION_MESSAGE);
        }

        IntStream.range(0, remainingLength)
                .forEach(i -> password.append(filteredPool.charAt(random.nextInt(filteredPool.length()))));

        var passwordList = password.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(passwordList, random);

        var finalLength = Integer.parseInt(jLabelMinLength.getText()) + random
                .nextInt(Integer.parseInt(jLabelMaxLength.getText()) - Integer.parseInt(jLabelMinLength.getText()) + 1);

        IntStream.range(0, finalLength).forEach(i -> {
            if (i < passwordList.size()) {
                finalPassword.append(passwordList.get(i));
            } else {
                finalPassword.append(filteredPool.charAt(random.nextInt(filteredPool.length())));
            }
        });
        var maskedPassword = "*".repeat(15);

        var secretKey = generateKey(128);
        if (secretKey == null) {
            JOptionPane.showMessageDialog(null, "Ha fallado la generacion de secret Key", ALERT, JOptionPane.ERROR_MESSAGE);
            return;
        }
        var keyBytes = secretKey.getEncoded();
        var iv = new byte[12];
        var secureRandom = new SecureRandom();
        secureRandom.nextBytes(iv);
        var encryptedPassword = encryptPassword(finalPassword.toString().getBytes(StandardCharsets.UTF_8), keyBytes, iv);
        passwordB64 = Base64.getEncoder().encodeToString(encryptedPassword);
        keyB64 = Base64.getEncoder().encodeToString(keyBytes);
        iVB64 = Base64.getEncoder().encodeToString(iv);
        if (selectedRow != -1) {
            table.setValueAt(maskedPassword, selectedRow, 4);
            table.setValueAt(keyB64, selectedRow, 6);
            table.setValueAt(iVB64, selectedRow, 7);
        }
    }

    public static SecretKey generateKey(int n) {
        try {
            var keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(n);
            return keyGen.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Error generando la Clave secreta", ALERT, JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static byte[] encryptPassword(byte[] password, byte[] keyBytes, byte[] iv) throws InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException {
        try {
            var cipher = Cipher.getInstance("AES/GCM/NoPadding");
            var secretKey = new SecretKeySpec(keyBytes, "AES");
            var gcmSpec = new GCMParameterSpec(128, iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmSpec);
            return cipher.doFinal(password);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException ex) {
            JOptionPane.showMessageDialog(null, "Error encriptando la contraseña", ALERT, JOptionPane.ERROR_MESSAGE);
            return new byte[0];
        }
    }

    private void jCheckBoxSpecialCharsActionPerformed() {
        specialChars = !specialChars;
    }

    private void jSliderMinLengthStateChanged() {
        jSliderMinLength.addChangeListener(e -> jLabelMinLength.setText(String.valueOf(jSliderMinLength.getValue())));
    }

    private void jSliderMaxLengthStateChanged() {
        jSliderMaxLength.addChangeListener(e -> jLabelMaxLength.setText(String.valueOf(jSliderMaxLength.getValue())));
    }

    private void jSliderNumUpperCaseStateChanged() {
        jSliderNumUpperCase.addChangeListener(e -> jLabelnumUpperCase.setText(String.valueOf(jSliderNumUpperCase.getValue())));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JLabel jLabelMaxLength;
    private javax.swing.JLabel jLabelMinLength;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelnumUpperCase;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderMaxLength;
    private javax.swing.JSlider jSliderMinLength;
    private javax.swing.JSlider jSliderNumUpperCase;
    private javax.swing.JTextField jTextFieldExcludeSpecialChars;
    private com.arakamitech.accountsmanager.view.swing.PanelBorder panelBorderConfigrations;
    private com.arakamitech.accountsmanager.view.swing.Table table;
    // End of variables declaration//GEN-END:variables

    private static final Logger LOGGER = Logger.getLogger("FormHome");
    private JButton editButton;
    private JButton deleteButton;
    private ManagerConectionBD managerConectionBD;
    private boolean specialChars = true;
    private static final String DELETE = "Delete";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:',.<>?/";
    private static final String SANSSERIF = "SansSerif";
    private static final String ALERT = "Alerta";
    private static final String INFORMATION = "Información";
    private final StringBuilder finalPassword = new StringBuilder();
    private String passwordB64;

    public void addRow(String group) {
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
