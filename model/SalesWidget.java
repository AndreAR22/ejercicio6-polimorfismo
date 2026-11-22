package model;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class SalesWidget extends Widget implements Interactivo {

    private double totalVentas;

    public SalesWidget(String id, String nombre, int memoriaKB, double totalVentas) {
        super(id, nombre, memoriaKB);

        this.totalVentas = totalVentas;
    }

    @Override
    public String interactuar() {
        totalVentas += 50.0;
        return "Se registró una venta de Q50.00.";
    }

    @Override
    public String obtenerTexto() {
        return String.format("Ventas: Q%.2f", totalVentas);
    }

    @Override
    public String obtenerConfiguracion() {
        return "Monto acumulado: Q" + String.format("%.2f", totalVentas);
    }

    @Override
    public JComponent obtenerVista() {
        return new JPanel();
    }
}
