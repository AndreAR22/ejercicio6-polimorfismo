package model;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class NoteWidget extends Widget implements Interactivo {

    private final String[] imagenes;
    private int indiceImagen;

    public NoteWidget(String id, String nombre, int memoriaKB, String... imagenes) {
        super(id, nombre, memoriaKB);

        this.imagenes = imagenes.clone();
        this.indiceImagen = 0;
    }

    @Override
    public String interactuar() {
        indiceImagen = (indiceImagen + 1) % imagenes.length;
        return "Imagen " + (indiceImagen + 1) + " de " + imagenes.length + ".";
    }

    @Override
    public String obtenerTexto() {
        return "Imagen: " + getImagenActual();
    }

    @Override
    public String obtenerConfiguracion() {
        return "Imágenes: " + imagenes.length + " | Imagen actual: " + (indiceImagen + 1);
    }

    public String getImagenActual() {
        return imagenes[indiceImagen];
    }

    @Override
    public JComponent obtenerVista() {
        return new JPanel();
    }
}
