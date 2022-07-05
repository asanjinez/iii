package com.iii.model.ingredientes.cantidad;

public class InfoCantidad {
    private int cantidad;
    private Unidades unidad;

    public InfoCantidad(int cantidad, Unidades unidades) {
        this.cantidad = cantidad;
        this.unidad = unidades;
    }
    public InfoCantidad(){
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Unidades getUnidad(){
        return this.unidad;
    }

    public void setUnidad(Unidades unidades) {
        this.unidad = unidades;
    }
    @Override
    public String toString() {
        return "Cantidad Necesaria";
    }
}