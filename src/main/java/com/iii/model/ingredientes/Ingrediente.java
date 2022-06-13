package com.iii.model.ingredientes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_INGREDIENTE")
    private TipoIngrediente grupo;
    @Column(name = "NOMBRE_INGREDIENTE",
            unique = true)
    private String nombre;
    @Column(name = "CALORIAS")
    private int calorias;
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "UNIDAD")
    private String unidad;

    @ManyToMany(mappedBy = "ingredientes")
    @JsonIgnore
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
    public void setId(Long id) {
        this.id = id;
    }
    public TipoIngrediente getGrupo() {
        return this.grupo;
    }

    public void setGrupo(TipoIngrediente grupo){this.grupo = grupo;}

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
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public List<Receta> getRecetas() {
        return recetas;
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
