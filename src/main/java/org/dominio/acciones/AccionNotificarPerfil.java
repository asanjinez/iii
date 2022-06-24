package org.dominio.acciones;
import org.dominio.perfiles.Perfil;
public class AccionNotificarPerfil extends Accion {
    Perfil perfil;

    public AccionNotificarPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public void accionar() {
        if (!this.estado)
            return;
        perfil.notificar();

    }
}