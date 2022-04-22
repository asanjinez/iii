package org.dominio;

import org.dominio.ingredientes.Carnes;
import org.dominio.ingredientes.Cereales;
import org.dominio.ingredientes.Ingrediente;
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
            this.ingrediente1 = new Carnes("Milanesa", 1, 20, "Gramos");
            this.ingrediente2 = new Cereales("Cereal", 3, 44, "Unidades");

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

//          putnajes iniciales
//          receta1 = 30
//          receta2 = 20
//          receta3 = 10


            this.rankingMarzo.agregarReceta(receta1);
            this.rankingMarzo.agregarReceta(receta2);
            this.rankingMarzo.agregarReceta(receta3);

            this.rankingAbril.agregarReceta(receta1);
            this.rankingAbril.agregarReceta(receta2);
            this.rankingAbril.agregarReceta(receta3);
        }
    @Test
    public void recetaAccionSumarPuntajeON(){

        assertEquals(30,receta1.getPuntaje());

        assertEquals(20,receta2.getPuntaje());

        //receta2 desactivada
        receta2.cambiarEstadoAgregar();

        recetario1.agregarReceta(receta2);
        recetario2.agregarReceta(receta2);
        recetario3.agregarReceta(receta2);

        assertEquals(20,receta2.getPuntaje());
    }

    @Test
    public void seAgreganRecetasOrdenadasAlRanking(){
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(0), receta3);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(1), receta2);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(2), receta1);
        this.rankingMarzo.imprimirRanking();

        this.recetario1.agregarReceta(receta4);
        this.recetario1.agregarReceta(receta4);

        this.rankingMarzo.agregarReceta(receta4);

        this.rankingMarzo.imprimirRanking();
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(0), receta3);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(1), receta2);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(2), receta4);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(3), receta1);


    }

    @Test
    public void seReordenaLalista(){
        this.rankingMarzo.imprimirRanking();
        this.recetario1.agregarReceta(receta3);
        this.recetario1.agregarReceta(receta3);
        this.recetario1.agregarReceta(receta3);

        this.rankingMarzo.imprimirRanking();
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(0), receta2);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(1), receta1);
        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(2), receta3);

    }

    @Test
    public void recetasEnRankingsDistintos(){
        rankingMarzo.imprimirRanking();
        System.out.println("----------------------");

        rankingAbril.imprimirRanking();
        System.out.println("----------------------");

        this.recetario3.agregarReceta(receta3);
        this.recetario3.agregarReceta(receta3);
        this.recetario3.agregarReceta(receta3);

        rankingMarzo.imprimirRanking();
        System.out.println("----------------------");
        rankingAbril.imprimirRanking();

        assertSame("Error al ordenar nuevas recetas", this.rankingMarzo.getRecetas().get(2), receta3);
        assertSame("Error al ordenar nuevas recetas", this.rankingAbril.getRecetas().get(2), receta3);

    }

    @Test
    public void recetasAccionAgregarDesactivada(){
        //Desactivamos la accion de sumar
        receta1.cambiarEstadoAgregar();
        receta3.cambiarEstadoAgregar();

        this.rankingMarzo.imprimirRanking();
        System.out.println("---------------------");

        //Agrego las recetas
        recetario3.agregarReceta(receta1);
        recetario3.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);

        this.rankingMarzo.imprimirRanking();
        System.out.println("---------------------");
        assertSame("Error al desactivarAccionAgregar", 30, receta1.getPuntaje());
        assertSame("Error al desactivarAccionAgregar", 30, receta2.getPuntaje());
        assertSame("Error al desactivarAccionAgregar", 10, receta3.getPuntaje());

        //Activamos las acciones
        receta1.cambiarEstadoAgregar();
        receta3.cambiarEstadoAgregar();
        receta2.cambiarEstadoAgregar();
        for (int i =0; i <10; i++){
            recetario3.agregarReceta(receta1);
            recetario3.agregarReceta(receta2);
            recetario3.agregarReceta(receta3);
        }

        this.rankingMarzo.imprimirRanking();
        System.out.println("---------------------");

        assertSame("Error al desactivarAccionAgregar", 130, receta1.getPuntaje());
        assertSame("Error al desactivarAccionAgregar", 30, receta2.getPuntaje());
        assertSame("Error al desactivarAccionAgregar", 110, receta3.getPuntaje());



    }

}