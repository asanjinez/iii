package org.dominio;

import java.util.ArrayList;
import java.util.List;

public class Recetario extends Observable {
    String titulo;
    private List<Receta> recetas;

    public Recetario(String nombre) {
        super();
        this.titulo = nombre;
        recetas = new ArrayList<Receta>();
    }

    @Override
    public void notificarObservers() {
    }

    @Override
    public void notificarObservers(Object object){
        Receta receta = (Receta) object;
        this.getObservers().stream().forEach(observer -> observer.actualizar(receta));
    }

    public int cantidadRecetas(){
        return recetas.size();
    }

    public void agregarReceta(Receta receta){
        recetas.add(receta);
        receta.accionAgregar();
        this.notificarObservers(receta);
    }
}
