package org.dominio.perfiles;

import org.dominio.Receta;
import org.dominio.acciones.Accion;
import org.dominio.acciones.AccionNotificarHabilitada;

public class Vegano implements Perfil {
    private final String nombre = "Vegano";
    private Accion estadoNotificar;
    public Vegano() {
        this.estadoNotificar = new AccionNotificarHabilitada();
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
        return !receta.contieneGrupoAlimenticio("Carnes") && !receta.contieneGrupoAlimenticio("Lacteos");
    }
}
