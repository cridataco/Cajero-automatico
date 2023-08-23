package co.edu.uptc.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.edu.uptc.model.User;
import customview.CButton;
import customview.CColor;
import customview.CLabel;
import customview.CPanelUI;

public class LoginMainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private SiginFrame siginFrame;
	private PrincipalFrame principalFrame;
	private CLabel lLogin;//Etiqueta iniciar sesión
	private CLabel lUser;//Etiqueta usuario o dni
	private CLabel lPassword;//Etiqueta contraseña
	private JSeparator sUser;
	private JSeparator sPassword;
	private JTextField user;
	private JPasswordField password;
	private CButton login;
	private CButton sigin;

	public LoginMainPanel(PrincipalFrame principalFrame) {
		this.principalFrame = principalFrame;
		setUI(new CPanelUI());
		initComponents();
		initButtons();
		setEvents();
	}

	private void initButtons(){
		buttonListenerConsultarDinero();
		buttonListener2();
	}

	private void initComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		lLogin = new CLabel("Iniciar Sesión", 28);
		lUser = new CLabel("No. de cédula");
		lPassword = new CLabel("Contraseña");
		sUser = new JSeparator();
		sPassword = new JSeparator();
		user = new JTextField("0000000000", 15);
		password = new JPasswordField("**********");
		login = new CButton("Iniciar sesión");
		sigin = new CButton("Registrarse");

		lLogin.setHorizontalAlignment(SwingConstants.CENTER);

		user.setOpaque(false);
		user.setBorder(null);
		user.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		user.setForeground(CColor.LIGHT_GRAY);

		password.setOpaque(false);
		password.setBorder(null);
		password.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		password.setForeground(CColor.LIGHT_GRAY);
/*
		login.addActionListener(listener);
		login.setActionCommand("login");
		
		sigin.addActionListener(listener);
		sigin.setActionCommand("sigin");*/

		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(60, 20, 20, 20);
		add(lLogin, c);

		c.gridheight = 1;
		c.gridy = 1;
		c.gridx = 0;
		c.insets = new Insets(0, 25, 0, 25);
		add(lUser, c);

		c.gridy = 3;
		add(sUser, c);

		c.gridy = 5;
		add(password, c);

		c.gridy = 2;
		c.insets = new Insets(10, 25, 0, 25);
		add(user, c);

		c.gridy = 4;
		c.insets = new Insets(20, 25, 10, 25);
		add(lPassword, c);

		c.gridy = 6;
		c.insets = new Insets(0, 25, 10, 25);
		add(sPassword, c);

		c.gridy = 7;
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(20, 0, 10, 0);
		add(login, c);
		
		c.gridy = 8;
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(0, 0, 10, 0);
		add(sigin, c);

		c.gridy = 8;
		c.insets = new Insets(20, 0, 0, 240);
	}

	private void setEvents() {
		user.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (user.getText().equals("0000000000")) {
					user.setText("");
					user.setForeground(Color.WHITE);
				}
				if (String.valueOf(password.getPassword()).isEmpty()) {
					password.setText("**********");
					password.setForeground(CColor.LIGHT_GRAY);
				}
			}
		});
		password.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				if (String.valueOf(password.getPassword()).equals("**********")) {
					password.setText("");
					password.setForeground(Color.WHITE);
				}
				if (user.getText().isEmpty()) {
					user.setText("0000000000");
					user.setForeground(CColor.LIGHT_GRAY);
				}
			}

		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (user.getText().isEmpty()) {
					user.setText("0000000000");
					user.setForeground(CColor.LIGHT_GRAY);
				}
				if (String.valueOf(password.getPassword()).isEmpty()) {
					password.setText("**********");
					password.setForeground(CColor.LIGHT_GRAY);
				}
				transferFocus();
			}
		});
	}

	private void buttonListenerConsultarDinero(){
		sigin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				siginFrame = new SiginFrame(principalFrame);
			}
		});
	}

	private void buttonListener2(){
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User tmpUser = new User(user.getText(), password.getText(), user.getText(), user.getText());
				if(principalFrame.signIn(tmpUser) == true){
					System.out.println("entro");
					principalFrame.setMoney();
					principalFrame.showATMPanel();
				}
			}
		});
	}
	public void cerrarRegistro(){
		siginFrame.dispose();
	}
	
	public String getUsername() {
		return user.getText();
	}
	
	public char[] getPassword() {
		return password.getPassword();
	}
}