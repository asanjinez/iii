package org.dominio;

import org.dominio.acciones.Accion;
import org.dominio.acciones.AccionAgregarHabilitada;
import org.dominio.ingredientes.Ingrediente;
import org.dominio.perfiles.Perfil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Receta {
    PublisherRanking notificadorCambios;
    private String nombre;
    private List<Ingrediente> ingredientes;

    public List<Ingrediente> getIngredientes() { return ingredientes;}
    private int puntaje;

    private Accion estadoAgregar;

    public PublisherRanking getNotificadorCambios() {
        return this.notificadorCambios;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPuntaje() {
        return puntaje;
    }

    public void setEstadoAgregar(Accion estadoAgregar) {
        this.estadoAgregar = estadoAgregar;
    }

    public void sumarPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public int cantidadCalorias() {
        return ingredientes.stream().map(x -> x.getCalorias()).reduce(0, Integer::sum);
    }

    public Receta(String titulo) {
        this.nombre = titulo;
        this.ingredientes = new ArrayList<Ingrediente>();
        this.puntaje = 0;
        this.notificadorCambios = new PublisherRanking();
        this.estadoAgregar = new AccionAgregarHabilitada();
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
        return ingredientes.stream().anyMatch(x->x.getGrupo() == grupo);
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

}
