package Composite;

import java.util.ArrayList;
import java.util.List;

interface ArchivComponent {
    String getNombre();
    int getTamaño();
    void mostrar(String indentacion);
}

class Archivo implements ArchivComponent {
    private String nombre;
    private int tamaño;

    public Archivo(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getTamaño() {
        return tamaño;
    }

    @Override
    public void mostrar(String indentacion) {
        System.out.println(indentacion + "📄 Archivo: " + nombre + " (" + tamaño + " bytes)");
    }
}

class Carpeta implements ArchivComponent {
    private String nombre;
    private List<ArchivComponent> hijos;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getTamaño() {
        int tamañoTotal = 0;
        for (ArchivComponent componente : hijos) {
            tamañoTotal += componente.getTamaño();
        }
        return tamañoTotal;
    }

    public void añadir(ArchivComponent componente) {
        hijos.add(componente);
    }

    public void eliminar(ArchivComponent componente) {
        hijos.remove(componente);
    }

    @Override
    public void mostrar(String indentacion) {
        System.out.println(indentacion + "📁 Carpeta: " + nombre + " (" + getTamaño() + " bytes)");
        for (ArchivComponent componente : hijos) {
            componente.mostrar(indentacion + "    ");
        }
    }
}
