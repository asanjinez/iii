package org.dominio.perfiles;

import org.dominio.Receta;
import org.dominio.ingredientes.Ingrediente;
import org.dominio.ingredientes.TipoIngrediente;
import org.dominio.ingredientes.cantidad.Medibles;
import org.dominio.ingredientes.cantidad.Unidades;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.verification.checkers.AtLeastXNumberOfInvocationsChecker;

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

        ingrediente1 = new Ingrediente(TipoIngrediente.CARNES, "Milanesa", new Medibles(20, Unidades.GR,197));
        ingrediente2 = new Ingrediente(TipoIngrediente.CEREALES, "Cereal", new Medibles(3,Unidades.UNIDADES,44));
        ingrediente3 = new Ingrediente(TipoIngrediente.LEGUMBRES, "Lenteja", new Medibles(3,Unidades.UNIDADES,44));
        ingrediente4 = new Ingrediente(TipoIngrediente.VEGETALES,"Lechuga", new Medibles(20,Unidades.UNIDADES,30));
        ingrediente5 = new Ingrediente(TipoIngrediente.LACTEOS,"Leche", new Medibles(2,Unidades.LITROS,40));

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
    public void comidaAptaCarnivoros(){
    assertTrue("No es apto para el perfil",perfilCarnivoro.puedeComer(recetaCarnivora));
    }
    @Test
    public void comidaAptaVegetarianos(){
        assertTrue("No es apto para el perfil",perfilVegetariano.puedeComer(recetaVegetariana));
    }
    @Test
    public void comidaAptaCeliacos(){
        assertTrue("No es apto para el perfil",perfilCeliaco.puedeComer(recetaCeliaca));
    }
    @Test
    public void comidaAptaVeganos(){
        assertTrue("No es apto para el perfil",perfilVegano.puedeComer(recetaVegana));
    }
    @Test
    public void comidaNoAptaCarnivoros(){
        assertFalse("Es apto para el perfil",perfilCarnivoro.puedeComer(recetaVegetariana));
    }
    @Test
    public void comidaNoAptaVegetarianos(){
        assertFalse("Es apto para el perfil",perfilVegetariano.puedeComer(recetaCarnivora));
    }
    @Test
    public void comidaNoAptaVeganos(){
        assertFalse("Es apto para el perfil",perfilCeliaco.puedeComer(recetaVegana));
    }
    @Test
    public void comidaNoAptaCeliacos(){
        assertFalse("Es apto para el perfil",perfilVegano.puedeComer(recetaCeliaca));
    }
}
