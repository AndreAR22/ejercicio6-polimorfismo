package view;

import model.QuoteWidget;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class QuoteWidgetView {

    private final QuoteWidget widget;

    public QuoteWidgetView(QuoteWidget widget) {
        this.widget = widget;
    }

    public JPanel obtenerPanel() {
        JPanel panel = PanelWidget.crearPanel("Frase - " + widget.getNombre());
        JLabel valor = PanelWidget.crearEtiqueta(widget.obtenerTexto());
        valor.setToolTipText(widget.obtenerTexto());
        panel.add(valor, BorderLayout.CENTER);
        return panel;
    }
}
