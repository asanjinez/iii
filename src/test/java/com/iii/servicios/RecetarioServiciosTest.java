package com.iii.servicios;

import com.iii.model.Receta;
import com.iii.model.Recetario;
import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecetarioServiciosTest {
    @Autowired
    public RecetarioServicios servicio;
    @Autowired
    public IngredientesServicios servicioIngredientes;
    @Autowired
    public RecetasServicios servicioRecetas;

    public Recetario recetario1;
    public Recetario recetario2;

    public Receta receta1;
    public Receta receta2;

    public  Ingrediente ingrediente1;
    public  Ingrediente ingrediente2;

    @BeforeEach
    void setUp() {
        this.recetario1 = new Recetario("RecetarioPrueba1");
        this.recetario2 = new Recetario("RecetarioPrueba2");
        receta1 = new Receta("Receta1");
        receta2 = new Receta("Receta2");

        Ingrediente ingrediente1 = new Ingrediente(TipoIngrediente.CARNES,"Milanesa",20,200,"Unidades");
        Ingrediente ingrediente2 = new Ingrediente(TipoIngrediente.CEREALES,"Cereal",1,30,"Gramos");

        receta1.agregarIngrediente(ingrediente1);
        receta2.agregarIngrediente(ingrediente2);

        recetario1.agregarReceta(receta1);
        recetario2.agregarReceta(receta2);
    }
    @AfterEach
    void after(){
        servicio.deleteAll();
        servicioRecetas.deleteAll();
        servicioIngredientes.deleteAll();
    }

    @Test
    void save() {
        deleteAll();
        servicio.save(recetario1);
        servicio.save(recetario2);
        assertNotNull(servicio.findByName(recetario1.getTitulo()).orElse(null));
        assertNotNull(servicio.findByName(recetario2.getTitulo()).orElse(null));

    }

    @Test
    void listAll() {
        servicio.save(recetario1);
        servicio.save(recetario2);
        for (Recetario recetario : servicio.findAll()){
            System.out.println(recetario);
        }
        assertNotEquals(0,servicio.findAll().size());

    }

    @Test
    void update() throws Exception {
        Recetario recetarioNuevo = new Recetario("RecetarioNuevo");
        recetarioNuevo.agregarReceta(receta1);
        servicio.save(recetarioNuevo);
        Recetario recetarioModif = (Recetario) servicio.findByName("RecetarioNuevo").orElse(null);
        int cantidad_recetas= recetarioModif.cantidadRecetas();

        String nombreCambiado = "receta_nuevo_nombre";

        recetarioModif.setTitulo(nombreCambiado);
        recetarioModif.agregarReceta(receta2);
        servicio.save(recetarioModif);

        assertNotNull(servicio.findByName(nombreCambiado).orElse(null));
        assertTrue(servicio.findByName(nombreCambiado).orElseThrow(Exception::new).cantidadRecetas() > cantidad_recetas );

        for (Recetario recetario : servicio.findAll()){
            System.out.println(recetario);
        }

    }

    @Test
    void delete() throws Exception {
        servicio.save(new Recetario("RecetarioBorrar"));
        Recetario recetarioBuscado = servicio.findByName("RecetarioBorrar").orElseThrow(Exception::new);
        servicio.delete(recetarioBuscado);
        assertNull(servicio.findByName("recetarioBuscado").orElse(null));

    }

    @Test
    void deleteAll(){
        servicio.deleteAll();
    }
}