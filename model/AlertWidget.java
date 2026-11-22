package model;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class AlertWidget extends Widget implements Interactivo {

    private final String mensaje;
    private final int prioridad;
    private boolean leida;

    public AlertWidget(String id, String nombre, int memoriaKB, String mensaje, int prioridad) {
        super(id, nombre, memoriaKB);
        if (prioridad < 1 || prioridad > 5) {
            throw new IllegalArgumentException("La prioridad debe estar entre 1 y 5.");
        }

        this.mensaje = mensaje;
        this.prioridad = prioridad;
        this.leida = false;
    }

    @Override
    public String interactuar() {
        if (leida) {
            return "La alerta ya estaba marcada como leída.";
        }

        leida = true;
        return "Alerta marcada como leída.";
    }

    @Override
    public String obtenerTexto() {
        return "P" + prioridad + ": " + mensaje + (leida ? " (leída)" : " (sin leer)");
    }

    @Override
    public String obtenerConfiguracion() {
        return "Mensaje: " + mensaje
                + " | Prioridad: " + prioridad
                + " | Estado: " + (leida ? "leída" : "sin leer");
    }

    @Override
    public JComponent obtenerVista() {
        return new JPanel();
    }
}
