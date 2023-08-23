package co.edu.uptc.views;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class SiginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private SiginMainPanel mainPanel;
	private PrincipalFrame principalFrame;

	public SiginFrame(PrincipalFrame principalFrame) {
		this.principalFrame = principalFrame;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro de usuario");
		setResizable(false);
		initComponents();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void initComponents() {
		mainPanel = new SiginMainPanel(principalFrame);
		setContentPane(mainPanel);
	}
}