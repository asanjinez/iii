package com.iii;


import com.iii.model.*;
import com.iii.model.ingredientes.*;
import com.iii.model.Receta;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class RecetaTest {
    Ingrediente ingrediente1;
    Ingrediente ingrediente2;

    Receta receta1;
    Receta receta2;
    Receta receta3;
    @Before
    public void before(){
        this.ingrediente1 = new Ingrediente(TipoIngrediente.CARNES,"Milanesa",1,20,"Gramos");
        this.ingrediente2 = new Ingrediente(TipoIngrediente.CEREALES,"Cereal",3,44,"Unidades");

        this.receta1 = new Receta("Receta de prueba1");
        this.receta2 = new Receta("Receta de prueba2");
        this.receta3 = new Receta("Receta de prueba3");

        receta1.agregarIngrediente(ingrediente1);

        receta2.agregarIngrediente(ingrediente1);
        receta2.agregarIngrediente(ingrediente2);

        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);
        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);

    }
    @Test
    public void cantidadDeIngredientes() {

        assertEquals(receta1.cantidadIngredientes(),1);
        assertEquals(receta2.cantidadIngredientes(),2);
        assertEquals(receta3.cantidadIngredientes(),4);
    }

    @Test
    public void cantidadCalorias(){
        //estamos suponiendo que la persona que crea el ingrediente ya sabe cuantas calorias le corresponden a determinada cantidad de ingredientes
        assertEquals(receta1.cantidadCalorias(),1);
        assertEquals(receta2.cantidadCalorias(),4);
        assertEquals(receta3.cantidadCalorias(),8);

    }

    @Test
    public void existeAlimento(){

        assertTrue("El ingrediente no esta en la receta",receta1.contieneAlimento("Milanesa"));
        assertTrue("El ingrediente no esta en la receta",receta2.contieneAlimento("Cereal"));
        assertTrue("El ingrediente esta en la receta",!receta3.contieneAlimento("Papa"));


    }

    @Test
    public void existeGrupoAlimenticio(){
        assertTrue("El ingrediente no esta en la receta",receta1.contieneGrupoAlimenticio("Carnes"));
        assertTrue("El ingrediente no esta en la receta",receta2.contieneGrupoAlimenticio("Cereales"));
        assertTrue("El ingrediente esta en la receta",!receta3.contieneGrupoAlimenticio("Legumbres"));
    }
}