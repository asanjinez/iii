package com.iii;

import com.iii.model.*;
import com.iii.model.ingredientes.*;
import com.iii.model.Receta;
import com.iii.model.Recetario;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class RecetarioTest {
    @Test
    public void cantidadComidas(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.CEREALES,"Cereal",1,20,"Gramos");
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.CARNES,"Milanesa",3,44,"Unidades");

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