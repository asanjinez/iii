package org.dominio;

import java.util.ArrayList;
import java.util.List;

public class Recetario {
    String titulo;
    List<Receta> recetas;

    public Recetario(String nombre) {
        this.titulo = nombre;
        recetas = new ArrayList<Receta>();
    }

    public void agregarReceta(Receta receta) {
        recetas.add(receta);
    }

    public int cantidadRecetas(){
        return recetas.size();
    }
}
