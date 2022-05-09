package com.iii.model.acciones;

import com.iii.model.Receta;
import com.iii.model.perfiles.Perfil;

public class AccionNotificarHabilitada implements Accion{

    public void accionar(Receta receta, Perfil perfil) {
        System.out.println("Perfil "+ perfil.getNombre() +" notificado");
    }

    public void cambiarEstado(Receta receta, Perfil perfil) {
        perfil.setEstadoNotificar(new AccionAgregarDeshabilitada());
    }
}
