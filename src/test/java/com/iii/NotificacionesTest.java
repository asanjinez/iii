package com.iii;

import com.iii.model.Receta;
import com.iii.model.Recetario;
import com.iii.model.Usuario;
import com.iii.model.acciones.*;
import com.iii.model.ingredientes.cantidad.InfoCantidadDTO;
import com.iii.model.ingredientes.cantidad.Unidades;
import com.iii.model.perfiles.*;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import com.iii.model.perfiles.dietas.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;


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

    @Mock
    AccionNotificarPerfil accionNotificarSpy;
    @InjectMocks
    Perfil perfil1;
    @InjectMocks
    Perfil perfil2;
    Perfil perfil3;
    Perfil perfil4;

    @Before
    public void setUp() {
        this.ingrediente1 = new Ingrediente(TipoIngrediente.CARNES, "Milanesa", new InfoCantidadDTO(1, Unidades.KG),200);
        this.ingrediente2 = new Ingrediente(TipoIngrediente.CARNES, "Cereal", new InfoCantidadDTO(3, Unidades.UNIDADES),440);

        this.receta1 = new Receta("Receta de prueba1");
        this.receta2 = new Receta("Receta de prueba2");
        this.receta3 = new Receta("Receta de prueba3");

        this.recetario1 = new Recetario("Primer recetario");
        this.recetario2 = new Recetario("Segundo recetario");
        this.recetario3 = new Recetario("Tercero recetario");

        this.usuario1 = new Usuario();
        this.usuario2 = new Usuario();
        this.usuario3 = new Usuario();

//      preguntar por que mockito no me inyecta automaticamente la Accion accionNotificarSpyCarnivoro
        this.perfil1 = new Perfil(new Carnivoro(),accionNotificarSpy);
        this.perfil2 = new Perfil(new Vegetariano());
        this.perfil3 = new Perfil(new Celiaco());
        this.perfil4 = new Perfil(new Vegano());

        receta1.agregarIngrediente(ingrediente1);

        receta2.agregarIngrediente(ingrediente1);
        receta2.agregarIngrediente(ingrediente2);

        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);
        receta3.agregarIngrediente(ingrediente1);
        receta3.agregarIngrediente(ingrediente2);

        usuario1.agregarPerfil(perfil1);
        usuario2.agregarPerfil(perfil2);
        usuario3.agregarPerfil(perfil3);
        usuario3.agregarPerfil(perfil4);
    }

    @Test
    public void seCreanPerfilPrincipal() {
        assertSame(usuario3.getPerfilActual().getDieta().getNombre(), "Celiaco");
    }

    @Test
    public void seCreanPerfilesAdicionales() {
        assertSame(usuario3.getPerfiles().get(1).getDieta().getNombre(), "Vegano");
    }

    @Test
    public void seCambiaDePerfil() {
        usuario3.cambiarPerfil("Vegano");
        assertSame(usuario3.getPerfilActual().getDieta().getNombre(), "Vegano");
    }

    @Test
    public void seNotificaCorrespondiente() {
        usuario1.suscribirse(recetario1);
        recetario1.agregarReceta(receta1);
        verify(accionNotificarSpy, times(1)).accionar(receta1);
    }

    @Test
    public void notificacionesDeshabilitadas() {
        usuario1.agregarPerfil(perfil1);
//      Usuario con perfil Carnivoro
        usuario1.suscribirse(recetario1);
//      Desactivo perfil carnivoro
        perfil1.getAccionNotificar().cambiarEstado();

        recetario1.agregarReceta(receta1);

        //Se notifica al perfil carnivoro porque se agregaron receta4
        verify(accionNotificarSpy, times(1)).accionar(receta1);

    }
}

