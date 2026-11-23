package view;

import controller.DashboardController;
import model.Renderizable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

public class DashboardView extends JFrame {

    private final JPanel panelWidgets = new JPanel(new GridLayout(0, 2, 10, 10));
    private final JTextField campoBusqueda = new JTextField(18);
    private final JTextArea areaResultado = new JTextArea(4, 40);
    private final JButton botonListar = new JButton("Listar widgets");
    private final JButton botonBuscar = new JButton("Buscar");
    private final JButton botonOrdenar = new JButton("Ordenar por memoria");
    private final JButton botonActualizar = new JButton("Actualizar vistas");

    private DashboardController controlador;

    public DashboardView() {
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 760);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel titulo = new JLabel("PANEL DE CONTROL", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(22f));
        titulo.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        add(titulo, BorderLayout.NORTH);

        panelWidgets.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JScrollPane scrollWidgets = new JScrollPane(panelWidgets);
        add(scrollWidgets, BorderLayout.CENTER);

        add(crearPanelInferior(), BorderLayout.SOUTH);
    }

    private JPanel crearPanelInferior() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(8, 10, 10, 10));

        JPanel botones = new JPanel();
        botones.add(botonListar);
        botones.add(campoBusqueda);
        botones.add(botonBuscar);
        botones.add(botonOrdenar);
        botones.add(botonActualizar);

        areaResultado.setEditable(false);
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);
        areaResultado.setPreferredSize(new Dimension(860, 90));

        panel.add(botones, BorderLayout.NORTH);
        panel.add(new JScrollPane(areaResultado), BorderLayout.CENTER);
        return panel;
    }

    public void setControlador(DashboardController controlador) {
        this.controlador = controlador;
    }

    public DashboardController getControlador() {
        return controlador;
    }

    public JButton getBotonListar() {
        return botonListar;
    }

    public JButton getBotonBuscar() {
        return botonBuscar;
    }

    public JButton getBotonOrdenar() {
        return botonOrdenar;
    }

    public JButton getBotonActualizar() {
        return botonActualizar;
    }

    public JTextField getCampoBusqueda() {
        return campoBusqueda;
    }

    public void mostrarWidgets(List<Renderizable> widgets) {
        panelWidgets.removeAll();

        for (Renderizable widget : widgets) {
            panelWidgets.add(widget.obtenerVista());
        }

        panelWidgets.revalidate();
        panelWidgets.repaint();
    }

    public void mostrarMensaje(String mensaje) {
        areaResultado.setText(mensaje);
        areaResultado.setCaretPosition(0);
    }
}
