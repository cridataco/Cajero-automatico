package co.edu.uptc.presenter;

import co.edu.uptc.model.User;

public class Presenter implements ContractATM.Presenter {

    private ContractATM.View view;
    private ContractATM.Model model;

    @Override
    public void setView(ContractATM.View view) {
        this.view = view;
    }

    @Override
    public void setModel(ContractATM.Model model) {
        this.model = model;
    }

    @Override
    public boolean retirar(double monto) {
        return model.retirar(monto);
    }

    @Override
    public boolean consignar(String cc, double amountOfMoney) {
        return model.consignar(cc, amountOfMoney);
    }

    @Override
    public void prestamo(double amountOfMoney) {
        model.prestamo(amountOfMoney);
    }

    @Override
    public double consultaDinero() {
        return model.consultaDinero();
    }

    public void createUser(User user){
        model.createUserMain(user);
    }

    @Override
    public boolean signIn(User user) {
        return model.signIn2(user);
    }

    @Override
    public double getCurrentMoney() {
        return model.getCurrentMoney();
    }

    @Override
    public String getHistory() {
        return model.getHistory();
    }

    @Override
    public void changePass(String password) {
        model.changePass(password);
    }
}