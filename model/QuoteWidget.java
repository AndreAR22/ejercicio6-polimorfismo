package model;

import view.QuoteWidgetView;

import javax.swing.JComponent;

public class QuoteWidget extends Widget {

    private final String frase;
    private final String autor;

    public QuoteWidget(String id, String nombre, int memoriaKB, String frase, String autor) {
        super(id, nombre, memoriaKB);

        if (frase == null || frase.isBlank()) {
            throw new IllegalArgumentException("La frase es obligatoria.");
        }
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("El autor es obligatorio.");
        }

        this.frase = frase;
        this.autor = autor;
    }

    @Override
    public String obtenerTexto() {
        return "\"" + frase + "\" — " + autor;
    }

    @Override
    public String obtenerConfiguracion() {
        return "Frase: " + frase + " | Autor: " + autor;
    }

    @Override
    public JComponent obtenerVista() {
        return new QuoteWidgetView(this).obtenerPanel();
    }
}
