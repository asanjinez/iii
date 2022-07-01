package com.iii.model.ingredientes.cantidad;

import com.iii.model.ingredientes.Ingrediente;

import javax.persistence.*;

//@MappedSuperclass
@Entity
public class Medibles extends InfoCantidad {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
//    @Column(name = "CANTIDAD")
    private int cantidad;

//    @Column(name = "UNIDADES")
//    @Enumerated(EnumType.STRING)
    private Unidades unidades;

//    @JoinColumn(name = "ingrediente_id")
//    @OneToOne(fetch = FetchType.LAZY)
//    Ingrediente ingrediente;
    public Medibles(int cantidad, Unidades unidades) {
        this.cantidad = cantidad;
        this.unidades = unidades;
    }

    public Medibles() {
    }
    @Override
    public String toString() {
        return Integer.toString(this.cantidad) + this.getUnidades();
    }
}