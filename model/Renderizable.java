package model;

import javax.swing.JComponent;

public interface Renderizable extends Comparable<Renderizable> {
    String getId();
    String getNombre();
    int getMemoriaKB();
    String obtenerConfiguracion();
    String obtenerTexto();
    JComponent obtenerVista();
}
