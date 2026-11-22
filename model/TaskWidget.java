package model;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

public class TaskWidget extends Widget implements Interactivo {

    private final ArrayList<String> tareas = new ArrayList<>();
    private final ArrayList<Boolean> completadas = new ArrayList<>();

    public TaskWidget(String id, String nombre, int memoriaKB, String... tareas) {
        super(id, nombre, memoriaKB);

        if (tareas == null || tareas.length == 0) {
            throw new IllegalArgumentException("Debe existir al menos una tarea.");
        }

        for (String tarea : tareas) {
            if (tarea == null || tarea.isBlank()) {
                throw new IllegalArgumentException("Las tareas no pueden estar vacías.");
            }
            this.tareas.add(tarea);
            this.completadas.add(false);
        }
    }

    @Override
    public String interactuar() {
        for (int i = 0; i < completadas.size(); i++) {
            if (!completadas.get(i)) {
                completadas.set(i, true);
                return "Tarea completada: " + tareas.get(i);
            }
        }
        return "Todas las tareas están completadas.";
    }

    @Override
    public String obtenerTexto() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < tareas.size(); i++) {
            resultado.append(completadas.get(i) ? "[X] " : "[ ] ").append(tareas.get(i));
            if (i < tareas.size() - 1) {
                resultado.append(" | ");
            }
        }

        return resultado.toString();
    }

    @Override
    public String obtenerConfiguracion() {
        return "Tareas: " + tareas.size()
                + " | Completadas: " + contarCompletadas();
    }

    private int contarCompletadas() {
        int cantidad = 0;

        for (boolean completada : completadas) {
            if (completada) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public List<String> getTareas() {
        return tareas;
    }

    @Override
    public JComponent obtenerVista() {
        return new JPanel();
    }
}
