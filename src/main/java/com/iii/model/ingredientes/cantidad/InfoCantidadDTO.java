package com.iii.model.ingredientes.cantidad;

import javax.persistence.*;

@Table(name = "informacion_ingrediente")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class InfoCantidadDTO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "UNIDADES")
    @Enumerated(EnumType.STRING)
    private Unidades unidad;


    public InfoCantidadDTO(int cantidad, Unidades unidades) {
        this.cantidad = cantidad;
        this.unidad = unidades;
    }

    public InfoCantidadDTO() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
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
