package com.iii.model.ingredientes.cantidad;

import com.iii.model.ingredientes.Ingrediente;

import javax.persistence.*;
@Table(name = "informacion_ingrediente")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class InfoCantidad {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "UNIDADES")
    @Enumerated(EnumType.STRING)
    private Unidades unidades;

    @OneToOne(mappedBy = "infoCantidad", fetch = FetchType.LAZY)
    Ingrediente ingrediente;
    public InfoCantidad(){
    }
    public Long getId() {
        return Id;
    }
    public int getCantidad(){
        return this.cantidad;
    }

    public String getUnidades(){
        return this.unidades.getUnidades();
    }

    public abstract String toString();
}
