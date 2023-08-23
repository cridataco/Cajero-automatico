package co.edu.uptc.views;

import co.edu.uptc.model.User;
import co.edu.uptc.presenter.ContractATM;
import javax.swing.*;

public class PrincipalFrame extends JFrame implements ContractATM.View{

    ContractATM.Presenter presenter;
    private PrincipalATMPanel principalATMPanel;
    private LoginMainPanel mainPanel;
    private ChangePasswordPanel changePasswordPanel;

    public PrincipalFrame() {
        super("ATM");
        this.setSize(1000, 700);
        initPanels();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        start();
    }

    private void initPanels() {
        mainPanel = new LoginMainPanel(this);
        principalATMPanel = new PrincipalATMPanel(this);
        changePasswordPanel = new ChangePasswordPanel(this);
        this.add(mainPanel);
    }

    public void showATMPanel(){
        principalATMPanel.setVisible(true);
        mainPanel.setVisible(false);
        changePasswordPanel.setVisible(false);
        this.add(principalATMPanel);
        this.setSize(1000, 701);
    }

    public void showMainPanel(){
        this.add(mainPanel);
        mainPanel.setVisible(true);
        principalATMPanel.setVisible(false);
        changePasswordPanel.setVisible(false);
        this.setSize(1000, 700);
    }

    public void showPasswodPanel(){
        this.add(changePasswordPanel);
        changePasswordPanel.setVisible(true);
        mainPanel.setVisible(false);
        principalATMPanel.setVisible(false);
        this.setSize(1000, 700);
    }

    @Override
    public void setPresenter(ContractATM.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        this.setVisible(true);
    }

    public boolean retirar(double monto){
        return presenter.retirar(monto);
    }

    public boolean consignar(String cc, double amountOfMoney){
        return presenter.consignar(cc, amountOfMoney);
    }

    public void prestamo(double amountOfMoney){
        presenter.prestamo(amountOfMoney);
    }

    public double consultaDinero(){
        return presenter.consultaDinero();
    }
    public void cerrarRegistro(){
        mainPanel.cerrarRegistro();
    }

    public void createUser(User user){
        presenter.createUser(user);
    }

    public boolean signIn(User user){
        return presenter.signIn(user);
    }

    public double getCurrentMoney(){
        return presenter.getCurrentMoney();
    }
    public String getHistory(){
        return presenter.getHistory();
    }

    void changePass(String password){
        presenter.changePass(password);
    }

    public void setMoney(){
        principalATMPanel.getCurrentMoney().setText("Dinero actual:  " + String.valueOf(getCurrentMoney()));
    }
}