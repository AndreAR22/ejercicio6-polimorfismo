package view;

import model.WeatherWidget;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class WeatherWidgetView {

    private final WeatherWidget widget;

    public WeatherWidgetView(WeatherWidget widget) {
        this.widget = widget;
    }

    public JPanel obtenerPanel() {
        JPanel panel = PanelWidget.crearPanel("Clima - " + widget.getNombre());

        JLabel valor = PanelWidget.crearEtiqueta(widget.obtenerTexto());
        JLabel resultado = PanelWidget.crearEtiqueta("");
        JButton boton = PanelWidget.crearBoton("Cambiar °C / °F");

        boton.addActionListener(e -> {
            String mensaje = widget.interactuar();
            valor.setText(widget.obtenerTexto());
            resultado.setText(mensaje);
        });

        panel.add(valor, BorderLayout.CENTER);
        panel.add(PanelWidget.crearFilaAccion(boton, resultado), BorderLayout.SOUTH);
        return panel;
    }
}
