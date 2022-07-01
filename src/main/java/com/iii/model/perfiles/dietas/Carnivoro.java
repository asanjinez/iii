package com.iii.model.perfiles.dietas;


import com.iii.model.Receta;

public class Carnivoro implements Dieta {
    private final String nombre = "Carnivoro";
    public String getNombre() {
        return nombre;
    }
    @Override
    public boolean puedeComer(Receta receta) {
        return receta.contieneGrupoAlimenticio("Carnes") && receta.cantidadCalorias() >= 200;
    }
}
