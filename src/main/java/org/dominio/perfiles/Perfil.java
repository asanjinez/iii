package org.dominio.perfiles;

import org.dominio.Observer;
import org.dominio.Receta;
import org.dominio.acciones.AccionNotificarPerfil;
import org.dominio.perfiles.dietas.Dieta;
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
    public void actualizar() {
    }
    @Override
    public void actualizar(Receta receta) {
        if (!this.getDieta().puedeComer(receta))
            return;
        this.accionNotificar.accionar();
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

