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
/*
TODO Deberia implementar un especie de observer? porque acada vez que se agrega una receta a un recetario, posiblemente
    el ranking se deba volver a ordenar??
 */
    public int cantidadRecetas(){
        return recetas.size();
    }

    public void agregarReceta(Receta receta){
        recetas.add(receta);
        receta.accionAgregar();

    }

}
