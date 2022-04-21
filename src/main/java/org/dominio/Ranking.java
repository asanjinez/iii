package org.dominio;

import java.util.Comparator;
import java.util.List;

public class Ranking {
    String nombre;
    List<Receta> recetas;


    public Ranking(String nombre){
        this.nombre = nombre;
    }

    public void ordenarRanking() {
        this.recetas.stream().sorted(Comparator.comparing(x->x.getPuntaje()));
    }

    public void imprimirRanking(){
        for(Receta receta : this.recetas){
            System.out.print("Receta: " + receta.getNombre() + "\t");
            System.out.println("Puntaje: " + receta.getPuntaje());
        }
    }


}
