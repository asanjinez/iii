package org.dominio.perfiles.dietas;

import org.dominio.Receta;

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
