package com.iii.servicios;

import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class IngredientesServiciosTest {
    @Autowired
    public IngredientesServicios servicio;

    Ingrediente ingrediente;
    @BeforeEach
    void setUp() {
        this.ingrediente = new Ingrediente(TipoIngrediente.CARNES, "prueba", 20, 20, "Unidades");
    }

    @AfterEach
    void after(){
        servicio.deleteAll();
    }

    @Test
    void save() {
        servicio.save(ingrediente);
        assertNotNull(servicio.findByName(ingrediente.getNombre()).orElse(null));
    }

    @Test
    void listAll() {
        servicio.save(ingrediente);
        assertNotEquals(0,servicio.findAll().size());

    }

    @Test
    void update() throws Exception {
        servicio.save(new Ingrediente(TipoIngrediente.CARNES,"MilanesaPrueba",0,0,"Unidad"));
        servicio.save(new Ingrediente(TipoIngrediente.CARNES,"MilanesaPrueba2",0,0,"Unidad"));
        servicio.save(new Ingrediente(TipoIngrediente.CARNES,"MilanesaPrueba3",0,0,"Unidad"));
        servicio.save(new Ingrediente(TipoIngrediente.CARNES,"MilanesaPrueba4",0,0,"Unidad"));

        String nombre_cambiado = "nombre_prueba";

        Ingrediente ingrediente_modif = servicio.findByName("MilanesaPrueba3").orElseThrow(Exception::new);
        ingrediente_modif.setNombre(nombre_cambiado);
        servicio.save(ingrediente_modif);
        assertNotNull(servicio.findByName(nombre_cambiado).orElse(null));


    }

    @Test
    void delete() throws Exception {
        servicio.save(new Ingrediente(TipoIngrediente.LEGUMBRES,"LentejasPrueba",0,0,"Unidad"));
        Ingrediente ingredienteBuscado = servicio.findByName("LentejasPrueba").orElseThrow(Exception::new);
        servicio.delete(ingredienteBuscado);
        assertNull(servicio.findByName("LentejasPrueba").orElse(null));

    }

    @Test
    void deleteAll(){
        servicio.deleteAll();
    }
}

