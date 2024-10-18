package com.arakamitech.accountsmanager.view.swing;

import com.arakamitech.accountsmanager.logic.conection.ManagerConectionBD;
import com.arakamitech.accountsmanager.logic.dto.ClavesDto;

import java.awt.*;
import java.io.Serial;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Collections;
import java.util.Objects;
import java.util.logging.Level;
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
import javax.swing.JOptionPane;

/**
 * @author cristhian
 */
public class FormCreate extends javax.swing.JPanel {

    @Serial
    private static final long serialVersionUID = 1L;

    public FormCreate() {
        try {
            initComponents();
            jComboBoxGroup.setSelectedIndex(0);
            jLabelTitle.setText("Creacion de Contraseñas ");
            jLabelTitle.setBackground(new java.awt.Color(127, 127, 127));
            jLabelTitle.setFont(new java.awt.Font(SANSSERIF, Font.PLAIN, 18));
            panelBorderConfigrations.setVisible(isVisible);
            jLabelMinLength.setText(String.valueOf(jSliderMinLength.getValue()));
            jLabelMaxLength.setText(String.valueOf(jSliderMaxLength.getValue()));
            jLabelnumUpperCase.setText(String.valueOf(jSliderNumUpperCase.getValue()));
            ManagerConectionBD managerConectionBD = ManagerConectionBD.getInstance();
            var listGroup = managerConectionBD.getRegisterByGroup();
            for (var group : listGroup) {
                jComboBoxGroup.addItem(group);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormCreate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error obteniendo datos por grupo", ALERT, JOptionPane.ERROR_MESSAGE);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        com.arakamitech.accountsmanager.view.swing.PanelBorder panelBorder1;
        javax.swing.JLabel jLabel8;
        javax.swing.JLabel jLabel9;
        javax.swing.JLabel jLabel7;
        javax.swing.JLabel jLabel6;
        javax.swing.JLabel jLabel5;
        javax.swing.JLabel jLabel4;
        javax.swing.JLabel jLabel11;
        javax.swing.JLabel jLabel10;
        javax.swing.JLabel jLabel1;
        javax.swing.JCheckBox jCheckBoxSpecialChars;
        javax.swing.JButton jButtonGenerate;
        javax.swing.JButton jButtonCreate;
        panelBorder1 = new com.arakamitech.accountsmanager.view.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        jLabelGroupName = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jTextFieldApplication = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jComboBoxGroup = new javax.swing.JComboBox<>();
        jLabelTitle = new javax.swing.JLabel();
        javax.swing.JCheckBox jCheckBoxConfigurations = new javax.swing.JCheckBox();
        jButtonCreate = new javax.swing.JButton();
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
        jLabel11 = new javax.swing.JLabel();
        jTextFieldDescription = new javax.swing.JTextField();
        jTextFieldGroupName = new javax.swing.JTextField();

        setBackground(new java.awt.Color(242, 242, 242));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGroupName.setEnabled(false);
        jTextFieldGroupName.setEnabled(false);
        jLabel1.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel1.setText("Grupo");

        jLabel2.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel2.setText("Aplicación");

        jLabelGroupName.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabelGroupName.setText("Nombre Grupo");

        jLabel3.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel3.setText("Usuario");

        jLabel4.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel4.setText("Correo");

        jLabel5.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel5.setText("Contraseña");

        jTextFieldUser.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N

        jTextFieldApplication.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N

        jPasswordField.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jPasswordField.setText("jPasswordField1");

        jComboBoxGroup.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N

        jLabelTitle.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabelTitle.setText("jLabel6");

        jCheckBoxConfigurations.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jCheckBoxConfigurations.setText("Configuración");
        jCheckBoxConfigurations.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxConfigurationsMouseClicked();
            }
        });

