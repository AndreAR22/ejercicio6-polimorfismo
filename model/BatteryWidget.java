package model;

import view.BatteryWidgetView;

import javax.swing.JComponent;

public class BatteryWidget extends Widget {

    private final int nivel;

    public BatteryWidget(String id, String nombre, int memoriaKB, int nivel) {
        super(id, nombre, memoriaKB);

        if (nivel < 0 || nivel > 100) {
            throw new IllegalArgumentException("El nivel de batería debe estar entre 0 y 100.");
        }

        this.nivel = nivel;
    }

    @Override
    public String obtenerTexto() {
        return "Batería: " + nivel + "%";
    }

    @Override
    public String obtenerConfiguracion() {
        return "Nivel fijo: " + nivel + "% | Sin acciones disponibles";
    }

    @Override
    public JComponent obtenerVista() {
        return new BatteryWidgetView(this).obtenerPanel();
    }
}
