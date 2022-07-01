package com.iii.servicios;

import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import com.iii.model.ingredientes.cantidad.Medibles;
import com.iii.model.ingredientes.cantidad.Unidades;
import com.iii.repositorios.InfoIngredientesRepositorio;
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
    @Autowired
    public InfoIngredientesRepositorio infoIngredientesRepositorio;

    Ingrediente ingrediente;
    @BeforeEach
    void setUp() {
        this.ingrediente = new Ingrediente(TipoIngrediente.CARNES, "Milanesa", new Medibles(1, Unidades.KG), 200);
    }

    @AfterEach
    void after(){
        servicio.deleteAll();
        this.infoIngredientesRepositorio.deleteAll();
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
        servicio.save(new Ingrediente(TipoIngrediente.CARNES,"MilanesaPrueba",new Medibles(0,Unidades.UNIDADES),0));
        servicio.save(new Ingrediente(TipoIngrediente.CARNES,"MilanesaPrueba2",new Medibles(0,Unidades.UNIDADES),0));
        servicio.save(new Ingrediente(TipoIngrediente.CARNES,"MilanesaPrueba3",new Medibles(0,Unidades.UNIDADES),0));
        servicio.save(new Ingrediente(TipoIngrediente.CARNES,"MilanesaPrueba4",new Medibles(0,Unidades.UNIDADES),0));

        String nombre_cambiado = "nombre_prueba";

        Ingrediente ingrediente_modif = servicio.findByName("MilanesaPrueba3").orElseThrow(Exception::new);
        ingrediente_modif.setNombre(nombre_cambiado);
        servicio.save(ingrediente_modif);
        assertNotNull(servicio.findByName(nombre_cambiado).orElse(null));


    }

    @Test
    void delete() throws Exception {
        servicio.save(new Ingrediente(TipoIngrediente.LEGUMBRES,"LentejasPrueba",new Medibles(0,Unidades.GR),0));
        Ingrediente ingredienteBuscado = servicio.findByName("LentejasPrueba").orElseThrow(Exception::new);
        servicio.delete(ingredienteBuscado);
        assertNull(servicio.findByName("LentejasPrueba").orElse(null));

    }

//    @Test
//    void deleteAll(){
//        servicio.deleteAll();
//    }
}

