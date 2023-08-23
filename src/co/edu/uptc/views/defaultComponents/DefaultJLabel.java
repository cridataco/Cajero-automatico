package co.edu.uptc.views.defaultComponents;

import javax.swing.*;
import java.awt.*;

public class DefaultJLabel extends JLabel {

	private static final long serialVersionUID = 1L;

	public DefaultJLabel(String name) {
		super(name);
		this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
		this.setForeground(new Color(255, 255, 255));
	}
}
