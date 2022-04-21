package org.dominio.perfiles;

import org.dominio.Receta;

public class Carnivoro implements Perfil {
    @Override
    public boolean puedeComer(Receta receta) {
        return receta.contieneGrupoAlimenticio("Carnes") && receta.cantidadCalorias() >= 200;
    }
}
