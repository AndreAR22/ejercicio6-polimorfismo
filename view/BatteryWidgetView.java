package view;

import model.BatteryWidget;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class BatteryWidgetView {

    private final BatteryWidget widget;

    public BatteryWidgetView(BatteryWidget widget) {
        this.widget = widget;
    }

    public JPanel obtenerPanel() {
        JPanel panel = PanelWidget.crearPanel("Batería - " + widget.getNombre());
        JLabel valor = PanelWidget.crearEtiqueta(widget.obtenerTexto());
        panel.add(valor, BorderLayout.CENTER);
        return panel;
    }
}
