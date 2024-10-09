package com.arakamitech.accountsmanager.logic.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author cristhian
 */
public class SearchText extends JTextField {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchText() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setSelectionColor(new Color(220, 204, 182));
    }
    private static final String HINT = "Search here ...";

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().isEmpty()) {
            var h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            var ins = getInsets();
            var fm = g.getFontMetrics();
            var c0 = getBackground().getRGB();
            var c1 = getForeground().getRGB();
            var m = 0xfefefefe;
            var c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g.setColor(new Color(c2, true));
            g.drawString(HINT, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }
}
