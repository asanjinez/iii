package com.iii.model.perfiles;

import com.iii.model.Receta;
import com.iii.model.acciones.Accion;
import com.iii.model.acciones.AccionNotificarHabilitada;

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
