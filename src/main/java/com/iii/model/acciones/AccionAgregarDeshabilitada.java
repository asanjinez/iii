package com.iii.model.acciones;

import com.iii.model.Receta;
import com.iii.model.perfiles.Perfil;

public class AccionAgregarDeshabilitada implements Accion{
    public void accionar(Receta receta, Perfil perfil) {
        return;
    }

    public void cambiarEstado(Receta receta, Perfil perfil) {
        receta.setEstadoAgregar(new AccionAgregarHabilitada());
    }
}