        jButtonCreate.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jButtonCreate.setText("Crear");
        jButtonCreate.addActionListener(evt -> jButtonCreateActionPerformed());

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
        jButtonGenerate.addActionListener(evt -> {
            try {
                jButtonGenerateActionPerformed();
            } catch (InvalidAlgorithmParameterException | BadPaddingException | InvalidKeyException e) {
               return;
            }
        });
        jPasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldMouseClicked();
            }
        });
        jComboBoxGroup.addItem("Otro");
        jComboBoxGroup.addActionListener(evt -> jComboBoxGroupActionPerformed());
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
                                                                .addComponent(jTextFieldExcludeSpecialChars, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
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

        jLabel11.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N
        jLabel11.setText("Descripción");

        jTextFieldDescription.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N

        jTextFieldGroupName.setFont(new java.awt.Font(SANSSERIF, Font.BOLD, 14)); // NOI18N

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(321, 321, 321)
                                .addComponent(jButtonCreate)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelBorderConfigrations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabelTitle)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabelGroupName))
                                                .addGap(90, 90, 90)
                                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldUser)
                                                        .addComponent(jTextFieldApplication)
                                                        .addComponent(jComboBoxGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldEmail)
                                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                                                .addComponent(jPasswordField)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jCheckBoxConfigurations))
                                                        .addComponent(jTextFieldDescription)
                                                        .addComponent(jTextFieldGroupName))))
                                .addGap(28, 28, 28))
        );
        panelBorder1Layout.setVerticalGroup(
                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitle)
                                .addGap(20, 20, 20)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jComboBoxGroup))
                                .addGap(20, 20, 20)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelGroupName)
                                        .addComponent(jTextFieldGroupName))
                                .addGap(20, 20, 20)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextFieldApplication))
                                .addGap(20, 20, 20)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldUser)
                                        .addComponent(jLabel3))
                                .addGap(20, 20, 20)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jCheckBoxConfigurations)))
                                .addGap(20, 20, 20)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(panelBorderConfigrations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jButtonCreate)
                                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordFieldMouseClicked() {
        jPasswordField.setText("");
    }

    private void jButtonCreateActionPerformed() {
        try {
            ManagerConectionBD managerConectionBD = ManagerConectionBD.getInstance();
            if (jTextFieldApplication.getText().isEmpty() || jTextFieldUser.getText().isEmpty()
                    || jTextFieldEmail.getText().isEmpty() || jPasswordField.getPassword().length == 0
                    || jTextFieldDescription.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", ALERT, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            ClavesDto clavesDto = ClavesDto.builder()
                    .nameApplication(jTextFieldApplication.getText())
                    .user(jTextFieldUser.getText())
                    .email(jTextFieldEmail.getText())
                    .password(passwordB64 != null ? passwordB64 : Base64.getEncoder().encodeToString(new String(jPasswordField.getPassword()).getBytes(StandardCharsets.UTF_8)))
                    .description(jTextFieldDescription.getText())
                    .group(!Objects.requireNonNull(jComboBoxGroup.getSelectedItem()).toString().equals("Otro")
                            ? jComboBoxGroup.getSelectedItem().toString() : jTextFieldGroupName.getText())
                    .key(keyB64)
                    .iv(iVB64)
                    .build();
            managerConectionBD.createRegister(clavesDto);
            jTextFieldUser.setText("");
            jTextFieldApplication.setText("");
            jTextFieldEmail.setText("");
            jPasswordField.setText("");
            jTextFieldDescription.setText("");
            jTextFieldGroupName.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(FormCreate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error creando el registro", ALERT, JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jCheckBoxConfigurationsMouseClicked() {
        isVisible = !isVisible;
        panelBorderConfigrations.setVisible(isVisible);
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

    private void jComboBoxGroupActionPerformed() {
        if ("Otro".equals(jComboBoxGroup.getSelectedItem())) {
            jLabelGroupName.setEnabled(true);
            jTextFieldGroupName.setEnabled(true);
        } else {
            jLabelGroupName.setEnabled(false);
            jTextFieldGroupName.setEnabled(false);
        }
    }

    private void jButtonGenerateActionPerformed() throws InvalidAlgorithmParameterException, BadPaddingException, InvalidKeyException {// GEN-FIRST:event_jButtonGenerateActionPerformed
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
        jPasswordField.setText(maskedPassword);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables


    private javax.swing.JComboBox<String> jComboBoxGroup;


    private javax.swing.JLabel jLabelMaxLength;
    private javax.swing.JLabel jLabelMinLength;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelnumUpperCase;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JSlider jSliderMaxLength;
    private javax.swing.JSlider jSliderMinLength;
    private javax.swing.JSlider jSliderNumUpperCase;
    private javax.swing.JTextField jTextFieldApplication;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldExcludeSpecialChars;
    private javax.swing.JTextField jTextFieldGroupName;
    private javax.swing.JLabel jLabelGroupName;
    private javax.swing.JTextField jTextFieldUser;

    private com.arakamitech.accountsmanager.view.swing.PanelBorder panelBorderConfigrations;
    // End of variables declaration//GEN-END:variables

    private boolean isVisible = false;
    private boolean specialChars = true;
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:',.<>?/";
    private static final String SANSSERIF = "SansSerif";
    private static final String ALERT = "Alerta";
    private static final String INFORMATION = "Información";
    private final StringBuilder finalPassword = new StringBuilder();
    private String passwordB64;
    private String keyB64;
    private String iVB64;

}
