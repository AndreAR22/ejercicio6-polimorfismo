package model;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class WeatherWidget extends Widget implements Interactivo {

    private final String ciudad;
    private final double temperaturaCelsius;
    private boolean usarFahrenheit;

    public WeatherWidget(String id, String nombre, int memoriaKB, String ciudad, double temperaturaCelsius) {
        super(id, nombre, memoriaKB);

        if (ciudad == null || ciudad.isBlank()) {
            throw new IllegalArgumentException("La ciudad es obligatoria.");
        }

        this.ciudad = ciudad;
        this.temperaturaCelsius = temperaturaCelsius;
        this.usarFahrenheit = false;
    }

    @Override
    public String interactuar() {
        usarFahrenheit = !usarFahrenheit;
        return "Unidad cambiada a " + (usarFahrenheit ? "°F" : "°C") + ".";
    }

    @Override
    public String obtenerTexto() {
        if (usarFahrenheit) {
            return String.format("%s: %.1f °F", ciudad, temperaturaCelsius * 9 / 5 + 32);
        }
        return String.format("%s: %.1f °C", ciudad, temperaturaCelsius);
    }

    @Override
    public String obtenerConfiguracion() {
        return "Ciudad: " + ciudad
                + " | Temperatura base: " + temperaturaCelsius + " °C"
                + " | Unidad actual: " + (usarFahrenheit ? "Fahrenheit" : "Celsius");
    }

    @Override
    public JComponent obtenerVista() {
        return new JPanel();
    }
}
