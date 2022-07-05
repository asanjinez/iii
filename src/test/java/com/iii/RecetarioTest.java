package com.iii;

import com.iii.model.Receta;
import com.iii.model.Recetario;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import com.iii.model.ingredientes.cantidad.InfoCantidadDTO;
import com.iii.model.ingredientes.cantidad.Unidades;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RecetarioTest {
    Recetario recetario1;
    Recetario recetario2;

    Receta receta1;
    Receta receta2;
    @Before
    public void before(){
        this.recetario1 = new Recetario("Receta de prueba1");
        this.recetario2 = new Recetario("Receta Vacia");

        this.receta1 = new Receta("Receta de prueba1");
        this.receta2 = new Receta("Receta de prueba2");

    }
    @Test
    public void cantidadComidasCero(){
        assertEquals(recetario2.cantidadRecetas(),0);
    }
    @Test
    public void cantidadComidasMayoACero(){
        receta1.agregarIngrediente(new Ingrediente(TipoIngrediente.CARNES,"Milanesa",new InfoCantidadDTO(3, Unidades.UNIDADES),44));
        receta2.agregarIngrediente(new Ingrediente(TipoIngrediente.VEGETALES,"Lechuga",new InfoCantidadDTO(3, Unidades.UNIDADES),44));

        for (int i=0; i < 5; i++){
            recetario1.agregarReceta(receta1);
            recetario1.agregarReceta(receta2);
        }
        assertEquals(recetario1.cantidadRecetas(),10);

    }

}