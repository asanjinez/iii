package org.dominio;

import org.dominio.acciones.AccionAgregarReceta;
import org.dominio.acciones.AccionNotificarPerfil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ranking implements Observer {
    String nombre;
    List<Receta> recetas;
    AccionAgregarReceta accionAgregarReceta;
    public Ranking(String nombre){
        this.nombre = nombre;
        this.recetas = new ArrayList<Receta>();
        this.accionAgregarReceta = new AccionAgregarReceta(this);
    }
    @Override
    public void actualizar(Receta receta){
        this.accionAgregarReceta.accionar(receta);
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void ordenarRanking() {
        this.recetas = this.recetas.stream()
                .sorted(Comparator
                .comparing( (Receta s)-> (s.getPuntaje())).reversed())
                .collect(Collectors.toList());
    }

    public void agregarReceta(Receta receta){
        recetas.add(receta);
        this.ordenarRanking();

    }

    public void imprimirRanking(){
        System.out.println(this.nombre);
        for(Receta receta : this.recetas){
            System.out.print("Receta: " + receta.getNombre() + "\t");
            System.out.println("Puntaje: " + receta.getPuntaje());
        }
    }
}
