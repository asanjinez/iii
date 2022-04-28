package org.dominio.perfiles;

import org.dominio.Receta;
import org.dominio.acciones.Accion;
import org.dominio.acciones.AccionNotificarHabilitada;

public class Vegetariano implements Perfil {
    private final String nombre = "Vegetariano";
    private Accion estadoNotificar;

    public Accion getEstadoNotificar() {
        return estadoNotificar;
    }

    public void setEstadoNotificar(Accion estadoNotificar) {
        this.estadoNotificar = estadoNotificar;
    }

    public Vegetariano() {
        this.estadoNotificar = new AccionNotificarHabilitada();
    }

    public Vegetariano(Accion accionNotificar) {
        this.estadoNotificar = accionNotificar;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean puedeComer(Receta receta) {
        return !receta.contieneGrupoAlimenticio("Carnes");
    }
}
