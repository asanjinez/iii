package com.iii.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Recetario extends Observable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "RECETAS")
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            fetch = FetchType.EAGER )
    @JoinTable(joinColumns =  @JoinColumn(name = "recetario_id"),
            inverseJoinColumns = @JoinColumn(name = "receta_id"))
    private List<Receta> recetas;

    public Recetario(String nombre) {
        this.titulo = nombre;
        recetas = new ArrayList<Receta>();
    }

    public Recetario() {}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
