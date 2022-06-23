package org.dominio.perfiles.dietas;

import org.dominio.Receta;

public class Vegano implements Dieta {
    private final String nombre = "Vegano";
    public String getNombre() {
        return nombre;
    }
    @Override
    public boolean puedeComer(Receta receta) {
        return !receta.contieneGrupoAlimenticio("Carnes") && !receta.contieneGrupoAlimenticio("Lacteos");
    }
}