package com.iii.model.ingredientes.cantidad;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CantidadNecesaria")
public class CantidadNecesaria extends InfoCantidad {
    @Column(name = "UNIDADES")
    @Enumerated(EnumType.STRING)
    private Unidades unidad;

    public CantidadNecesaria(Unidades unidades){
        this.unidad = Unidades.CN;
    }
    public CantidadNecesaria(){
        this.unidad = Unidades.CN;
    }
    @Override
    public int getCantidad(){
        return 0;
    }

    public Unidades getUnidad(){
        return this.unidad;
    }

    public void setUnidad(Unidades unidades) {
        this.unidad = unidades;
    }

    public String toString() {
        return "Cantidad Necesaria";
    }
}
