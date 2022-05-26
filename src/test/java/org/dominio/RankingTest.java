package org.dominio;

import org.dominio.ingredientes.Ingrediente;
import org.dominio.ingredientes.TipoIngrediente;
import org.dominio.ingredientes.cantidad.Medibles;
import org.dominio.ingredientes.cantidad.Unidades;
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
            this.ingrediente1 = new Ingrediente(TipoIngrediente.CARNES, "Milanesa", new Medibles(1, Unidades.KG, 20));
            this.ingrediente2 = new Ingrediente(TipoIngrediente.CARNES, "Cereal", new Medibles(3, Unidades.UNIDADES, 44));

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


            receta1.agregarIngrediente(ingrediente1);

            receta2.agregarIngrediente(ingrediente1);
            receta2.agregarIngrediente(ingrediente2);

            receta3.agregarIngrediente(ingrediente1);
            receta3.agregarIngrediente(ingrediente2);
            receta3.agregarIngrediente(ingrediente1);
            receta3.agregarIngrediente(ingrediente2);

            recetario1.agregarReceta(receta1);

            recetario2.agregarReceta(receta1);
            recetario2.agregarReceta(receta2);

            recetario3.agregarReceta(receta1);
            recetario3.agregarReceta(receta2);
            recetario3.agregarReceta(receta3);

//                  puntajes iniciales
//                      receta1 = 30
//                      receta2 = 20
//                      receta3 = 10

            this.rankingMarzo.agregarReceta(receta1);
            this.rankingMarzo.agregarReceta(receta2);
            this.rankingMarzo.agregarReceta(receta3);

            this.rankingAbril.agregarReceta(receta1);
            this.rankingAbril.agregarReceta(receta2);
            this.rankingAbril.agregarReceta(receta3);
        }
    @Test
    public void recetaAccionSumarPuntaje(){
        assertEquals(20,receta2.getPuntaje());

        recetario1.agregarReceta(receta2);
        recetario2.agregarReceta(receta2);
        recetario3.agregarReceta(receta2);

        receta2.cambiarEstadoSumarPuntaje();
        recetario1.agregarReceta(receta2);
        recetario2.agregarReceta(receta2);
        recetario3.agregarReceta(receta2);

        receta2.cambiarEstadoSumarPuntaje();
        recetario1.agregarReceta(receta2);
        recetario2.agregarReceta(receta2);
        recetario3.agregarReceta(receta2);

        assertEquals(80,receta2.getPuntaje());
    }
    @Test
    public void seAgreganRecetasOrdenadasAlRanking(){

        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(0), receta1);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(1), receta2);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(2), receta3);

        //Le agrego +20 a la receta4
        this.recetario1.agregarReceta(receta4);
        this.recetario2.agregarReceta(receta4);

        this.rankingMarzo.agregarReceta(receta4);

        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(0), receta1);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(1), receta2);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(2), receta4);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(3), receta3);


    }

    @Test
    public void seReordenaLalista(){
        this.recetario1.agregarReceta(receta3);
        this.recetario1.agregarReceta(receta3);
        this.recetario1.agregarReceta(receta3);

        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(0), receta3);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(1), receta1);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(2), receta2);

    }

    @Test
    public void recetasEnRankingsDistintos(){
//      Le sumo +30 a la receta 3, con lo que deberia estar top1 en los dos rankings
        this.recetario3.agregarReceta(receta3);
        this.recetario3.agregarReceta(receta3);
        this.recetario3.agregarReceta(receta3);


        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(0), receta3);
        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(0), receta3);
    }

    @Test
    public void recetasAccionAgregarDesactivada(){
        //Desactivamos la accion de sumar
        receta1.cambiarEstadoSumarPuntaje();
        receta3.cambiarEstadoSumarPuntaje();

        //+0 receta1 y receta3, +20 receta2
        recetario1.agregarReceta(receta1);
        recetario2.agregarReceta(receta2);
        recetario1.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);

        //Activamos las acciones
        receta1.cambiarEstadoSumarPuntaje();
        receta3.cambiarEstadoSumarPuntaje();

//      +10 a todas
        recetario3.agregarReceta(receta1);
        recetario3.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);


        assertEquals("Error al desactivarAccionAgregar", 40, receta1.getPuntaje());
        assertSame("Error al desactivarAccionAgregar", 50, receta2.getPuntaje());
        assertSame("Error al desactivarAccionAgregar", 20, receta3.getPuntaje());

    }

}