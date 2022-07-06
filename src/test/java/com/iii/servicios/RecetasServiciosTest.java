package com.iii.servicios;

import com.iii.model.Receta;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import com.iii.model.ingredientes.cantidad.Medibles;
import com.iii.model.ingredientes.cantidad.Unidades;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RecetasServiciosTest {
    @Autowired
    public RecetasServicios servicioRecetas;
    @Autowired IngredientesServicios servicioIngredientes;

    public Ingrediente ingrediente1;
    public Ingrediente ingrediente2;
    public Receta recetaPrueba;

    @BeforeEach
    void setUp(){
        this.ingrediente1 = new Ingrediente(TipoIngrediente.VEGETALES,"Lechuga",new Medibles(2, Unidades.UNIDADES),10);
        this.ingrediente2 = new Ingrediente(TipoIngrediente.CARNES,"Lomo",new Medibles(4,Unidades.UNIDADES),155);
        this.recetaPrueba = new Receta("RecetaPrueba");

        recetaPrueba.agregarIngrediente(ingrediente1);
    }
    @AfterEach
    void after(){
        servicioRecetas.deleteAll();
        servicioIngredientes.deleteAll();
    }

    @Test
    void save() {
        Receta buscada = servicioRecetas.save(recetaPrueba);
        assertNotNull(buscada);

    }

    @Test
    void listAll() {
        servicioRecetas.save(recetaPrueba);
        assertNotEquals(0,servicioRecetas.findAll().size());

    }

    @Test
    void update() throws Exception {
/*
        Es mejor hacer la consulta a traves de logica de programacion o a traves de consultas SQL?
 */     Receta recetaNueva = new Receta("RecetaNueva");
        recetaNueva.agregarIngrediente(ingrediente1);
        servicioRecetas.save(recetaNueva);
        Receta recetaModif = (Receta) servicioRecetas.findByName("RecetaNueva").orElse(null);
        int cantidad_ingredienttes = recetaModif.cantidadIngredientes();

        String nombreCambiado = "receta_nuevo_nombre";

        recetaModif.setNombre(nombreCambiado);
        recetaModif.agregarIngrediente(ingrediente2);
        servicioRecetas.save(recetaModif);

        assertNotNull(servicioRecetas.findByName(nombreCambiado).orElse(null));
        assertTrue(servicioRecetas.findByName(nombreCambiado).orElseThrow(Exception::new).cantidadIngredientes() > cantidad_ingredienttes );

    }

    @Test
    void delete() throws Exception {
        Receta receta1 = new Receta("RecetaBorrar");
        servicioRecetas.save(receta1);
        Receta recetaBuscada = servicioRecetas.findByName("RecetaBorrar").orElseThrow(Exception::new);
        servicioRecetas.delete(recetaBuscada);
        assertEquals(null, servicioRecetas.findByName("RecetaBorrar").orElse(null));

    }

    @Test
    void deleteAll() {
        servicioRecetas.deleteAll();
    }
}