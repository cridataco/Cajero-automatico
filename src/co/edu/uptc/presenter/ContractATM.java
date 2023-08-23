package co.edu.uptc.presenter;

import co.edu.uptc.model.User;

public interface ContractATM {

    public interface View {
        void setPresenter(ContractATM.Presenter presenter);
        void start();

    }

    public interface Model {
        void setPresenter(ContractATM.Presenter presenter);
        boolean retirar(double monto);
        public boolean consignar(String cc, double amountOfMoney);
        public void prestamo(double amountOfMoney);
        public double consultaDinero();
        public void createUserMain(User user);
        public boolean signIn2(User user);
        public double getCurrentMoney();
        public String getHistory();
        void changePass(String password);
    }

    public interface Presenter {
        void setView(ContractATM.View view);
        void setModel(ContractATM.Model model);
        boolean retirar(double monto);
        public boolean consignar(String cc, double amountOfMoney);
        public void prestamo(double amountOfMoney);
        public double consultaDinero();
        public void createUser(User user);
        public boolean signIn(User user);
        public double getCurrentMoney();
        public String getHistory();
        void changePass(String password);
    }
}