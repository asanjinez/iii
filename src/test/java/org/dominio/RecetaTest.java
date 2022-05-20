package org.dominio;

import org.dominio.ingredientes.*;
import org.dominio.ingredientes.cantidad.CantidadNecesaria;
import org.dominio.ingredientes.cantidad.Medibles;
import org.dominio.ingredientes.cantidad.Unidades;
import org.junit.Before;
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
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.CARNES,"Milanesa",new Medibles(1, Unidades.KG,20));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.CARNES,"Cereal",new Medibles(3, Unidades.UNIDADES,44));

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
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",new Medibles(1, Unidades.GR,3));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.LEGUMBRES,"Lentejas",new Medibles(3, Unidades.KG,2));
        Ingrediente ingrediente3 = new Ingrediente(TipoIngrediente.LEGUMBRES,"Lentejas",new CantidadNecesaria());

        Receta receta1 = new Receta("Receta de prueba1");
        for (int i=0;i<5;i++){
            receta1.agregarIngrediente(ingrediente1);
            receta1.agregarIngrediente(ingrediente2);
            receta1.agregarIngrediente(ingrediente3);
        }
        assertEquals(receta1.cantidadCalorias(),25);


    }

    @Test
    public void existeAlimento(){
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.LEGUMBRES,"Lentejas",new Medibles(3, Unidades.KG,44));
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",new Medibles(1, Unidades.GR,20));

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneAlimento("Banana"));
    }


    @Test
    public void existeGrupoAlimenticioCarnes(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",new Medibles(1, Unidades.GR,20));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.CARNES,"Milanesa",new Medibles(3, Unidades.KG,44));

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Carnes"));
    }
       @Test
    public void existeGrupoAlimenticioCereales(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",new Medibles(1, Unidades.GR,20));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.CEREALES,"Cereal",new Medibles(3, Unidades.KG,44));

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Cereales"));
    }
       @Test
    public void existeGrupoAlimenticioFrutas(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.CARNES,"Lentejas",new Medibles(3, Unidades.KG,44));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",new Medibles(1, Unidades.GR,20));

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Frutas"));
    }
       @Test
    public void existeGrupoAlimenticioLacteos(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",new Medibles(1, Unidades.GR,20));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.LACTEOS,"Queso",new Medibles(3, Unidades.KG,44));

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Lacteos"));
    }
       @Test
    public void existeGrupoAlimenticioLegumbres(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",new Medibles(1, Unidades.GR,20));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.LEGUMBRES,"Legumbre",new Medibles(3, Unidades.KG,44));

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Legumbres"));
    }
       @Test
    public void existeGrupoAlimenticioVegetales(){
        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.FRUTAS,"Banana",new Medibles(1, Unidades.GR,20));
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.VEGETALES,"Lechuga",new Medibles(3, Unidades.KG,44));

        Receta receta1 = new Receta("Receta de prueba1");
        receta1.agregarIngrediente(ingrediente1);
        receta1.agregarIngrediente(ingrediente2);

        assertTrue("El ingrediente esta en la receta",receta1.contieneGrupoAlimenticio("Vegetales"));
    }
}