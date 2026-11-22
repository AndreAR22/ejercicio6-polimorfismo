package view;

import model.ClockWidget;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ClockWidgetView {

    private final ClockWidget widget;

    public ClockWidgetView(ClockWidget widget) {
        this.widget = widget;
    }

    public JPanel obtenerPanel() {
        JPanel panel = PanelWidget.crearPanel("Reloj - " + widget.getNombre());
        JLabel valor = PanelWidget.crearEtiqueta(widget.obtenerTexto());
        panel.add(valor, BorderLayout.CENTER);
        return panel;
    }
}
