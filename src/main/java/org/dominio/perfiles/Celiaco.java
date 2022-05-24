package org.dominio.perfiles;

import org.dominio.Receta;

public class Celiaco implements Perfil {
    @Override
    public boolean puedeComer(Receta receta) {
        return !receta.contieneGrupoAlimenticio("Cereales");
    }
}
