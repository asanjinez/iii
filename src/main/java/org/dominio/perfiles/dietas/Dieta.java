package org.dominio.perfiles.dietas;

import org.dominio.Receta;

public interface Dieta {
    boolean puedeComer(Receta receta);
    String getNombre();
}
