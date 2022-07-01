package com.iii.model.acciones;

import com.iii.model.Ranking;
import com.iii.model.Receta;

public class AccionAgregarReceta extends Accion {
    private Ranking ranking;

    public AccionAgregarReceta(Ranking ranking){
        this.ranking = ranking;
    }
    @Override
    public void accionar(Receta receta) {
        if (!this.estado)
            return;
        int index = this.ranking.getRecetas().indexOf(receta);
        if (index == -1)
            return;
        receta.sumarPuntaje(10);
        this.ranking.ordenarRanking();
    }
}