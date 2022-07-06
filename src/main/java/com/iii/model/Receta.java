package com.iii.model;

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
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            fetch = FetchType.EAGER )
    @JoinTable(joinColumns =  @JoinColumn(name = "receta_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    @Column(name = "PUNTAJE")
    private int puntaje;
    public Receta(String titulo) {
        this.nombre = titulo;
        this.ingredientes = new ArrayList<Ingrediente>();
        this.puntaje = 0;
    }
    public Receta(){}
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public int getPuntaje() {
        return puntaje;
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

    public boolean esAptoPara(Perfil perfil) {
        return perfil.getDieta().puedeComer(this);
    }
}

