package org.dominio;

import org.dominio.acciones.Accion;
import org.dominio.acciones.AccionNotificarHabilitada;

import java.util.ArrayList;
import java.util.List;

public class Recetario {
    String titulo;
    private List<Receta> recetas;
    private PublisherPerfil notificadorPerfiles;

    public Recetario(String nombre) {
        this.titulo = nombre;
        recetas = new ArrayList<Receta>();
        notificadorPerfiles = new PublisherPerfil();
    }

    public PublisherPerfil getNotificadorPerfiles() {
        return notificadorPerfiles;
    }
    public int cantidadRecetas(){
        return recetas.size();
    }

    public void accionNotificar(Receta receta){
        this.notificadorPerfiles.notificarPerfiles(receta);
    }

    public void agregarReceta(Receta receta){
        recetas.add(receta);
        receta.accionAgregar();
        this.accionNotificar(receta);
    }
}
