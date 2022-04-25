package org.dominio;

import org.dominio.perfiles.Perfil;
import java.util.ArrayList;
import java.util.List;

public class PublisherPerfil {
    private List<Perfil> perfiles;

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public PublisherPerfil(){
        this.perfiles = new ArrayList<Perfil>();
    }
    public void agregarPerfil(Perfil perfil){
        this.perfiles.add(perfil);
    }

    public void sacarPerfil(Perfil perfil){
        this.perfiles.remove(perfil);
    }

    public void notificarPerfiles(Receta receta){
        this.perfiles.stream().filter(perfil-> perfil.puedeComer(receta)).forEach(perfil -> perfil.getEstadoNotificar().accionar(null,perfil));
    }


}
