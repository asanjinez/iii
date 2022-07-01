package com.iii.model.ingredientes.cantidad;

import com.iii.model.ingredientes.Ingrediente;

import javax.persistence.*;

//@MappedSuperclass
@Entity
public class CantidadNecesaria extends InfoCantidad {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Long Id;
//    @Column(name = "CANTIDAD")
    private final int cantidad = 0;

//    @Column(name = "UNIDADES")
//    @Enumerated(EnumType.STRING)
    private Unidades unidades = Unidades.ND;

//    @JoinColumn(name = "ingrediente_id")
//    @OneToOne(fetch = FetchType.LAZY)
//    Ingrediente ingrediente;
    public  CantidadNecesaria(){}
    @Override
    public String toString() {
        return "Cantidad Necesaria";
    }
}