package org.dominio;

import org.dominio.acciones.*;
import org.dominio.ingredientes.*;
import org.dominio.ingredientes.cantidad.Medibles;
import org.dominio.ingredientes.cantidad.Unidades;
import org.dominio.perfiles.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NotificacionesTest {
    Ingrediente ingrediente1;
    Ingrediente ingrediente2;

    Receta receta1;
    Receta receta2;
    Receta receta3;
    Recetario recetario1;
    Recetario recetario2;
    Recetario recetario3;

    Usuario usuario1;
    Usuario usuario2;
    Usuario usuario3;

    @Spy
    Accion accionNotificar;
    @InjectMocks
    Carnivoro perfil1;
    @InjectMocks
    Vegetariano perfil2;
    Perfil perfil3;
    Perfil perfil4;

    @Before
    public void setUp() {
        this.ingrediente1 = new Ingrediente(TipoIngrediente.CARNES, "Milanesa", new Medibles(1, Unidades.KG, 200));
        this.ingrediente2 = new Ingrediente(TipoIngrediente.CARNES, "Cereal", new Medibles(3, Unidades.UNIDADES, 440));

        this.receta1 = new Receta("Receta de prueba1");
        this.receta2 = new Receta("Receta de prueba2");
        this.receta3 = new Receta("Receta de prueba3");

        this.recetario1 = new Recetario("Primer recetario");
        this.recetario2 = new Recetario("Segundo recetario");
        this.recetario3 = new Recetario("Tercero recetario");

        this.usuario1 = new Usuario();
        this.usuario2 = new Usuario();
        this.usuario3 = new Usuario();

//      preguntar por que mockito no me inyecta automaticamente la Accion accionNotificarCarnivoro
        this.perfil1 = new Carnivoro(accionNotificar);
        this.perfil2 = new Vegetariano(accionNotificar);
        this.perfil3 = new Celiaco();
        this.perfil4 = new Vegano();

        receta1.agregarIngrediente(ingrediente1);

        receta2.agregarIngrediente(ingrediente1);
        receta2.agregarIngrediente(ingrediente2);

        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);
        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);

        usuario1.agegarPerfil(perfil1);
        usuario2.agegarPerfil(perfil2);
        usuario3.agegarPerfil(perfil3);
        usuario3.agegarPerfil(perfil4);
    }

    @Test
    public void seCreanPerfilPrincipal() {
        assertSame(usuario3.getPerfilActual().getNombre(), "Celiaco");
    }

    @Test
    public void seCreanPerfilesAdicionales() {
        assertSame(usuario3.getPerfiles().get(1).getNombre(), "Vegano");
    }

    @Test
    public void seCambiaDePerfil() {
        usuario3.cambiarPerfil("Vegano");
        assertSame(usuario3.getPerfilActual().getNombre(), "Vegano");
    }

    @Test
    public void seNotificaCorrespondiente() {
        usuario1.suscribirse(recetario1);
        recetario1.agregarReceta(receta1);
        verify(accionNotificar, times(1)).accionar(null, perfil1);
    }

    @Test
    public void notificacionesDeshabilitadas() {
        perfil1 = new Carnivoro();
//      Usuario con perfil Carnivoro
        usuario1.suscribirse(recetario1);
//      Desactivo perfil carnivoro
        perfil1.getEstadoNotificar().cambiarEstado(null, perfil1);

//      Creo perfil vegetariano
        usuario1.agegarPerfil(perfil2);
        usuario1.cambiarPerfil("Vegetariano");
//      Me suscribo como vegetariano
        usuario1.suscribirse(recetario1);

        Receta receta4 = new Receta("RecetaVegetariana");
        receta4.agregarIngrediente(new Ingrediente(TipoIngrediente.LEGUMBRES, "legumbre", new Medibles(20, Unidades.GR, 20)));

//      Agrego receta Apta para Carnivoros
        recetario1.agregarReceta(receta1);
        recetario1.agregarReceta(receta2);
//      Agrego receta apta para Vegetarianos
        recetario1.agregarReceta(receta4);

        //Se notifica al perfil carnivoro porque se agregaron receta4
        verify(accionNotificar, times(0)).accionar(null, perfil1);
        verify(accionNotificar, times(1)).accionar(null, perfil2);
    }
}

