package model;

public abstract class Widget implements Renderizable {

    private final String id;
    private final String nombre;
    private final int memoriaKB;

    public Widget(String id, String nombre, int memoriaKB) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del widget es obligatorio.");
        }

        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
    }

    @Override
    public int compareTo(Renderizable otroWidget) {
        return Integer.compare(this.memoriaKB, otroWidget.getMemoriaKB());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getMemoriaKB() {
        return memoriaKB;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Nombre: " + nombre
                + " | Memoria: " + memoriaKB + " KB"
                + " | Tipo: " + getClass().getSimpleName();
    }
}
