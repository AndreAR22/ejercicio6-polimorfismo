package controller;

import model.Dashboard;
import model.Interactivo;
import model.Renderizable;
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
        vista.getBotonBuscar().addActionListener(e -> buscarWidget(vista.getCampoBusqueda().getText()));
        vista.getBotonOrdenar().addActionListener(e -> ordenarPorMemoria());
        vista.getBotonActualizar().addActionListener(e -> actualizarVistas());
    }

    public void listarWidgets() {
        vista.mostrarMensaje(dashboard.obtenerListado());
    }

    public void buscarWidget(String texto) {
        Renderizable widget = dashboard.buscar(texto);

        if (widget == null) {
            vista.mostrarMensaje("No se encontró ningún widget con '" + texto + "'.");
            return;
        }

        vista.mostrarMensaje("Widget encontrado:\n" + widget.toString()
                + "\nConfiguración: " + widget.obtenerConfiguracion()
                + "\nTipo: " + (widget instanceof Interactivo ? "Interactivo" : "Solo renderizable"));
    }

    public void ordenarPorMemoria() {
        dashboard.ordenarPorMemoria();
        actualizarVistas();
        vista.mostrarMensaje("Widgets ordenados por memoria (KB):\n"
                + dashboard.obtenerListado());
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
