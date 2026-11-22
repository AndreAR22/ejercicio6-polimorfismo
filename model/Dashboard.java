package model;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {

    private final ArrayList<Renderizable> widgets = new ArrayList<>();

    public Dashboard() {
    }

    public List<Renderizable> listarWidgets() {
        return widgets;
    }
}
