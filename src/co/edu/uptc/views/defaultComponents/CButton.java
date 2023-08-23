package co.edu.uptc.views.defaultComponents;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class CButton extends JButton {
	private static final long serialVersionUID = 1L;

	public CButton() {
		super();
		setEffect();
		setFont(new Font("Century Gothic", Font.PLAIN, 18));
		setForeground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setUI(new CButtonUI(false));
	}
	
	public CButton(String text) {
		super(text);
		setEffect();
		setFont(new Font("Century Gothic", Font.PLAIN, 18));
		setForeground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setUI(new CButtonUI(false));
	}

	public CButton(String text, int fontSize) {
		super(text);
		setEffect();
		setFont(new Font("Century Gothic", Font.PLAIN, fontSize));
		setForeground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setContentAreaFilled(false);
		setBorderPainted(false);
		setUI(new CButtonUI(false));
	}

	public void setText(String text, int fontSize) {
		setText(text);
		setFont(new Font("Century Gothic", Font.PLAIN, fontSize));
	}

	private void setEffect() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setUI(new CButtonUI(true));
				setForeground(CColor.CIAN);
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setUI(new CButtonUI(false));
				setForeground(Color.WHITE);
				repaint();
			}
		});
	}
}