package org.dominio.acciones;
public abstract class Accion {
    boolean estado = true;
    public void accionar() {}
    public void cambiarEstado() {
        this.estado = !estado;
    };

}