package org.dominio.acciones;

import org.dominio.Receta;
import org.dominio.Recetario;
import org.dominio.perfiles.Perfil;

public class AccionAgregarHabilitada extends Accion{
    @Override
    public void accionar(Receta receta, Perfil perfil) {
        receta.sumarPuntaje(10);
        receta.notificarAgrego();
    }

    public void cambiarEstado(Receta receta, Perfil perfil){
        receta.setEstadoAgregar(new AccionAgregarDeshabilitada());
    }
}
