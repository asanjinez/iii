package com.iii.perfiles;

import com.iii.model.*;
import com.iii.model.ingredientes.*;
import com.iii.model.perfiles.*;
import com.iii.model.Receta;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import com.iii.model.perfiles.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PerfilesTest {
        private Ingrediente ingrediente1;
        private Ingrediente ingrediente2;
        private Ingrediente ingrediente3;
        private Ingrediente ingrediente4;
        private Ingrediente ingrediente5;
        private Receta recetaCarnivora;
        private Receta recetaVegetariana;
        private Receta recetaCeliaca;
        private Receta recetaVegana;

        Perfil perfilCarnivoro;
        Perfil perfilVegetariano;
        Perfil perfilCeliaco;
        Perfil perfilVegano;

        @Before
        public void setUp() {

        ingrediente1 = new Ingrediente(TipoIngrediente.CARNES, "Milanesa", 197, 20, "Gramos");
        ingrediente2 = new Ingrediente(TipoIngrediente.CEREALES, "Cereal", 3, 44, "Unidades");
        ingrediente3 = new Ingrediente(TipoIngrediente.LEGUMBRES, "Lenteja", 3, 44, "Unidades");
        ingrediente4 = new Ingrediente(TipoIngrediente.VEGETALES,"Lechuga",20,30,"Unidades");
        ingrediente5 = new Ingrediente(TipoIngrediente.LACTEOS,"Leche",20,40,"Litros");

        recetaCarnivora = new Receta("recetaCarnivora");
        recetaCarnivora.agregarIngrediente(ingrediente1);
        recetaCarnivora.agregarIngrediente(ingrediente4);

        recetaVegetariana = new Receta("recetaVegetariana");
        recetaVegetariana.agregarIngrediente(ingrediente2);
        recetaVegetariana.agregarIngrediente(ingrediente3);
        recetaVegetariana.agregarIngrediente(ingrediente4);

        recetaCeliaca = new Receta("recetaCeliaca");
        recetaCeliaca.agregarIngrediente(ingrediente1);
        recetaCeliaca.agregarIngrediente(ingrediente3);
        recetaCeliaca.agregarIngrediente(ingrediente5);


        recetaVegana = new Receta("recetaVegana");
        recetaVegana.agregarIngrediente(ingrediente2);
        recetaVegana.agregarIngrediente(ingrediente3);

        this.perfilCarnivoro = new Carnivoro();
        this.perfilVegetariano = new Vegetariano();
        this.perfilCeliaco = new Celiaco();
        this.perfilVegano = new Vegano();
    }
        @Test
        public void comidaApta(){

        assertTrue("No es apto para el perfil",perfilCarnivoro.puedeComer(recetaCarnivora));
        assertTrue("No es apto para el perfil",perfilVegetariano.puedeComer(recetaVegetariana));
        assertTrue("No es apto para el perfil",perfilCeliaco.puedeComer(recetaCeliaca));
        assertTrue("No es apto para el perfil",perfilVegano.puedeComer(recetaVegana));


    }

        @Test
        public void comidaNoApta(){
        assertFalse("Es apto para el perfil",perfilCarnivoro.puedeComer(recetaVegetariana));
        assertFalse("Es apto para el perfil",perfilVegetariano.puedeComer(recetaCarnivora));
        assertFalse("Es apto para el perfil",perfilCeliaco.puedeComer(recetaVegana));
        assertFalse("Es apto para el perfil",perfilVegano.puedeComer(recetaCeliaca));
    }
}
