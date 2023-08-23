package customview;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class CButtonUI extends BasicButtonUI {
	private boolean fill;
	
	public CButtonUI(boolean fill) {
		this.fill = fill;
	}

	public void paint(Graphics g, JComponent c) {
		if(fill) {
			fill(g, c);
		} else {
			draw(g, c);
		}
	}
	
	private void fill(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
		g2d.fill(new RoundRectangle2D.Double(0, 0, c.getWidth() - 1, c.getHeight() - 1, 13, 13));
		super.paint(g2d, c);
	}
	
	private void draw(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
		g2d.draw(new RoundRectangle2D.Double(0, 0, c.getWidth() - 1, c.getHeight() - 1, 13, 13));
		super.paint(g2d, c);
	}
}