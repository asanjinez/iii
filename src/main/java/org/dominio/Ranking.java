package org.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ranking {
    String nombre;
    List<Receta> recetas;


    public Ranking(String nombre){
        this.nombre = nombre;
        this.recetas = new ArrayList<Receta>();
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void ordenarRanking() {
        this.recetas = this.recetas.stream()
                .sorted(Comparator
                .comparing( (Receta s)-> (s.getPuntaje())).reversed())
                .collect(Collectors.toList());
    /*
    sorted(Comparator.<String>comparingInt(s->Integer.parseInt(s.split(":")[0].trim())).reversed())
            .collect(Collectors.toList());

     */
    }

    public void agregarReceta(Receta receta){
        recetas.add(receta);
        this.ordenarRanking();
        receta.getNotificadorCambios().agregarRanking(this);
    }

    public void imprimirRanking(){
        System.out.println(this.nombre);
        for(Receta receta : this.recetas){
            System.out.print("Receta: " + receta.getNombre() + "\t");
            System.out.println("Puntaje: " + receta.getPuntaje());
        }
    }


}
