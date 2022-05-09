package com.iii.model.ingredientes;

import com.iii.model.Receta;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "INGREDIENTES")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    @Column(name = "TIPO_INGREDIENTE")
    private final TipoIngrediente grupo;
    @Column(name = "NOMBRE_INGREDIENTE",
            unique = true)
    private String nombre;
    @Column(name = "CALORIAS")
    private int calorias;
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "UNIDAD")
    private final String unidad;

    @ManyToMany(mappedBy = "ingredientes")
    private List<Receta> recetas;

    public Ingrediente() {
        this.grupo = null;
        this.unidad = null;
    }

    public Ingrediente(TipoIngrediente grupo, String nombre, int calorias, int cantidad, String unidad) {
        this.grupo = grupo;
        this.nombre = nombre;
        this.calorias = calorias;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.recetas = new ArrayList<Receta>();
    }

    public Long getId() {
        return id;
    }
    public String getGrupo() {
        return this.grupo.getTipo();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "id=" + id +
                ", grupo=" + grupo +
                ", nombre='" + nombre + '\'' +
                ", calorias=" + calorias +
                ", cantidad=" + cantidad +
                ", unidad='" + unidad + '\'' +
                '}';
    }
}
