package com.iii;

import com.iii.model.Ranking;
import com.iii.model.Receta;
import com.iii.model.Recetario;
import com.iii.model.ingredientes.*;
import com.iii.model.ingredientes.cantidad.InfoCantidadDTO;
import com.iii.model.ingredientes.cantidad.Unidades;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RankingTest {
    Ingrediente ingrediente1;
    Ingrediente ingrediente2;

    Receta receta1;
    Receta receta2;
    Receta receta3;
    Receta receta4;

    Recetario recetario1;
    Recetario recetario2;
    Recetario recetario3;

    Ranking rankingMarzo;
    Ranking rankingAbril;
    Ranking rankingMayo;

    @Before
    public void before() {
        this.ingrediente1 = new Ingrediente(TipoIngrediente.CARNES, "Milanesa", new InfoCantidadDTO(1, Unidades.KG),20);
        this.ingrediente2 = new Ingrediente(TipoIngrediente.CARNES, "Cereal", new InfoCantidadDTO(3, Unidades.UNIDADES),44);

        this.receta1 = new Receta("Receta de prueba1");
        this.receta2 = new Receta("Receta de prueba2");
        this.receta3 = new Receta("Receta de prueba3");
        this.receta4 = new Receta("Receta de prueba4");

        this.recetario1 = new Recetario("Primer recetario");
        this.recetario2 = new Recetario("Segundo recetario");
        this.recetario3 = new Recetario("Tercero recetario");


        this.rankingMarzo = new Ranking("Ranking de Marzo");
        this.rankingAbril = new Ranking("Ranking de Abril");
        this.rankingMayo = new Ranking("Ranking de Mayo");

        //receta
        this.recetario1.suscribirse(this.rankingAbril);

        this.rankingAbril.agregarReceta(receta1);
        this.rankingAbril.agregarReceta(receta2);
        this.rankingAbril.agregarReceta(receta3);

    }

    @Test
    public void recetaAccionSumarPuntaje() {
        recetario1.agregarReceta(receta1);
        recetario1.agregarReceta(receta1);

        assertEquals(20, receta1.getPuntaje());
    }

    @Test
    public void seAgreganRecetasOrdenadasAlRanking() {
        this.recetario1.agregarReceta(receta1);
        this.recetario1.agregarReceta(receta1);
        this.recetario1.agregarReceta(receta1);

        this.recetario1.agregarReceta(receta2);
        this.recetario1.agregarReceta(receta2);

        this.recetario1.agregarReceta(receta3);

        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(0), receta1);
        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(1), receta2);
        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(2), receta3);
    }

    @Test
    public void seReordenaLalista() {
        this.recetario1.agregarReceta(receta1);
        this.recetario1.agregarReceta(receta1);
        this.recetario1.agregarReceta(receta1);

        this.recetario1.agregarReceta(receta2);
        this.recetario1.agregarReceta(receta2);

        this.recetario1.agregarReceta(receta3);

        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(0), receta1);
        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(1), receta2);
        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(2), receta3);
        //La receta 2 deberia estar primera
        this.recetario1.agregarReceta(receta2);
        this.recetario1.agregarReceta(receta2);

        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(0), receta2);
        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(1), receta1);
        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(2), receta3);
    }

    @Test
    public void recetasEnRankingsDistintos() {
        this.recetario2.suscribirse(rankingMarzo);
        this.rankingMarzo.agregarReceta(receta1);
        this.rankingMarzo.agregarReceta(receta2);

        this.recetario1.agregarReceta(receta1);
        this.recetario1.agregarReceta(receta2);

        this.recetario2.agregarReceta(receta1);
        this.recetario2.agregarReceta(receta2);

        this.recetario1.agregarReceta(receta2);
        this.recetario2.agregarReceta(receta2);


        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(0), receta2);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(0), receta2);
    }

    @Test
    public void recetasAccionAgregarDesactivada() {
        recetario1.agregarReceta(receta1);
        rankingAbril.getAccionAgregarReceta().cambiarEstado();

        recetario1.agregarReceta(receta1);
        recetario1.agregarReceta(receta1);

        rankingAbril.getAccionAgregarReceta().cambiarEstado();
        recetario1.agregarReceta(receta1);

        assertEquals("Error al desactivarAccionAgregar", 20, receta1.getPuntaje());

    }

}