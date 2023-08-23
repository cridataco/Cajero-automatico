package co.edu.uptc.views.defaultComponents;

import javax.swing.*;
import java.awt.*;

public class DefaultButton extends JButton {

	private static final long serialVersionUID = 1L;

	public DefaultButton(String name) {
		super(name);
		this.setPreferredSize(new Dimension(80, 50));
		this.setBackground(new Color(62, 62, 62));
		this.setBorderPainted(false);
		this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
		this.setForeground(new Color(255, 255, 255));
	}
}