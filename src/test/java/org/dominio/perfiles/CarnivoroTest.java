package org.dominio.perfiles;

import org.dominio.Receta;
import org.dominio.ingredientes.Carnes;
import org.dominio.ingredientes.Cereales;
import org.dominio.ingredientes.Ingrediente;
import org.dominio.ingredientes.Legumbres;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarnivoroTest {
    @Test
    public void comidaApta(){
        Ingrediente ingrediente1 = new Carnes("Milanesa",197,20,"Gramos");
        Ingrediente ingrediente2 = new Cereales("Cereal",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        Carnivoro perfil = new Carnivoro();
        assertTrue("No es apto para el perfil",perfil.puedeComer(receta1));


    }

    @Test
    public void comidaNoApta(){
        Ingrediente ingrediente1 = new Legumbres("Lenteja",1,20,"Gramos");
        Ingrediente ingrediente2 = new Cereales("Cereal",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        Carnivoro perfil = new Carnivoro();
        perfil.puedeComer(receta1);

        assertTrue("Es apto para el perfil",!perfil.puedeComer(receta1));
    }


}