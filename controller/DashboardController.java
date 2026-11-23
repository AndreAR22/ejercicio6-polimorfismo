package controller;

import model.Dashboard;
import view.DashboardView;

public class DashboardController {

    private final Dashboard dashboard;
    private final DashboardView vista;

    public DashboardController() {
        this.dashboard = new Dashboard();
        this.vista = new DashboardView();

        this.vista.setControlador(this);
        registrarEventos();
        this.vista.mostrarWidgets(dashboard.listarWidgets());
        this.vista.mostrarMensaje("Catálogo inicial: " + dashboard.listarWidgets().size()
                + " widgets | Interactivos: " + dashboard.contarInteractivos());
    }

    public void iniciar() {
        vista.setVisible(true);
    }

    private void registrarEventos() {
        vista.getBotonListar().addActionListener(e -> listarWidgets());
        vista.getBotonActualizar().addActionListener(e -> actualizarVistas());
    }

    public void listarWidgets() {
        vista.mostrarMensaje(dashboard.obtenerListado());
    }

    public void actualizarVistas() {
        vista.mostrarWidgets(dashboard.listarWidgets());
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public DashboardView getVista() {
        return vista;
    }
}
