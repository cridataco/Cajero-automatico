package co.edu.uptc.model;

public class Register {

    private double amountOfMoney;
    private double lastMoney;
    private String action;

    public Register(double amountOfMoney,  double lastMoney, String action) {
        this.amountOfMoney = amountOfMoney;
        this.lastMoney = lastMoney;
        this.action = action;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getLastMoney() {
        return lastMoney;
    }

    public void setLastMoney(double lastMoney) {
        this.lastMoney = lastMoney;
    }

    @Override
    public String toString() {
        return "Registro: " +
                "Dinero movido=" + amountOfMoney +
                " Dinero anterior=" + lastMoney +
                " Detalle='" + action + '\'' +
                '.'+"  ";
    }
}
