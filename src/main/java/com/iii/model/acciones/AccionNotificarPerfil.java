package com.iii.model.acciones;

import com.iii.model.perfiles.Perfil;
import com.iii.model.Receta;
public class AccionNotificarPerfil extends Accion {
    Perfil perfil;
    public AccionNotificarPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    @Override
    public void accionar(Receta receta) {
        if (!this.estado)
            return;
        if (!perfil.getDieta().puedeComer(receta))
            perfil.notificar();
    }
}