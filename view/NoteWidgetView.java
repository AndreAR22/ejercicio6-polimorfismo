package view;

import model.NoteWidget;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Image;

public class NoteWidgetView {

    private final NoteWidget widget;

    public NoteWidgetView(NoteWidget widget) {
        this.widget = widget;
    }

    public JPanel obtenerPanel() {
        JPanel panel = PanelWidget.crearPanel("Nota - " + widget.getNombre());

        JLabel valor = PanelWidget.crearEtiqueta("");
        JLabel resultado = PanelWidget.crearEtiqueta("");
        JButton boton = PanelWidget.crearBoton("Siguiente imagen");

        actualizarImagen(valor);

        boton.addActionListener(e -> {
            String mensaje = widget.interactuar();
            actualizarImagen(valor);
            resultado.setText(mensaje);
        });

        panel.add(valor, BorderLayout.CENTER);
        panel.add(PanelWidget.crearFilaAccion(boton, resultado), BorderLayout.SOUTH);
        return panel;
    }

    private void actualizarImagen(JLabel etiqueta) {
        ImageIcon icono = new ImageIcon(widget.getImagenActual());

        if (icono.getIconWidth() == -1) {
            etiqueta.setText(widget.obtenerTexto());
            etiqueta.setIcon(null);
            return;
        }

        Image imagen = icono.getImage().getScaledInstance(240, 70, Image.SCALE_SMOOTH);
        etiqueta.setIcon(new ImageIcon(imagen));
        etiqueta.setText("");
    }
}
