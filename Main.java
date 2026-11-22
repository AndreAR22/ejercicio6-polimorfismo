import controller.DashboardController;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DashboardController controlador = new DashboardController();
            controlador.iniciar();
        });
    }
}
