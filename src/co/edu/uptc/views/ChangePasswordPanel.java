package co.edu.uptc.views;

import co.edu.uptc.views.defaultComponents.DefaultButton;
import co.edu.uptc.views.defaultComponents.DefaultJLabel;
import co.edu.uptc.views.defaultComponents.DefaultJTextF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordPanel extends JPanel {

    private PrincipalFrame principalFrame;
    private JButton cancel;
    private JButton changeButton;
    private JTextField passwordText;
    private JLabel newPasswotdText;


    public ChangePasswordPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        this.setLayout(new GridBagLayout());
        initComponents();
        buttonListeners();
    }

    private void buttonListener(){
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validPasswordJText() == true) {
                    principalFrame.changePass(passwordText.getText());
                    IoManager.showGraphicMessage("Clave cambiada.");
                }
            }
        });
    }

    private void back(){
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principalFrame.showATMPanel();
            }
        });
    }

    private boolean validPasswordJText(){
        try {
            Integer.parseInt(passwordText.getText());
            return true;
        } catch (NumberFormatException e) {
            IoManager.showErrorMessage("Debes ingresar un numero.");
            return false;
        }
    }

    private void buttonListeners() {
        buttonListener();
        back();
    }

    private void initComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        initLabels(gbc);
        passwordText = new DefaultJTextF("");
        addJText(gbc, passwordText, 1, 0);
        changeButton = new DefaultButton("Cambiar");
        addButton(gbc, changeButton, 0, 1);
        cancel = new DefaultButton("Volver");
        addButton(gbc, cancel, 1, 1);
    }

    private void addButton(GridBagConstraints gbc, JButton button, int xPosition, int yPosition) {
        gbc.gridx = xPosition;
        gbc.gridy = yPosition;
        gbc.ipadx = 200;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(button, gbc);
    }

    private void addJText(GridBagConstraints gbc, JTextField jTextField, int xPosition, int yPosition) {
        gbc.gridx = xPosition;
        gbc.gridy = yPosition;
        gbc.ipadx = 240;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(jTextField, gbc);
    }

    private void addLabel(GridBagConstraints gbc, JLabel label, int xPosition, int yPosition) {
        gbc.gridx = xPosition;
        gbc.gridy = yPosition;
        gbc.insets = new Insets(30, 30, 0, 50);
        gbc.ipady = 20;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(label, gbc);
    }

    private void initLabels(GridBagConstraints gbc) {
        newPasswotdText = new DefaultJLabel("Escribe una nueva clave: ");
        addLabel(gbc, newPasswotdText, 0, 0);
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(62, 62, 62, 230));
        g.fillRoundRect(0, 0, 1000, 700, 0, 0);
        paintText(g);
    }

    private void paintText(Graphics g) {
        g.setColor(new Color(255, 171, 0));
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        g.drawString("Cambiando tu clave.", 400, 40);
    }
}
