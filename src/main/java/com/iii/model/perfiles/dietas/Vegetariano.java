package com.iii.model.perfiles.dietas;

import com.iii.model.Receta;
public class Vegetariano implements Dieta {
    private final String nombre = "Vegetariano";
    public String getNombre() {
        return nombre;
    }
    @Override
    public boolean puedeComer(Receta receta) {
        return !receta.contieneGrupoAlimenticio("Carnes");
    }
}
