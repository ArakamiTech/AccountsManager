package com.arakamitech.accountsmanager.view.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author cristhian
 */
public class TableHeader extends JLabel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableHeader(String text) {
        super(text);
        setOpaque(false);
        setBackground(Color.WHITE);
        setFont(new Font("sansserif", 1, 12));
        setForeground(new Color(102, 102, 102));
        setBorder(new EmptyBorder(10, 50, 10, 5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(230, 230, 230));
        g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }

}
