package org.dominio.acciones;

import org.dominio.Receta;
import org.dominio.Recetario;
import org.dominio.perfiles.Perfil;

public class AccionNotificarHabilitada implements Accion{

    public void accionar(Receta receta, Perfil perfil) {
        System.out.println("Perfil "+ perfil.getNombre() +" notificado");
    }

    public void cambiarEstado(Receta receta, Perfil perfil) {
        perfil.setEstadoNotificar(new AccionAgregarDeshabilitada());
    }
}
