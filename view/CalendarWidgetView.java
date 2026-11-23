package view;

import model.CalendarWidget;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class CalendarWidgetView {

    private final CalendarWidget widget;

    public CalendarWidgetView(CalendarWidget widget) {
        this.widget = widget;
    }

    public JPanel obtenerPanel() {
        JPanel panel = PanelWidget.crearPanel("Calendario - " + widget.getNombre());
        JLabel valor = PanelWidget.crearEtiqueta(widget.obtenerTexto());
        panel.add(valor, BorderLayout.CENTER);
        return panel;
    }
}
