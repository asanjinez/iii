package com.iii.model.acciones;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.iii.model.Receta;

//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class Accion {
    boolean estado = true;
    public void accionar(Receta receta) {
    }
    public void cambiarEstado() {
        this.estado = !estado;
    }
}