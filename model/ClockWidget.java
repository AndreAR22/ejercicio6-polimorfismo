package model;

import view.ClockWidgetView;

import javax.swing.JComponent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockWidget extends Widget {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("HH:mm:ss");

    public ClockWidget(String id, String nombre, int memoriaKB) {
        super(id, nombre, memoriaKB);
    }

    @Override
    public String obtenerTexto() {
        return "Hora actual: " + LocalTime.now().format(FORMATO);
    }

    @Override
    public String obtenerConfiguracion() {
        return "Modo: solo lectura | Zona: hora local del equipo";
    }

    @Override
    public JComponent obtenerVista() {
        return new ClockWidgetView(this).obtenerPanel();
    }
}
