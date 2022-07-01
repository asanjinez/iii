package com.iii.model.acciones;

import com.iii.model.Receta;

public abstract class Accion {
    boolean estado = true;

    public void accionar(Receta receta) {
    }

    public void cambiarEstado() {
        this.estado = !estado;
    }
}