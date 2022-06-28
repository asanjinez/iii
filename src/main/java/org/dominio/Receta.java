package org.dominio;

import org.dominio.acciones.AccionAgregarReceta;
import org.dominio.ingredientes.Ingrediente;
import org.dominio.perfiles.Perfil;

import java.util.ArrayList;
import java.util.List;

public class Receta{
    private String nombre;
    private List<Ingrediente> ingredientes;
    private int puntaje;

    public Receta(String titulo) {
        this.nombre = titulo;
        this.ingredientes = new ArrayList<Ingrediente>();
        this.puntaje = 0;
    }
    public List<Ingrediente> getIngredientes() { return ingredientes;}
    public String getNombre() {
        return nombre;
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
        return ingredientes.stream().anyMatch(ingrediente -> ingrediente.getGrupo().getTipo() == grupo);
    }

//Consultar si es necesario un metodo para consultar desde la Receta
    public boolean esAptoPara(Perfil perfil) {
        return perfil.getDieta().puedeComer(this);
    }
}
