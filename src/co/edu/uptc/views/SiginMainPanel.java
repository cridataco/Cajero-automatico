package co.edu.uptc.views;

import co.edu.uptc.model.User;
import customview.CButton;
import customview.CLabel;
import customview.CPanelUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SiginMainPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private PrincipalFrame principalFrame;
    private CLabel lname;//Etiqueta nombre
    private CLabel ldni;//Etiqueta no. cedula
    private CLabel lPassword;//Etiqueta contraseña
    private JTextField name;
    private JTextField dni;
    private JPasswordField password;
    private CButton sigin;
    private CButton exit;

    public SiginMainPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        setUI(new CPanelUI());
        initComponents();
        initButtons();
    }

    private boolean createUser() {
        try {
            Integer.parseInt(dni.getText());
            User use = new User(dni.getText(), password.getText(), name.getText(), dni.getText());
            principalFrame.createUser(use);
			IoManager.showGraphicMessage("Usuario creado.");
            return true;
        } catch (NumberFormatException e) {
            IoManager.showErrorMessage("La CC debe ser un numero.");
        }
        return false;
    }

    private void initButtons() {
        buttonListenerPrestamo();
        buttonListener2();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        lname = new CLabel("Nombre:");
        ldni = new CLabel("No. de cédula:");
        lPassword = new CLabel("Contraseña:");
        name = new JTextField(7);
        dni = new JTextField(7);
        password = new JPasswordField(7);
        exit = new CButton("Salir");
        sigin = new CButton("Registrarse");

        name.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        dni.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        password.setFont(new Font("Century Gothic", Font.PLAIN, 18));

        sigin.setActionCommand("sigin");

        exit.setActionCommand("exit");


        lname.setAlignmentX(RIGHT_ALIGNMENT);
        add(lname, c);

        c.gridy = 1;
        c.gridx = 0;
        add(ldni, c);

        c.gridy = 2;
        c.gridx = 0;
        add(lPassword, c);

        c.gridy = 0;
        c.gridx = 1;
        c.insets = new Insets(5, 5, 5, 5);
        add(name, c);

        c.gridy = 1;
        c.gridx = 1;
        add(dni, c);

        c.gridy = 2;
        c.gridx = 1;
        add(password, c);

        c.gridy = 3;
        c.gridx = 0;
        c.fill = GridBagConstraints.BOTH;
        add(exit, c);

        c.gridy = 3;
        c.gridx = 1;
        add(sigin, c);
    }

    private void buttonListenerPrestamo() {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principalFrame.cerrarRegistro();
            }
        });
    }

    private void buttonListener2() {
        sigin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				createUser();
                principalFrame.cerrarRegistro();
            }
        });
    }
}