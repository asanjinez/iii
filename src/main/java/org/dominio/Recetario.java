package org.dominio;

import org.dominio.acciones.Accion;
import org.dominio.acciones.AccionNotificarHabilitada;

import java.util.ArrayList;
import java.util.List;

public class Recetario {
    String titulo;
    private List<Receta> recetas;

    private PublisherPerfil notificadorPerfiles;

    private Accion estadoNotificar;

    public PublisherPerfil getNotificadorPerfiles() {
        return notificadorPerfiles;
    }

    public void setEstadoNotificar(Accion estadoNotificar) {
        this.estadoNotificar = estadoNotificar;
    }

    public Recetario(String nombre) {
        this.titulo = nombre;
        recetas = new ArrayList<Receta>();
        notificadorPerfiles = new PublisherPerfil();
        estadoNotificar = new AccionNotificarHabilitada();

    }
/*
TODO Deberia implementar un especie de observer? porque acada vez que se agrega una receta a un recetario, posiblemente
    el ranking se deba volver a ordenar??
 */
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
