package org.dominio;

import org.dominio.Recetario;
import org.dominio.perfiles.Perfil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
    private List<Perfil> perfiles;
    private Perfil perfilActual;

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public Perfil getPerfilActual() {
        return perfilActual;
    }

    public Usuario(){
        this.perfiles = new ArrayList<Perfil>();
        this.perfilActual = null;
    }
    public void agegarPerfil(Perfil perfil){
        this.perfiles.add(perfil);
        if (this.getPerfilActual() == null){
            perfilActual = perfil;
        }
    }

    public void cambiarPerfil(String nombre) {
        try {
            Perfil perfilCambio = this.filtrarPerfiles(nombre).get(0);
            this.perfilActual = perfilCambio;
            System.out.println("Cambiaste al perfil " + perfilCambio.getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void suscribirse(Recetario recetario){
        recetario.getNotificadorPerfiles().agregarPerfil(perfilActual);
    }
    public List<Perfil> filtrarPerfiles(String nombre) throws Exception {
        List<Perfil> perfiles = this.perfiles.stream().filter(x-> x.getNombre() == nombre).collect(Collectors.toList());
        if (perfiles.size() == 0){
            throw new Exception("Error: No existe el perfil");
        } else {
            return perfiles;
        }
    }

}
