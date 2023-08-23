package co.edu.uptc.model;

import co.edu.uptc.presenter.ContractATM;

import java.util.ArrayList;

public class ATMBussinesManager implements ContractATM.Model{

    private ArrayList<User> users;
    private ArrayList<Register> temporalUserRegisters;
    private User currentUser;
    private ContractATM.Presenter presenter;

    public ATMBussinesManager() {
        users = new ArrayList<>();
        temporalUserRegisters = new ArrayList<>();
        currentUser = new User();
    }

    public boolean signIn(User user){
        return searchUserPerLogin(user.getUserName(), user.getPassword());
    }

    public void createUser(User user) {
        user.setAvailableMoney(50000);
        users.add(user);
    }

    public boolean withdraw(double amount) {
        if (currentUser.getAvailableMoney() < amount) {
            return false;
        } else {
            addRegister(amount, "Dinero retirado");
            currentUser.setAvailableMoney(currentUser.getAvailableMoney() - amount);
            return true;
        }
    }

    public boolean consignMoney(String cc, double amountOfMoney) {
        User user = searchUser(cc);
        if (user == null || (user.getAvailableMoney() - amountOfMoney) > user.getAvailableMoney()) {
            return false;
        } else {
            addRegister(amountOfMoney, "Dinero transferido");
            user.setAvailableMoney(user.getAvailableMoney() + amountOfMoney);
            currentUser.setAvailableMoney(currentUser.getAvailableMoney() - amountOfMoney);
            return true;
        }
    }

    public void moneyLoans(double amountOfMoney){
        addRegister(amountOfMoney, "Prestamo de dinero");
        currentUser.setAvailableMoney(currentUser.getAvailableMoney() + amountOfMoney);
    }

    public double consultMoney(){
        return currentUser.getAvailableMoney();
    }

    public void changePassword(String newPassword){
        currentUser.setPassword(newPassword);
    }

    public String GetTransactionSummary(){
        String registers = "";
        for (Register register : temporalUserRegisters) {
            registers += register.toString();
        }
        return registers;
    }

    private void addRegister(double amountOfMoney, String action){
        temporalUserRegisters.add(new Register(amountOfMoney, currentUser.getAvailableMoney(),action));
    }

    private User searchUser(String cc) {
        for (User user : users) {
            if (user.getPerson().getCc().equals(cc)) {
                return user;
            }
        }
        return null;
    }

    private boolean searchUserPerLogin(String userName, String userPassword) {
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(userPassword)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    @Override
    public void setPresenter(ContractATM.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean retirar(double monto) {
        return withdraw(monto);
    }

    @Override
    public boolean consignar(String cc, double amountOfMoney) {
        return consignMoney(cc, amountOfMoney);
    }

    @Override
    public void prestamo(double amountOfMoney) {
        moneyLoans(amountOfMoney);
    }

    @Override
    public double consultaDinero() {
        return consultMoney();
    }

    @Override
    public void createUserMain(User user) {
        createUser(user);
    }

    @Override
    public boolean signIn2(User user) {
        return signIn(user);
    }

    @Override
    public double getCurrentMoney() {
        return consultMoney();
    }

    @Override
    public String getHistory() {
        return GetTransactionSummary();
    }

    @Override
    public void changePass(String password) {
        changePassword(password);
    }
}
