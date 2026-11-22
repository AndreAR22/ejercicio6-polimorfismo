package view;

import model.Renderizable;

import javax.swing.JFrame;
import java.util.List;

public class DashboardView extends JFrame {

    public DashboardView() {
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 760);
        setLocationRelativeTo(null);
    }

    public void mostrarWidgets(List<Renderizable> widgets) {
    }

    public void mostrarMensaje(String mensaje) {
    }
}
