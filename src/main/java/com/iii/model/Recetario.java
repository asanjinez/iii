package com.iii.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Recetario extends Observable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITULO")
    private String nombre;
    @Column(name = "RECETAS")
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            fetch = FetchType.EAGER )
    @JoinTable(joinColumns =  @JoinColumn(name = "recetario_id"),
            inverseJoinColumns = @JoinColumn(name = "receta_id"))
    private List<Receta> recetas;
    public Recetario(String nombre) {
        this.nombre = nombre;
        recetas = new ArrayList<Receta>();
    }

    public Recetario() {}
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String titulo) {
        this.nombre = titulo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    public int cantidadRecetas(){
        return recetas.size();
    }

    public void agregarReceta(Receta receta){
        recetas.add(receta);
        this.notificarObservers(receta);
    }
    public void suscribirse(Ranking ranking){
        this.agregarObserver(ranking);
    }
}
