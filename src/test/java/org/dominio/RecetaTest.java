package org.dominio;

import org.dominio.ingredientes.*;
import org.junit.Test;

import java.security.cert.CertificateRevokedException;

import static org.junit.Assert.*;

public class RecetaTest {
    @Test
    public void cantidadDeIngredientesCero() {
        Receta receta1 = new Receta("Receta de prueba1");
        assertEquals(receta1.cantidadIngredientes(),0);
    }

    @Test
    public void cantidadDeIngredientesMayorACero() {
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.CARNES,"Milanesa",1,20,"Gramos");
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.CARNES,"Cereal",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        for (int i=0;i<5;i++){
            receta1.agregarIngrediente(ingrediente1);
            receta1.agregarIngrediente(ingrediente2);

        }

        assertEquals(receta1.cantidadIngredientes(),10);
    }

    @Test
    public void cantidadCaloriasCero(){
        Receta receta1 = new Receta("Receta de prueba1");
        assertEquals(receta1.cantidadCalorias(),0);
    }
    @Test
    public void cantidadCaloriasMayorACero(){
        //estamos suponiendo que la persona que crea el ingrediente ya sabe cuantas calorias le corresponden a determinada cantidad de ingredientes
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",2,20,"Gramos");
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.LEGUMBRES,"Lentejas",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        for (int i=0;i<5;i++){
            receta1.agregarIngrediente(ingrediente1);
            receta1.agregarIngrediente(ingrediente2);
        }
        assertEquals(receta1.cantidadCalorias(),25);


    }

    @Test
    public void existeAlimento(){
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.LEGUMBRES,"Lentejas",3,44,"Unidades");
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",1,20,"Gramos");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneAlimento("Banana"));
    }


    @Test
    public void existeGrupoAlimenticioCarnes(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",1,20,"Gramos");
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.CARNES,"Milanesa",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Carnes"));
    }
       @Test
    public void existeGrupoAlimenticioCereales(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",1,20,"Gramos");
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.CEREALES,"Cereal",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Cereales"));
    }
       @Test
    public void existeGrupoAlimenticioFrutas(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.CARNES,"Lentejas",3,44,"Unidades");
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",1,20,"Gramos");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Frutas"));
    }
       @Test
    public void existeGrupoAlimenticioLacteos(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",1,20,"Gramos");
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.LACTEOS,"Queso",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Lacteos"));
    }
       @Test
    public void existeGrupoAlimenticioLegumbres(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",1,20,"Gramos");
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.LEGUMBRES,"Legumbre",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Legumbres"));
    }
       @Test
    public void existeGrupoAlimenticioVegetales(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",1,20,"Gramos");
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.VEGETALES,"Lechuga",3,44,"Unidades");

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Vegetales"));
    }
}