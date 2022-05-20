package org.dominio.perfiles;

import org.dominio.Receta;
import org.dominio.ingredientes.*;
import org.dominio.ingredientes.cantidad.Medibles;
import org.junit.Test;

import static org.dominio.ingredientes.cantidad.Unidades.*;
import static org.junit.Assert.*;

public class VeganoTest {
    @Test
    public void comidaApta(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.LEGUMBRES,"Lenteja",new Medibles(20,GR,197));
        Ingrediente ingrediente2 =  new Ingrediente(TipoIngrediente.CEREALES,"Cereal",new Medibles(3,UNIDADES,44));

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        Vegano perfil = new Vegano();
        assertTrue("No es apto para el perfil",perfil.puedeComer(receta1));


    }

    @Test
    public void comidaNoApta(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.CARNES,"Milanesa",new Medibles(20,GR,197));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.CEREALES,"Cereal",new Medibles(3,UNIDADES,44));
        Ingrediente ingrediente3 = new Ingrediente(TipoIngrediente.LACTEOS,"Leche",new Medibles(3,ML,44));

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