package com.iii.model.perfiles;

import com.iii.model.Receta;
import com.iii.model.acciones.Accion;
import com.iii.model.acciones.AccionNotificarHabilitada;

public class Vegetariano implements Perfil {
    private final String nombre = "Vegetariano";
    private Accion estadoNotificar;

    public Vegetariano() {
        this.estadoNotificar = new AccionNotificarHabilitada();
    }
    public Vegetariano(Accion accionNotificar) {
        this.estadoNotificar = accionNotificar;
    }
    public Accion getEstadoNotificar() {
        return estadoNotificar;
    }

    public void setEstadoNotificar(Accion estadoNotificar) {
        this.estadoNotificar = estadoNotificar;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean puedeComer(Receta receta) {
        return !receta.contieneGrupoAlimenticio("Carnes");
    }
}