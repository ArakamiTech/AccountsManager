package com.arakamitech.accountsmanager.view.components;

import com.arakamitech.accountsmanager.logic.conection.ManagerConectionBD;
import com.arakamitech.accountsmanager.logic.dto.ConnectionDto;
import com.arakamitech.accountsmanager.logic.enums.MenuType;
import com.arakamitech.accountsmanager.logic.event.EventMenuSelected;
import com.arakamitech.accountsmanager.logic.model.ModelMenu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author cristhian
 */
public class Menu extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

	public Menu() {
        initComponents();
        jLabelTitle.setIcon(new javax.swing.ImageIcon("src/main/java/com/arakamitech/accountsmanager/view/icons/Logo.jpg"));
        jButtonExit.setIcon(new javax.swing.ImageIcon("src/main/java/com/arakamitech/accountsmanager/view/icons/Salir.PNG"));
        jButtonExit.setBackground(Color.decode(BLUE_COLOR));
        jButtonExit.setForeground(Color.decode(BLUE_COLOR));
        listMenu1.setOpaque(false);
        setOpaque(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMoving = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        listMenu1 = new com.arakamitech.accountsmanager.logic.model.ListMenu<>();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jButtonExit = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(231, 800));

        jPanelMoving.setOpaque(false);

        jLabelTitle.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("AccountsManager");

        javax.swing.GroupLayout jPanelMovingLayout = new javax.swing.GroupLayout(jPanelMoving);
        jPanelMoving.setLayout(jPanelMovingLayout);
        jPanelMovingLayout.setHorizontalGroup(
            jPanelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMovingLayout.setVerticalGroup(
            jPanelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonExit.setBorder(null);
        jButtonExit.setMaximumSize(new java.awt.Dimension(48, 48));
        jButtonExit.setMinimumSize(new java.awt.Dimension(48, 48));
        jButtonExit.setPreferredSize(new java.awt.Dimension(48, 48));
        jButtonExit.addActionListener(this::jButtonExitActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(119, 119, 119))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode(BLUE_COLOR));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMoving;
    private com.arakamitech.accountsmanager.logic.model.ListMenu<String> listMenu1;
    // End of variables declaration//GEN-END:variables

    private int posX;
    private int posY;
    private List<String> listMenu = new ArrayList<>();
    private static final String BLUE_COLOR = "#000046";

    public void initMoving(JFrame frame) {
        jPanelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
            	posX = me.getX();
            	posY = me.getY();
            }
        });

        jPanelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(me.getXOnScreen() - posX, me.getYOnScreen() - posY);
            }
        });
    }

    public void init(ManagerConectionBD managerConectionBD, ConnectionDto connectionDto) {
        listMenu1.addItem(new ModelMenu("", "Gestion", MenuType.TITLE));
        listMenu1.addItem((new ModelMenu("Crear", "Crear", MenuType.MENU)));
        listMenu1.addItem(new ModelMenu("", "Claves", MenuType.TITLE));
        listMenu = managerConectionBD.getRegisterToMenu(connectionDto);
        for (int i = 0; i < listMenu.size(); i++) {
            listMenu1.addItem((new ModelMenu(listMenu.get(i), listMenu.get(i), MenuType.MENU)));
        }
    }

    public void addEventMenuSelected(EventMenuSelected event) {
        listMenu1.addEventMenuSelected(event);
    }

    public List<String> getListItemsMenu() {
        return listMenu;
    }

}
