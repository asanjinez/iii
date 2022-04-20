package org.dominio;

import org.dominio.ingredientes.Carnes;
import org.dominio.ingredientes.Cereales;
import org.dominio.ingredientes.Ingrediente;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecetarioTest {
    @Test
    public void cantidadComidas(){
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

        Recetario recetario3 = new Recetario("Tercero recetario");
        recetario3.agregarReceta(receta1);
        recetario3.agregarReceta(receta2);
        recetario3.agregarReceta(receta3);

        assertEquals(recetario1.cantidadRecetas(),1);
        assertEquals(recetario2.cantidadRecetas(),2);
        assertEquals(recetario3.cantidadRecetas(),3);


    }

}