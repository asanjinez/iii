package com.iii;

import com.iii.model.Receta;
import com.iii.model.Recetario;
import com.iii.model.Usuario;
import com.iii.model.acciones.*;
import com.iii.model.ingredientes.*;
import com.iii.model.perfiles.*;
import com.iii.model.acciones.Accion;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import com.iii.model.perfiles.*;
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
    Accion accionNotificar;

    @InjectMocks
    Carnivoro perfil1;

    @InjectMocks
    Vegetariano perfil2;
    Perfil perfil3;
    Perfil perfil4;

    @Before
    public void setUp() throws Exception {

        this.ingrediente1 = new Ingrediente(TipoIngrediente.CARNES,"Milanesa", 200, 20, "Gramos");
        this.ingrediente2 = new Ingrediente(TipoIngrediente.CEREALES,"Cereal", 3, 44, "Unidades");

        this.receta1 = new Receta("Receta de prueba1");
        this.receta2 = new Receta("Receta de prueba2");
        this.receta3 = new Receta("Receta de prueba3");


        this.recetario1 = new Recetario("Primer recetario");
        this.recetario2 = new Recetario("Segundo recetario");
        this.recetario3 = new Recetario("Tercero recetario");

        this.usuario1 = new Usuario();
        this.usuario2 = new Usuario();
        this.usuario3 = new Usuario();


        this.perfil1= new Carnivoro(accionNotificar);
        this.perfil2= new Vegetariano(accionNotificar);
        this.perfil3= new Celiaco();
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
    public void seCreanPerfiles(){
        assertSame(usuario1.getPerfilActual().getNombre(),"Carnivoro");
        assertSame(usuario3.getPerfiles().get(0).getNombre(),"Celiaco");
        assertSame(usuario3.getPerfiles().get(1).getNombre(),"Vegano");
    }

    @Test
    public void seNotificaCorrespondiente() {
        usuario1.suscribirse(recetario1);
        recetario1.agregarReceta(receta1);
        verify(accionNotificar,times(1)).accionar(null,perfil1);
//        verify(perfil1.getEstadoNotificar().accionar(null, perfil1));
    }

    @Test
    public void notificacionesDeshabilitadas() {
//      Usuario con perfil Carnivoro
        usuario1.suscribirse(recetario1);
//      Desactivo perfil carnivoro
        perfil1.getEstadoNotificar().cambiarEstado(null,perfil1);

        usuario1.agegarPerfil(perfil2);
//      Creo perfil vegetariano
        usuario1.cambiarPerfil("Vegetariano");
        usuario1.suscribirse(recetario1);

        Receta receta4 = new Receta("RecetaVegetariana");
        receta4.agregarIngrediente(new Ingrediente(TipoIngrediente.LEGUMBRES,"legumbre",20, 20, "Gr"));


//      Agrego receta no Apta para vegetarianos
        recetario1.agregarReceta(receta1);
        recetario1.agregarReceta(receta2);
//      Agrego receta apta para Vegetarianos
        recetario1.agregarReceta(receta4);

        verify(accionNotificar,times(2)).accionar(null,perfil1);
        verify(accionNotificar,times(1)).accionar(null,perfil2);
    }
}
