package org.dominio;

import org.dominio.ingredientes.Ingrediente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Receta {
    private String nombre;
    private List<Ingrediente> ingredientes;

    public Receta(String titulo) {
        this.nombre = titulo;
        this.ingredientes = new ArrayList<Ingrediente>();
    }
    public List<Ingrediente> getIngredientes() { return ingredientes;}

    public int cantidadCalorias() {
        return ingredientes.stream().map(x -> x.getCalorias()).reduce(0, Integer::sum);
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
        return ingredientes.stream().anyMatch(x->x.getGrupo().getTipo() == grupo);

    }

}
