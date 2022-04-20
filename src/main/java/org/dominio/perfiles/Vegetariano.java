package org.dominio.perfiles;

import org.dominio.Receta;

public class Vegetariano implements Perfil {

    @Override
    public boolean puedeComer(Receta receta) {
        return !receta.contieneGrupoAlimenticio("Carnes");
    }
}
