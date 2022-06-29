package org.dominio.acciones;
import org.dominio.Receta;
import org.dominio.perfiles.Perfil;
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