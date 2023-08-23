package co.edu.uptc.views.defaultComponents;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.plaf.PanelUI;

public class CPanelUI extends PanelUI {
	public void paint(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gp = new GradientPaint(0, 0,
				CColor.CIAN, c.getWidth(), c.getHeight(),
				Color.RED);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, c.getWidth(), c.getHeight());
		super.paint(g2d, c);
	}
}