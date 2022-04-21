package org.dominio.acciones;

import org.dominio.Receta;

public interface Accion {
    public void accionar(Receta receta);
    public void cambiarEstado(Receta receta);
}
