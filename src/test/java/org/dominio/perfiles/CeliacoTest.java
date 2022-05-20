package org.dominio.perfiles;

import org.dominio.Receta;
import org.dominio.ingredientes.*;
import org.dominio.ingredientes.cantidad.Medibles;
import org.junit.Test;

import static org.dominio.ingredientes.cantidad.Unidades.GR;
import static org.dominio.ingredientes.cantidad.Unidades.UNIDADES;
import static org.junit.Assert.*;

public class CeliacoTest {
    @Test
    public void comidaApta(){
        Ingrediente ingrediente1 =  new Ingrediente(TipoIngrediente.CARNES,"Milanesa",new Medibles(20,GR,197));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.FRUTAS,"Manzana",new Medibles(3,UNIDADES,44));

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        Celiaco perfil = new Celiaco();
        assertTrue("No es apto para el perfil",perfil.puedeComer(receta1));


    }

    @Test
    public void comidaNoApta(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.LEGUMBRES,"Lenteja",new Medibles(1,GR,20));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.CEREALES,"Cereal",new Medibles(3,UNIDADES,44));

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        Celiaco perfil = new Celiaco();
        assertTrue("Es apto para el perfil",!perfil.puedeComer(receta1));
    }


}