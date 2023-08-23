package co.edu.uptc.views.defaultComponents;

import javax.swing.*;
import java.awt.*;

public class DefaultComboBox extends JComboBox<String>{

	private static final long serialVersionUID = 1L;

	public DefaultComboBox() {
		this.setBackground(new Color(61, 61, 61));
		this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		this.setForeground(new Color(255, 255, 255));
	}
}
