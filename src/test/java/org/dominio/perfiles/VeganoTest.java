package org.dominio.perfiles;

import org.dominio.Receta;
import org.dominio.ingredientes.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class VeganoTest {
    @Test
    public void comidaApta(){
        Ingrediente ingrediente1 = new Legumbres("Lentejas",197,20,"Gramos");
        Ingrediente ingrediente2 = new Frutas("Manzana",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        Vegano perfil = new Vegano();
        assertTrue("No es apto para el perfil",perfil.puedeComer(receta1));


    }

    @Test
    public void comidaNoApta(){
        Ingrediente ingrediente1 = new Carnes("Milanesa",197,20,"Gramos");
        Ingrediente ingrediente2 = new Cereales("Cereal",3,44,"Unidades");
        Ingrediente ingrediente3 = new Lacteos("Leche",3,44,"Ml");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        Receta receta2 = new Receta("Receta de prueba2");
        receta2.agregarIngrediente(ingrediente1);
        receta2.agregarIngrediente(ingrediente3);

        Vegano perfil = new Vegano();
        assertTrue("Es apto para el perfil",!perfil.puedeComer(receta1));
        assertTrue("Es apto para el perfil",!perfil.puedeComer(receta2));
    }
}