package co.edu.uptc.presenter;

import co.edu.uptc.model.ATMBussinesManager;
import co.edu.uptc.views.PrincipalFrame;

public class ManagerGeneral {
    ContractATM.View view;
    ContractATM.Model modelATM;
    ContractATM.Presenter presenter;

    private void createMVP() {
        view = new PrincipalFrame();
        presenter = new Presenter();
        modelATM = new ATMBussinesManager();
        view.setPresenter(presenter);
        modelATM.setPresenter(presenter);
        presenter.setView(view);
        presenter.setModel(modelATM);
    }

    public void runProject() {
        createMVP();
        view.start();
    }
}