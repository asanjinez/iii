package org.dominio.perfiles.dietas;

import org.dominio.Receta;
import org.dominio.acciones.AccionNotificarPerfil;

public class Carnivoro implements Dieta {
    private final String nombre = "Carnivoro";
    public String getNombre() {
        return nombre;
    }
    @Override
    public boolean puedeComer(Receta receta) {
        return receta.contieneGrupoAlimenticio("Carnes") && receta.cantidadCalorias() >= 200;
    }
}
