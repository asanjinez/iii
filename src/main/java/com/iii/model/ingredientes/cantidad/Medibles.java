package com.iii.model.ingredientes.cantidad;

import javax.persistence.*;


@Entity
@DiscriminatorValue(value="Medibles")

public class Medibles extends InfoCantidad {
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "UNIDADES")
    @Enumerated(EnumType.STRING)
    private Unidades unidad;


    public Medibles(int cantidad, Unidades unidades) {
        this.cantidad = cantidad;
        this.unidad = unidades;
    }

    public Medibles() {
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
}
