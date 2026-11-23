package model;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {

    private final ArrayList<Renderizable> widgets = new ArrayList<>();

    public Dashboard() {
        init();
    }

    public void init() {
        widgets.clear();

        widgets.add(new WeatherWidget("W01", "Clima Guatemala", 128, "Guatemala", 25));
        widgets.add(new TaskWidget("W02", "Tareas del día", 96,
                "Enviar reporte", "Revisar correos", "Preparar reunión"));
        widgets.add(new AlertWidget("W03", "Alerta del sistema", 256,
                "Servidor con alta carga", 4));
        widgets.add(new ClockWidget("W04", "Reloj digital", 64));
        widgets.add(new QuoteWidget("W05", "Frase del día", 48,
                "A pesar de todo, sigues siendo tú", "UNDERTALE de Toby Fox"));
        widgets.add(new TrafficWidget("W06", "Estado del tráfico", 112));
        widgets.add(new BatteryWidget("W07", "Batería del servidor", 32, 78));
        widgets.add(new NoteWidget("W08", "Notas rápidas", 80,
                "assets/aaaaa.png", "assets/eeeee.png"));
        widgets.add(new CalendarWidget("W09", "Calendario", 56));
        widgets.add(new SalesWidget("W10", "Ventas del día", 144, 1250.0));
    }

    public List<Renderizable> listarWidgets() {
        return widgets;
    }

    public int contarInteractivos() {
        int cantidad = 0;

        for (Renderizable widget : widgets) {
            if (widget instanceof Interactivo) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public String obtenerListado() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Widgets activos (").append(widgets.size()).append("):\n");

        for (Renderizable widget : widgets) {
            resultado.append(widget.toString()).append("\n");
            resultado.append("    ").append(widget instanceof Interactivo
                    ? "Interactivo"
                    : "Solo renderizable").append("\n");
        }

        return resultado.toString();
    }
}
