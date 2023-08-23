package co.edu.uptc.views.defaultComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

public class DefaultJTextF extends JTextField{
	
	private static final long serialVersionUID = 1L;

	public DefaultJTextF(String name) {
		this.setText(name);
		this.setBackground(new Color(40, 40, 40));
		this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		this.setForeground(new Color(255, 255, 255));
	}
}
