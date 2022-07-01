package com.iii.model.ingredientes;

import com.iii.model.ingredientes.cantidad.InfoCantidad;

import javax.persistence.*;

@Entity
@Table(name= "INGREDIENTES")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_INGREDIENTE")
    private TipoIngrediente grupo;
    @Column(name = "NOMBRE_INGREDIENTE")
    private String nombre;
    @Column(name = "CALORIAS_INGREDIENTE")
    private int calorias;

    @JoinColumn(name = "info_id",referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)

    private InfoCantidad infoCantidad;
    public Ingrediente(TipoIngrediente tipo, String nombre,InfoCantidad infoCantidad, int calorias) {
        this.grupo = tipo;
        this.nombre = nombre;
        this.calorias = calorias;
        this.infoCantidad = infoCantidad;
    }

    public Ingrediente() {
    }

    public Long getId() {
        return id;
    }

    public int getCantidad() {
        return infoCantidad.getCantidad();
    }

    public void setCantidad(InfoCantidad cantidad) {
        this.infoCantidad = cantidad;
    }
    public int getCalorias() {
        return this.getCalorias();
    }
    public TipoIngrediente getGrupo() {
        return this.grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}