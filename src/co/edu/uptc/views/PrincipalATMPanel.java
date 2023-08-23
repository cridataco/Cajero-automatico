package co.edu.uptc.views;

import co.edu.uptc.views.defaultComponents.DefaultButton;
import co.edu.uptc.views.defaultComponents.DefaultJLabel;
import co.edu.uptc.views.defaultComponents.DefaultJTextF;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalATMPanel extends JPanel {

    private PrincipalFrame principalFrame;
    private JLabel currentMoney;
    private JButton retirar;
    private JButton consignar;
    private JButton prestamo;
    private JButton consultarDinero;
    private JButton cambioClave;
    private JButton resumenTransaccion;
    private JButton back;
    private JTextField inputMonto;
    private JTextField ccText;

    public PrincipalATMPanel(PrincipalFrame principalFrame) {
        this.principalFrame = principalFrame;
        this.setLayout(new GridBagLayout());
        initComponents();
        buttonListeners();
    }

    private void initComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        initLabels(gbc);
        initButtons(gbc);
    }

    public void buttonListeners(){
        buttonListener();
        buttonListenerConsignar();
        buttonListenerPrestamo();
        buttonListenerCambioClave();
        buttonListenerConsultarDinero();
        buttonListenerResumenTransaccion();
        buttonback();
    }

    private void initButtons(GridBagConstraints gbc){
        retirar = new DefaultButton("Retirar");
        addButton(gbc, retirar, 1, 0);
        consignar = new DefaultButton("Consignar");
        addButton(gbc, consignar, 1, 1);
        prestamo = new DefaultButton("Prestamo");
        addButton(gbc, prestamo, 1, 2);
        consultarDinero = new DefaultButton("Consultar Dinero");
        addButton(gbc, consultarDinero, 1, 3);
        cambioClave = new DefaultButton("Cambio Clave");
        addButton(gbc, cambioClave, 1, 4);
        resumenTransaccion = new DefaultButton("Resumen Transaccion");
        addButton(gbc, resumenTransaccion, 1, 5);
        back = new DefaultButton("Salir");
        addButton(gbc, back, 0, 6);
    }

    private void initLabels(GridBagConstraints gbc){
        currentMoney = new DefaultJLabel("Dinero Actual");
        addLabel(gbc, currentMoney, 0, 0);
        inputMonto = new DefaultJTextF("Escribe la cantidad de dinero");
        addJText(gbc, inputMonto, 1, 6);
        ccText = new DefaultJTextF("Escribe el documento de transferencia");
        addJText(gbc, ccText, 2, 1);
    }

    private void addLabel(GridBagConstraints gbc, JLabel label, int xPosition, int yPosition) {
        gbc.gridx = xPosition;
        gbc.gridy = yPosition;
        gbc.insets = new Insets(30, 30, 0, 50);
        gbc.ipady = 20;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(label, gbc);
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

    private void buttonListener(){
        retirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validMoneyJText() == true) {
                    principalFrame.retirar(Double.parseDouble(inputMonto.getText()));
                    currentMoney.setText(String.valueOf(principalFrame.getCurrentMoney()));
                    message();
                }
            }
        });
    }

    private void buttonListenerConsignar(){
        consignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validPrestamoJText() == true) {
                    principalFrame.consignar(ccText.getText(), Double.parseDouble(inputMonto.getText()));
                    currentMoney.setText(String.valueOf(principalFrame.getCurrentMoney()));
                    message();
                }
            }
        });
    }


    private void buttonListenerPrestamo(){
        prestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validMoneyJText() == true) {
                    principalFrame.prestamo(Double.parseDouble(inputMonto.getText()));
                    currentMoney.setText(String.valueOf(principalFrame.getCurrentMoney()));
                    message();
                }
            }
        });
    }


    private void buttonListenerConsultarDinero(){
        consultarDinero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentMoney.setText(String.valueOf(principalFrame.consultaDinero()));
                currentMoney.setText(String.valueOf(principalFrame.getCurrentMoney()));
                IoManager.showGraphicMessage("Dinero actual: " + principalFrame.getCurrentMoney());
            }
        });
    }


    private void buttonListenerCambioClave(){
        cambioClave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentMoney.setText(String.valueOf(principalFrame.getCurrentMoney()));
            }
        });
    }

    private void buttonListenerResumenTransaccion(){
        resumenTransaccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IoManager.showGraphicMessage("Movimientos: " + principalFrame.getHistory());
                currentMoney.setText(String.valueOf(principalFrame.getCurrentMoney()));
            }
        });
    }

    private void buttonback(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principalFrame.showMainPanel();
            }
        });
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(62, 62, 62, 230));
        g.fillRoundRect(0, 0, 1000, 700, 0, 0);
        paintText(g);
    }

    private void paintText(Graphics g) {
        g.setColor(new Color(255, 171, 0));
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        g.drawString("Bienvenido al ATM", 400, 40);
    }

    private boolean validMoneyJText(){
        try {
            Integer.parseInt(inputMonto.getText());
            return true;
        } catch (NumberFormatException e) {
            IoManager.showErrorMessage("Debes ingresar el monto.");
            return false;
        }
    }

    private boolean validPrestamoJText(){
        try {
            Integer.parseInt(ccText.getText());
            return true;
        } catch (NumberFormatException e) {
            IoManager.showErrorMessage("Debes ingresar una CC.");
            return false;
        }
    }

    private void message(){
        IoManager.showGraphicMessage("Movimiento realizado");
    }

    public JLabel getCurrentMoney() {
        return currentMoney;
    }
}
