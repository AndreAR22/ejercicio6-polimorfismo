package model;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarWidget extends Widget {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public CalendarWidget(String id, String nombre, int memoriaKB) {
        super(id, nombre, memoriaKB);
    }

    @Override
    public String obtenerTexto() {
        return "Fecha: " + LocalDate.now().format(FORMATO);
    }

    @Override
    public String obtenerConfiguracion() {
        return "Formato: dd/MM/yyyy | Modo: solo lectura";
    }

    @Override
    public JComponent obtenerVista() {
        return new JPanel();
    }
}
