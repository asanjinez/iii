package com.iii.model.perfiles.dietas;
import com.iii.model.Receta;

public interface Dieta {
    boolean puedeComer(Receta receta);
    String getNombre();
}
