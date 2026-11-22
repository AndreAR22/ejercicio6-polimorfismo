package model;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class TrafficWidget extends Widget implements Interactivo {

    private static final String[] ESTADOS = {"Fluido", "Moderado", "Congestionado"};

    private int indiceEstado;

    public TrafficWidget(String id, String nombre, int memoriaKB) {
        super(id, nombre, memoriaKB);
        this.indiceEstado = 0;
    }

    @Override
    public String interactuar() {
        indiceEstado = (indiceEstado + 1) % ESTADOS.length;
        return "Estado de tráfico actualizado a " + ESTADOS[indiceEstado] + ".";
    }

    @Override
    public String obtenerTexto() {
        return "Tráfico: " + ESTADOS[indiceEstado];
    }

    @Override
    public String obtenerConfiguracion() {
        return "Estados disponibles: " + ESTADOS.length + " | Estado actual: " + ESTADOS[indiceEstado];
    }

    @Override
    public JComponent obtenerVista() {
        return new JPanel();
    }
}
