package org.dominio.acciones;

import org.dominio.Receta;
import org.dominio.Recetario;
import org.dominio.perfiles.Perfil;

public class AccionAgregarDeshabilitada extends Accion{
    public void accionar(Receta receta, Perfil perfil) {
        return;
    }

    public void cambiarEstado(Receta receta, Perfil perfil) {
        perfil.setEstadoNotificar(new AccionAgregarHabilitada());
    }
}
