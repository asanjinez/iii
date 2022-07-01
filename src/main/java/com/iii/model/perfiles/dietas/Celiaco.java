package com.iii.model.perfiles.dietas;

import com.iii.model.Receta;

public class Celiaco implements Dieta {
    private final String nombre = "Celiaco";
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean puedeComer(Receta receta) {
        return !receta.contieneGrupoAlimenticio("Cereales");
    }
}
