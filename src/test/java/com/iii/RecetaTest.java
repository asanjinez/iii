package com.iii;

import com.iii.model.ingredientes.*;
import com.iii.model.Receta;
import com.iii.model.ingredientes.cantidad.CantidadNecesaria;
import com.iii.model.ingredientes.cantidad.InfoCantidad;
import com.iii.model.ingredientes.cantidad.InfoCantidadDTO;
import com.iii.model.ingredientes.cantidad.Unidades;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class RecetaTest {
    Ingrediente ingrediente1;
    Ingrediente ingrediente2;
    Ingrediente ingrediente3;

    Receta receta1;
    Receta receta2;
    Receta receta3;
    @Before
    public void setUp() {
        this.ingrediente1 = new Ingrediente(TipoIngrediente.CARNES, "Milanesa",  new InfoCantidadDTO(1, Unidades.KG),106);
        this.ingrediente2 = new Ingrediente(TipoIngrediente.CARNES, "Cereal", new InfoCantidadDTO(3, Unidades.UNIDADES),20);
        this.ingrediente3 = new Ingrediente(TipoIngrediente.LEGUMBRES, "Lentejas",new InfoCantidadDTO(0,Unidades.CN),0);
        this.receta1 = new Receta("Receta de prueba1");
        this.receta2 = new Receta("Receta Vacia");
    }

    @Test
    public void cantidadDeIngredientesCero() {
        assertEquals(this.receta2.cantidadIngredientes(),0);
    }

    @Test
    public void cantidadDeIngredientesMayorACero() {
        for (int i=0;i<5;i++){
            receta1.agregarIngrediente(ingrediente1);
            receta1.agregarIngrediente(ingrediente2);
        }

        assertEquals(receta1.cantidadIngredientes(),10);
    }
    @Test
    public void cantidadCaloriasCero(){
        Receta receta4 = new Receta("Receta de prueba1");
        assertEquals(receta1.cantidadCalorias(),0);
    }
    @Test
    public void cantidadCaloriasMayorACero(){
        for (int i=0;i<5;i++){
            receta1.agregarIngrediente(ingrediente1);
            receta1.agregarIngrediente(ingrediente2);
            receta1.agregarIngrediente(ingrediente3);
        }
        assertEquals(receta1.cantidadCalorias(),630);

    }

    @Test
    public void existeAlimento(){
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente3);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneAlimento("Lentejas"));
    }


    @Test
    public void existeGrupoAlimenticioCarnes(){
        receta1.agregarIngrediente(ingrediente2);
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente3);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Carnes"));
    }
       @Test
    public void existeGrupoAlimenticioCereales(){
        Ingrediente ingrediente4 = new Ingrediente(TipoIngrediente.CEREALES,"Cereal",new InfoCantidadDTO(1, Unidades.GR),20);
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente4);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Cereales"));
    }
       @Test
    public void existeGrupoAlimenticioFrutas(){
        Ingrediente ingrediente4 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",new InfoCantidadDTO(1, Unidades.GR),20);
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente4);
        receta1.agregarIngrediente(ingrediente2);;

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Frutas"));
    }
       @Test
    public void existeGrupoAlimenticioLacteos(){
        Ingrediente ingrediente4 = new Ingrediente(TipoIngrediente.LACTEOS,"Leche",new InfoCantidadDTO(1, Unidades.GR),20);
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente4);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Lacteos"));
    }
       @Test
    public void existeGrupoAlimenticioLegumbres(){
            receta1.agregarIngrediente(ingrediente1);
            receta1.agregarIngrediente(ingrediente2);
            receta1.agregarIngrediente(ingrediente3);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Legumbres"));
    }
       @Test
    public void existeGrupoAlimenticioVegetales(){
        Ingrediente ingrediente4 = new Ingrediente(TipoIngrediente.VEGETALES,"Lechuga",new InfoCantidadDTO(20, Unidades.GR),20);
        receta1.agregarIngrediente(ingrediente4);
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Vegetales"));
    }
}