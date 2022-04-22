package org.dominio;

import org.dominio.ingredientes.Carnes;
import org.dominio.ingredientes.Cereales;
import org.dominio.ingredientes.Ingrediente;
import org.junit.Test;

import static org.junit.Assert.*;

public class RankingTest {
    @Test
    public void recetaAccionSumarPuntajeON(){
        Ingrediente ingrediente1 = new Cereales("Cereal",1,20,"Gramos");
        Ingrediente ingrediente2 = new Carnes("Milanesa",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);

        Receta receta2 = new Receta("Receta de prueba2");
        receta2.agregarIngrediente(ingrediente1);
        receta2.agregarIngrediente(ingrediente2);

        Receta receta3 = new Receta("Receta de prueba3");
        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);
        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);

        receta2.cambiarEstadoAgregar();

        Recetario recetario1 = new Recetario("Primer recetario");
        recetario1.agregarReceta(receta1);

        Recetario recetario2 = new Recetario("Segundo recetario");
        recetario2.agregarReceta(receta1);
        recetario2.agregarReceta(receta2);

        Recetario recetario3 = new Recetario("Tercero recetario");
        recetario3.agregarReceta(receta1);
        recetario3.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);



        assertEquals(30,receta1.getPuntaje());
        //Desactivado
        assertEquals(0,receta2.getPuntaje());

        //activado
        receta2.cambiarEstadoAgregar();
        recetario3.agregarReceta(receta2);
        assertEquals(10,receta2.getPuntaje());

        assertEquals(10,receta3.getPuntaje());
    }

    @Test
    public void seAgreganRecetasOrdenadasAlRanking(){
        Ingrediente ingrediente1 = new Cereales("Cereal",1,20,"Gramos");
        Ingrediente ingrediente2 = new Carnes("Milanesa",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);

        Receta receta2 = new Receta("Receta de prueba2");
        receta2.agregarIngrediente(ingrediente1);
        receta2.agregarIngrediente(ingrediente2);

        Receta receta3 = new Receta("Receta de prueba3");
        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);
        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);

        receta2.cambiarEstadoAgregar();

        Recetario recetario1 = new Recetario("Primer recetario");
        recetario1.agregarReceta(receta1);

        Recetario recetario2 = new Recetario("Segundo recetario");
        recetario2.agregarReceta(receta1);
        recetario2.agregarReceta(receta2);

        Recetario recetario3 = new Recetario("Tercero recetario");
        recetario3.agregarReceta(receta1);
        recetario3.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);

        Ranking rankingMarzo = new Ranking("Ranking de marzo");
        rankingMarzo.imprimirRanking();
        rankingMarzo.agregarReceta(receta1);
        rankingMarzo.agregarReceta(receta2);
        rankingMarzo.agregarReceta(receta3);

        rankingMarzo.imprimirRanking();

        assertEquals(3,rankingMarzo.getRecetas().size());
    }

    @Test
    public void seReordenaLalista(){
        Ingrediente ingrediente1 = new Cereales("Cereal",1,20,"Gramos");
        Ingrediente ingrediente2 = new Carnes("Milanesa",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);

        Receta receta2 = new Receta("Receta de prueba2");
        receta2.agregarIngrediente(ingrediente1);
        receta2.agregarIngrediente(ingrediente2);

        Receta receta3 = new Receta("Receta de prueba3");
        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);
        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);


        Recetario recetario1 = new Recetario("Primer recetario");
        recetario1.agregarReceta(receta1);

        Recetario recetario2 = new Recetario("Segundo recetario");
        recetario2.agregarReceta(receta1);
        recetario2.agregarReceta(receta2);

        Ranking rankingMarzo = new Ranking("Ranking de marzo");

        rankingMarzo.agregarReceta(receta1);
        rankingMarzo.agregarReceta(receta2);
        rankingMarzo.agregarReceta(receta3);
        rankingMarzo.imprimirRanking();

        Recetario recetario3 = new Recetario("Tercero recetario");

        recetario3.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);
        recetario3.agregarReceta(receta3);
        recetario3.agregarReceta(receta3);
        recetario3.agregarReceta(receta2);
        recetario3.agregarReceta(receta2);

        rankingMarzo.imprimirRanking();

    }

    @Test
    public void recetasEnRankingsDistintos(){
        Ingrediente ingrediente1 = new Cereales("Cereal",1,20,"Gramos");
        Ingrediente ingrediente2 = new Carnes("Milanesa",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);

        Receta receta2 = new Receta("Receta de prueba2");
        receta2.agregarIngrediente(ingrediente1);
        receta2.agregarIngrediente(ingrediente2);

        Receta receta3 = new Receta("Receta de prueba3");
        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente1);

        Recetario recetario1 = new Recetario("Primer recetario");
        recetario1.agregarReceta(receta1);

        Recetario recetario2 = new Recetario("Segundo recetario");
        recetario2.agregarReceta(receta1);
        recetario2.agregarReceta(receta2);

        Ranking rankingMarzo = new Ranking("Ranking de Marzo");
        Ranking rankingAbril = new Ranking("Ranking de Abril");

        rankingMarzo.agregarReceta(receta1);
        rankingAbril.agregarReceta(receta2);
        rankingMarzo.agregarReceta(receta3);
        rankingAbril.agregarReceta(receta3);

        rankingMarzo.imprimirRanking();
        rankingAbril.imprimirRanking();

        Recetario recetario3 = new Recetario("Tercer recetario");
        recetario3.agregarReceta(receta3);
        recetario3.agregarReceta(receta3);
        recetario3.agregarReceta(receta3);

        System.out.println("-----------------");
        rankingMarzo.imprimirRanking();
        rankingAbril.imprimirRanking();

    }

    @Test
    public void recetasAccionAgregarDesactivada(){
        Ingrediente ingrediente1 = new Cereales("Cereal",1,20,"Gramos");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);

        Receta receta2 = new Receta("Receta de prueba2");
        receta2.agregarIngrediente(ingrediente1);

        Receta receta3 = new Receta("Receta de prueba3");
        receta3.agregarIngrediente(ingrediente1);


        receta2.cambiarEstadoAgregar();
        receta3.cambiarEstadoAgregar();

        Recetario recetario1 = new Recetario("Primer recetario");
        Recetario recetario2 = new Recetario("Segundo recetario");
        Recetario recetario3 = new Recetario("Tercero recetario");
        recetario1.agregarReceta(receta1);
        recetario2.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);

        Ranking rankingPrueba = new Ranking("prueba");
        rankingPrueba.agregarReceta(receta1);
        rankingPrueba.agregarReceta(receta2);
        rankingPrueba.agregarReceta(receta3);

        rankingPrueba.imprimirRanking();

        receta2.cambiarEstadoAgregar();
        receta3.cambiarEstadoAgregar();

        recetario3.agregarReceta(receta1);
        recetario3.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);
        recetario3.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);
        recetario3.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);

        rankingPrueba.imprimirRanking();
    }


}