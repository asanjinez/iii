package org.dominio.acciones;

import org.dominio.Receta;

public abstract class Accion {
    boolean estado = true;
    public void accionar(Receta receta) {}
    public void cambiarEstado() {
        this.estado = !estado;
    };

}