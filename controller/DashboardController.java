package controller;

import model.Dashboard;
import view.DashboardView;

public class DashboardController {

    private final Dashboard dashboard;
    private final DashboardView vista;

    public DashboardController() {
        this.dashboard = new Dashboard();
        this.vista = new DashboardView();
    }

    public void iniciar() {
        vista.setVisible(true);
    }
}
