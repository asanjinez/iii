package com.iii.model.ingredientes.cantidad;


public class CantidadNecesaria extends InfoCantidad {
    private int cantidad;
    private Unidades unidad;

    public CantidadNecesaria(){
        this.cantidad = 0;
        this.unidad = Unidades.CN;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public Unidades getUnidad(){
        return this.unidad;
    }

    public void setUnidad(Unidades unidades) {
        this.unidad = unidades;
    }
    @Override
    public String toString() {
        return this.cantidad + this.unidad.getUnidades();
    }
}
