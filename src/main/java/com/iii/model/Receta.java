package com.iii.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iii.model.acciones.Accion;
import com.iii.model.acciones.AccionAgregarHabilitada;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.perfiles.Perfil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Receta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMBRE_RECETA",
            unique = true)
    private String nombre;

    @Transient
    private int puntaje;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
                fetch = FetchType.EAGER )
    @JoinTable(joinColumns =  @JoinColumn(name = "receta_id"),
    inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    @Transient
    @JsonIgnore
    PublisherRanking notificadorCambios;
    @Transient
    @JsonIgnore
    private Accion estadoAgregar;
    @ManyToMany(mappedBy = "recetas")
    @JsonIgnore
    private List<Recetario> recetarios;

    public Receta(){
        this.puntaje = 0;
        this.notificadorCambios = new PublisherRanking();
        this.estadoAgregar = new AccionAgregarHabilitada();
    }
    public Receta(String titulo) {
        this.nombre = titulo;
        this.ingredientes = new ArrayList<Ingrediente>();
        this.puntaje = 0;
        this.notificadorCambios = new PublisherRanking();
        this.estadoAgregar = new AccionAgregarHabilitada();
    }

    public void sumarPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public int cantidadCalorias() {
        return ingredientes.stream().map(ingrediente -> ingrediente.getCalorias()).reduce(0, Integer::sum);
    }
    public void agregarIngrediente(Ingrediente ingredientePorAgregar){
        this.ingredientes.add(ingredientePorAgregar);
    }

    public int cantidadIngredientes(){
        return this.ingredientes.size();
    }

    public boolean contieneAlimento(String alimento){
        return ingredientes.stream().anyMatch(x->x.getNombre() == alimento);
    }

    public boolean contieneGrupoAlimenticio(String grupo){
        return this.ingredientes.stream().anyMatch(ingrediente -> ingrediente.getGrupo().getTipo()== grupo);
    }
    //Preguntar si este metodo es valido
    public boolean esAptoPara(Perfil perfil) {
        return perfil.puedeComer(this);
    }

    public void accionAgregar(){
        this.estadoAgregar.accionar(this,null);

    }

    public void cambiarEstadoAgregar(){
        this.estadoAgregar.cambiarEstado(this,null);
    }

    public void notificarAgrego(){
        this.notificadorCambios.notificarRankings();
    }


    @Override
    public String toString() {
        return "Receta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ingredientes=" + ingredientes +
                ", puntaje=" + puntaje +
                '}';
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id; }
    public PublisherRanking getNotificadorCambios() {
        return notificadorCambios;
    }

    public void setNotificadorCambios(PublisherRanking notificadorCambios) {
        this.notificadorCambios = notificadorCambios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getPuntaje(){
        return puntaje;

    }

    public List<Recetario> getRecetarios() {
        return recetarios;
    }
    public Accion getEstadoAgregar() {
        return estadoAgregar;
    }

    public void setEstadoAgregar(Accion estadoAgregar) {
        this.estadoAgregar = estadoAgregar;
    }
}

