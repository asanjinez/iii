package com.iii.model.acciones;

import com.iii.model.Receta;
import com.iii.model.perfiles.Perfil;
public class AccionAgregarHabilitada implements Accion{
    @Override
    public void accionar(Receta receta, Perfil perfil) {
        receta.sumarPuntaje(10);
        receta.notificarAgrego();
    }

    public void cambiarEstado(Receta receta, Perfil perfil){
        receta.setEstadoAgregar(new AccionAgregarDeshabilitada());
    }
}
