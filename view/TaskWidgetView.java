package view;

import model.TaskWidget;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class TaskWidgetView {

    private final TaskWidget widget;

    public TaskWidgetView(TaskWidget widget) {
        this.widget = widget;
    }

    public JPanel obtenerPanel() {
        JPanel panel = PanelWidget.crearPanel("Tareas - " + widget.getNombre());

        JLabel valor = PanelWidget.crearEtiqueta(widget.obtenerTexto());
        valor.setToolTipText(widget.obtenerTexto());
        JLabel resultado = PanelWidget.crearEtiqueta("");
        JButton boton = PanelWidget.crearBoton("Marcar tarea");

        boton.addActionListener(e -> {
            String mensaje = widget.interactuar();
            valor.setText(widget.obtenerTexto());
            valor.setToolTipText(widget.obtenerTexto());
            resultado.setText(mensaje);
        });

        panel.add(valor, BorderLayout.CENTER);
        panel.add(PanelWidget.crearFilaAccion(boton, resultado), BorderLayout.SOUTH);
        return panel;
    }
}
