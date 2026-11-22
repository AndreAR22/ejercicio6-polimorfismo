package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

public final class PanelWidget {

    private PanelWidget() {
    }

    public static JPanel crearPanel(String titulo) {
        JPanel panel = new JPanel(new BorderLayout(6, 6));
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        panel.setPreferredSize(new Dimension(280, 105));
        return panel;
    }

    public static JLabel crearEtiqueta(String texto) {
        JLabel etiqueta = new JLabel(texto, SwingConstants.CENTER);
        return etiqueta;
    }

    public static JButton crearBoton(String texto) {
        return new JButton(texto);
    }

    public static JPanel crearFilaAccion(JButton boton, JLabel resultado) {
        JPanel fila = new JPanel(new BorderLayout(4, 4));
        fila.add(boton, BorderLayout.WEST);
        fila.add(resultado, BorderLayout.CENTER);
        return fila;
    }
}
