package org.dominio;

import org.dominio.ingredientes.Ingrediente;
import org.dominio.ingredientes.TipoIngrediente;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecetarioTest {
    @Test
    public void cantidadComidasCero(){
        Recetario recetario1 = new Recetario("Primer recetario");
        assertEquals(recetario1.cantidadRecetas(),0);
    }

    @Test
    public void cantidadComidasMayoACero(){
        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(new Ingrediente(TipoIngrediente.CARNES,"Milanesa",3,44,"Unidades"));

        Receta receta2 = new Receta("Receta de prueba2");
        receta1.agregarIngrediente(new Ingrediente(TipoIngrediente.VEGETALES,"Lechuga",3,44,"Unidades"));


        Recetario recetario1 = new Recetario("Primer recetario");
        for (int i=0; i < 5; i++){
            recetario1.agregarReceta(receta1);
            recetario1.agregarReceta(receta2);
        }
        assertEquals(recetario1.cantidadRecetas(),10);

    }

}