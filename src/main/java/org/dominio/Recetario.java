package org.dominio;

import org.dominio.perfiles.Perfil;

import java.util.ArrayList;
import java.util.List;

public class Recetario extends Observable{
    String titulo;
    private List<Receta> recetas;
    public Recetario(String nombre) {
        this.titulo = nombre;
        recetas = new ArrayList<Receta>();
    }
    public int cantidadRecetas(){
        return recetas.size();
    }

    public void agregarReceta(Receta receta){
        recetas.add(receta);
        this.notificarObservers(receta);
    }
    public void suscribirse(Ranking ranking){
        this.agregarObserver(ranking);
    }
}
