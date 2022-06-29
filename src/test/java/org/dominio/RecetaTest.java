package org.dominio;

import org.dominio.ingredientes.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.dominio.ingredientes.cantidad.*;


import static org.junit.Assert.*;
public class RecetaTest {
    Ingrediente ingrediente1;
    Ingrediente ingrediente2;
    Ingrediente ingrediente3;

    Receta receta1;
    Receta receta2;
    Receta receta3;
    @Before
    public void setUp() {
        this.ingrediente1 = new Ingrediente(TipoIngrediente.CARNES, "Milanesa", new Medibles(1, Unidades.KG, 20));
        this.ingrediente2 = new Ingrediente(TipoIngrediente.CARNES, "Cereal", new Medibles(3, Unidades.UNIDADES, 44));
        this.ingrediente3 = new Ingrediente(TipoIngrediente.LEGUMBRES, "Lentejas", new CantidadNecesaria());
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
        assertEquals(receta1.cantidadCalorias(),320);

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
        Ingrediente ingrediente4 = new Ingrediente(TipoIngrediente.CEREALES,"Cereal",new Medibles(1, Unidades.GR,20));
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente4);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Cereales"));
    }
       @Test
    public void existeGrupoAlimenticioFrutas(){
        Ingrediente ingrediente4 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",new Medibles(1, Unidades.GR,20));
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente4);
        receta1.agregarIngrediente(ingrediente2);;

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Frutas"));
    }
       @Test
    public void existeGrupoAlimenticioLacteos(){
        Ingrediente ingrediente4 = new Ingrediente(TipoIngrediente.LACTEOS,"Leche",new Medibles(1, Unidades.GR,20));
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
        Ingrediente ingrediente4 = new Ingrediente(TipoIngrediente.VEGETALES,"Lechuga",new Medibles(20, Unidades.GR,20));
        receta1.agregarIngrediente(ingrediente4);
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Vegetales"));
    }
}