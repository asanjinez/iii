package com.iii.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Recetario {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "TITULO")
    String titulo;
    @Column(name = "RECETAS")
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
                fetch = FetchType.EAGER )
    @JoinTable(joinColumns =  @JoinColumn(name = "recetario_id"),
            inverseJoinColumns = @JoinColumn(name = "receta_id"))
    private List<Receta> recetas;
    @Transient
    private PublisherPerfil notificadorPerfiles = new PublisherPerfil();

    public Recetario(){

    }
    public Recetario(String nombre) {
        this.titulo = nombre;
        recetas = new ArrayList<Receta>();
    }

    public PublisherPerfil getNotificadorPerfiles() {
        return notificadorPerfiles;
    }
    public int cantidadRecetas(){
        return recetas.size();
    }

    public void accionNotificar(Receta receta){
        this.notificadorPerfiles.notificarPerfiles(receta);
    }

    public void agregarReceta(Receta receta){
        recetas.add(receta);
        receta.accionAgregar();
        this.accionNotificar(receta);
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
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

    @Override
    public String toString() {
        return "Recetario{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", recetas=" + recetas +
                ", notificadorPerfiles=" + notificadorPerfiles +
                '}';
    }
}
