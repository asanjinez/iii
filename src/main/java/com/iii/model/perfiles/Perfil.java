package com.iii.model.perfiles;

import com.iii.model.Observer;
import com.iii.model.Receta;
import com.iii.model.acciones.AccionNotificarPerfil;
import com.iii.model.perfiles.dietas.Dieta;

public class Perfil implements Observer {
    Dieta dieta;
    AccionNotificarPerfil accionNotificar;
    public Perfil(Dieta dieta) {
        this.dieta = dieta;
        this.accionNotificar = new AccionNotificarPerfil(this);
    }
    public Perfil(Dieta dieta, AccionNotificarPerfil accionNotificarPerfil) {
        this.dieta = dieta;
        this.accionNotificar = accionNotificarPerfil;
    }
    @Override
    public void actualizar(Receta receta) {
        this.accionNotificar.accionar(receta);
    }
    public void notificar() {
        /*
        Aca iria la implementacion de la notifiacion
         */
    }
    public AccionNotificarPerfil getAccionNotificar() {
        return this.accionNotificar;
    }
    void setAccionNotificar(AccionNotificarPerfil accion) {
        this.accionNotificar = accion;
    }
    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }


}

