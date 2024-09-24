package com.arakamitech.accountsmanager.view.swing;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author cristhian
 */
public class FormCreate extends javax.swing.JPanel {

    public FormCreate() {
        initComponents();
        jLabelTitle.setText("Creacion de Contraseñas ");
        jLabelTitle.setBackground(new java.awt.Color(127, 127, 127));
        jLabelTitle.setFont(new java.awt.Font("SansSerif", 0, 18));
        panelBorderConfigrations.setVisible(visible);
        jLabelMinLength.setText(String.valueOf(jSliderMinLength.getValue()));
        jLabelMaxLength.setText(String.valueOf(jSliderMaxLength.getValue()));
        jLabelnumUpperCase.setText(String.valueOf(jSliderNumUpperCase.getValue()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelBorder1 = new com.arakamitech.accountsmanager.view.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jTextFieldApplication = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jComboBoxGroup = new javax.swing.JComboBox<>();
        jLabelTitle = new javax.swing.JLabel();
        jCheckBoxConfigurations = new javax.swing.JCheckBox();
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

        setBackground(new java.awt.Color(242, 242, 242));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Grupo");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Aplicación");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Correo");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Contraseña");

        jTextFieldUser.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jTextFieldApplication.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jPasswordField.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jPasswordField.setText("jPasswordField1");

        jComboBoxGroup.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jComboBoxGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelTitle.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabelTitle.setText("jLabel6");

        jCheckBoxConfigurations.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jCheckBoxConfigurations.setText("Configuración");
        jCheckBoxConfigurations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxConfigurationsMouseClicked(evt);
            }
        });

        jButtonCreate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButtonCreate.setText("Crear");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        panelBorderConfigrations.setBackground(new java.awt.Color(151, 196, 227));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Tamaño mínimo");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("tamaño máximo");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("Cantidad de Mayúsculas");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Excluir Caracteres Especiales");

        jCheckBoxSpecialChars.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jCheckBoxSpecialChars.setText("Todos");
        jCheckBoxSpecialChars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSpecialCharsActionPerformed(evt);
            }
        });

        jSliderMinLength.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderMinLengthStateChanged(evt);
            }
        });

        jSliderMaxLength.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderMaxLengthStateChanged(evt);
            }
        });

        jSliderNumUpperCase.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderNumUpperCaseStateChanged(evt);
            }
        });

        jLabelMinLength.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabelMinLength.setText("jLabel10");

        jLabelMaxLength.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabelMaxLength.setText("jLabel10");

        jLabelnumUpperCase.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabelnumUpperCase.setText("jLabel10");

        jTextFieldExcludeSpecialChars.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTextFieldExcludeSpecialChars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldExcludeSpecialCharsActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setText("Caracteres Ignorados");

        jButtonGenerate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButtonGenerate.setText("Generar");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabelTitle))
                        .addGap(90, 90, 90)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUser)
                            .addComponent(jTextFieldApplication)
                            .addComponent(jComboBoxGroup, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldEmail)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jPasswordField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxConfigurations)))))
                .addGap(28, 28, 28))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jButtonCreate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed

    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void jCheckBoxConfigurationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxConfigurationsMouseClicked
        if (visible) {
            visible = false;
        } else {
            visible = true;
        }
        panelBorderConfigrations.setVisible(visible);
    }//GEN-LAST:event_jCheckBoxConfigurationsMouseClicked

    private void jCheckBoxSpecialCharsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSpecialCharsActionPerformed
        if (specialChars) {
            specialChars = false;
        } else {
            specialChars = true;
        }
    }//GEN-LAST:event_jCheckBoxSpecialCharsActionPerformed

    private void jSliderMinLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderMinLengthStateChanged
        jSliderMinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jLabelMinLength.setText(String.valueOf(jSliderMinLength.getValue()));
            }
        });
    }//GEN-LAST:event_jSliderMinLengthStateChanged

    private void jSliderMaxLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderMaxLengthStateChanged
        jSliderMaxLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jLabelMaxLength.setText(String.valueOf(jSliderMaxLength.getValue()));
            }
        });
    }//GEN-LAST:event_jSliderMaxLengthStateChanged

    private void jSliderNumUpperCaseStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderNumUpperCaseStateChanged
        jSliderNumUpperCase.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jLabelnumUpperCase.setText(String.valueOf(jSliderNumUpperCase.getValue()));
            }
        });
    }//GEN-LAST:event_jSliderNumUpperCaseStateChanged

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        if (Integer.parseInt(jLabelMinLength.getText()) > Integer.parseInt(jLabelMaxLength.getText())) {
            throw new IllegalArgumentException("La longitud mínima no puede ser mayor que la longitud máxima.");
        }
        if (Integer.parseInt(jLabelnumUpperCase.getText()) > Integer.parseInt(jLabelMinLength.getText())) {
            throw new IllegalArgumentException("El número de mayúsculas no puede ser mayor que la longitud mínima.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder charPool = new StringBuilder(LOWERCASE + DIGITS);

        if (specialChars) {
            charPool.append(SPECIAL_CHARACTERS);
        }

        String filteredPool = charPool.toString().chars().filter(c -> jTextFieldExcludeSpecialChars.getText().indexOf(c) == -1)
                .mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());

        StringBuilder password = new StringBuilder();
        IntStream.range(0, Integer.parseInt(jLabelnumUpperCase.getText()))
                .forEach(i -> password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length()))));

        int remainingLength = Integer.parseInt(jLabelMinLength.getText()) - Integer.parseInt(jLabelMaxLength.getText());
        if (filteredPool.isEmpty()) {
            throw new IllegalStateException(
                    "El conjunto de caracteres disponible está vacío. Ajuste las configuraciones.");
        }

        IntStream.range(0, remainingLength)
                .forEach(i -> password.append(filteredPool.charAt(random.nextInt(filteredPool.length()))));

        List<Character> passwordList = password.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(passwordList, random);

        int finalLength = Integer.parseInt(jLabelMinLength.getText()) + random.nextInt(Integer.parseInt(jLabelMaxLength.getText()) - Integer.parseInt(jLabelMinLength.getText()) + 1);
        StringBuilder finalPassword = new StringBuilder();

        IntStream.range(0, finalLength).forEach(i -> {
            if (i < passwordList.size()) {
                finalPassword.append(passwordList.get(i));
            } else {
                finalPassword.append(filteredPool.charAt(random.nextInt(filteredPool.length())));
            }
        });
        String maskedPassword = "*".repeat(15);
        jPasswordField.setText(maskedPassword);

        System.out.println(finalPassword);

    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void jTextFieldExcludeSpecialCharsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldExcludeSpecialCharsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldExcludeSpecialCharsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JCheckBox jCheckBoxConfigurations;
    private javax.swing.JCheckBox jCheckBoxSpecialChars;
    private javax.swing.JComboBox<String> jComboBoxGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMaxLength;
    private javax.swing.JLabel jLabelMinLength;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelnumUpperCase;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JSlider jSliderMaxLength;
    private javax.swing.JSlider jSliderMinLength;
    private javax.swing.JSlider jSliderNumUpperCase;
    private javax.swing.JTextField jTextFieldApplication;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldExcludeSpecialChars;
    private javax.swing.JTextField jTextFieldUser;
    private com.arakamitech.accountsmanager.view.swing.PanelBorder panelBorder1;
    private com.arakamitech.accountsmanager.view.swing.PanelBorder panelBorderConfigrations;
    // End of variables declaration//GEN-END:variables

    private boolean visible = false;
    private boolean specialChars = true;
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

}
