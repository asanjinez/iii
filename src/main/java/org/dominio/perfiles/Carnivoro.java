package org.dominio.perfiles;

import org.dominio.Receta;
import org.dominio.acciones.Accion;
import org.dominio.acciones.AccionNotificarHabilitada;

public class Carnivoro implements Perfil {
    private final String nombre = "Carnivoro";
    private Accion estadoNotificar;

    public Accion getEstadoNotificar() {
        return estadoNotificar;
    }

    public void setEstadoNotificar(Accion estadoNotificar) {
        this.estadoNotificar = estadoNotificar;
    }

    public Carnivoro() {
        this.estadoNotificar = new AccionNotificarHabilitada();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean puedeComer(Receta receta) {
        return receta.contieneGrupoAlimenticio("Carnes") && receta.cantidadCalorias() >= 200;
    }
}
