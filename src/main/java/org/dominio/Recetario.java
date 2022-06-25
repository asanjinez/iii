package org.dominio;

import org.dominio.perfiles.Perfil;

import java.util.ArrayList;
import java.util.List;

public class Recetario {
    String titulo;
    private List<Receta> recetas;
    private Observable publisherPerfiles;
    public Recetario(String nombre) {
        this.titulo = nombre;
        recetas = new ArrayList<Receta>();
        this.publisherPerfiles = new Observable();

    }
    public Observable getPublisherPerfiles() {
        return publisherPerfiles;
    }

    public int cantidadRecetas(){
        return recetas.size();
    }

    public void agregarReceta(Receta receta){
        recetas.add(receta);
        receta.accionAgregar();
        this.publisherPerfiles.notificarObservers(receta);
    }
    public void suscribir(Perfil perfil){
        this.publisherPerfiles.agregarObserver(perfil);
    }
}
