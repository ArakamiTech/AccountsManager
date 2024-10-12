package com.arakamitech.accountsmanager.view.components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Button extends JButton {

    private Color shadowColor = new Color(200, 200, 200); // Color del sombreado
    private boolean isPressed = false;

    public Button() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {    
                isPressed = true; // Indicamos que está presionado
                setBackground(shadowColor); // Cambiamos a color gris
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                isPressed = false; // Botón liberado
                setBackground(Color.WHITE); // Restauramos el color de fondo
                repaint();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(40, 40);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, width, height, height, height)); // Dibujamos el fondo redondeado
        g2.setComposite(AlphaComposite.SrcOver);
        super.paintComponent(grphcs);
    }
}
