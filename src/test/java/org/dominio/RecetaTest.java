package org.dominio;

import org.dominio.ingredientes.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecetaTest {
    @Test
    public void cantidadDeIngredientes() {
        Ingrediente ingrediente1 = new Carnes("Milanesa",1,20,"Gramos");
        Ingrediente ingrediente2 = new Cereales("Cereal",3,44,"Unidades");

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

        assertEquals(receta1.cantidadIngredientes(),1);
        assertEquals(receta2.cantidadIngredientes(),2);
        assertEquals(receta3.cantidadIngredientes(),4);
    }

    @Test
    public void cantidadCalorias(){
        //estamos suponiendo que la persona que crea el ingrediente ya sabe cuantas calorias le corresponden a determinada cantidad de ingredientes
        Ingrediente ingrediente1 = new Frutas("Banana",1,20,"Gramos");
        Ingrediente ingrediente2 = new Legumbres("Lentejas",3,44,"Unidades");

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

        assertEquals(receta1.cantidadCalorias(),1);
        assertEquals(receta2.cantidadCalorias(),4);
        assertEquals(receta3.cantidadCalorias(),8);

    }

    @Test
    public void existeAlimento(){
        Ingrediente ingrediente1 = new Frutas("Banana",1,20,"Gramos");
        Ingrediente ingrediente2 = new Legumbres("Lentejas",3,44,"Unidades");

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

        assertTrue("El ingrediente esta en la receta",receta1.contieneAlimento("Banana"));
        assertTrue("El ingrediente esta en la receta",receta2.contieneAlimento("Lentejas"));
        assertTrue("El ingrediente no esta en la receta",!receta3.contieneAlimento("Milanesa"));


    }

    @Test
    public void existeGrupoAlimenticio(){
        Ingrediente ingrediente1 = new Frutas("Banana",1,20,"Gramos");
        Ingrediente ingrediente2 = new Legumbres("Lentejas",3,44,"Unidades");

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

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Frutas"));
        assertTrue("El ingrediente esta en la receta",receta2.contieneGrupoAlimenticio("Legumbres"));
        assertTrue("El ingrediente no esta en la receta",!receta3.contieneGrupoAlimenticio("Carnes"));
    }
}