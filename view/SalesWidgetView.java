package view;

import model.SalesWidget;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SalesWidgetView {

    private final SalesWidget widget;

    public SalesWidgetView(SalesWidget widget) {
        this.widget = widget;
    }

    public JPanel obtenerPanel() {
        JPanel panel = PanelWidget.crearPanel("Ventas - " + widget.getNombre());

        JLabel valor = PanelWidget.crearEtiqueta(widget.obtenerTexto());
        JLabel resultado = PanelWidget.crearEtiqueta("");
        JButton boton = PanelWidget.crearBoton("Registrar venta");

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
