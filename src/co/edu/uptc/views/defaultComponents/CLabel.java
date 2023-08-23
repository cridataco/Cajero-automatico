package customview;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CLabel extends JLabel {
	private static final long serialVersionUID = 1L;

	public CLabel() {
		super();
		setFont(new Font("Century Gothic", Font.PLAIN, 14));
		setForeground(Color.WHITE);
	}
	
	public CLabel(boolean cursor) {
		super();
		setFont(new Font("Century Gothic", Font.PLAIN, 14));
		setForeground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public CLabel(String text) {
		super(text);
		setFont(new Font("Century Gothic", Font.PLAIN, 18));
		setForeground(Color.WHITE);
	}

	public CLabel(String text, int fontSize) {
		super(text);
		setFont(new Font("Century Gothic", Font.PLAIN, fontSize));
		setForeground(Color.WHITE);
	}

	public CLabel (String text, int style, int fontSize) {
		super(text);
		setFont(new Font("Century Gothic", style, fontSize));
		setForeground(Color.WHITE);
	}
	
	public CLabel(ImageIcon image) {
		super(image);
	}
	
	public void setText(String text, int fontSize) {
		setText(text);
		setFont(new Font("Century Gothic", Font.PLAIN, fontSize));
	}
	
	public void setText(String text, int style, int fontSize) {
		setText(text);
		setFont(new Font("Century Gothic", style, fontSize));
	}
	
	public void setIcon(ImageIcon image) {
		super.setIcon(image);
	}
}