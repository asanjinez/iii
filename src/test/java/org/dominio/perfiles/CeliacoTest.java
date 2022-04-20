package org.dominio.perfiles;

import org.dominio.Receta;
import org.dominio.ingredientes.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CeliacoTest {
    @Test
    public void comidaApta(){
        Ingrediente ingrediente1 = new Carnes("Milanesa",197,20,"Gramos");
        Ingrediente ingrediente2 = new Frutas("Manzana",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        Celiaco perfil = new Celiaco();
        assertTrue("No es apto para el perfil",perfil.puedeComer(receta1));


    }

    @Test
    public void comidaNoApta(){
        Ingrediente ingrediente1 = new Carnes("Milanesa",197,20,"Gramos");
        Ingrediente ingrediente2 = new Cereales("Cereal",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        Celiaco perfil = new Celiaco();
        assertTrue("Es apto para el perfil",!perfil.puedeComer(receta1));
    }


}