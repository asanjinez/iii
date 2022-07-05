package com.iii.servicios;

import com.iii.model.ingredientes.Ingrediente;
import com.iii.model.ingredientes.TipoIngrediente;
import com.iii.model.ingredientes.cantidad.InfoCantidad;
import com.iii.model.ingredientes.cantidad.InfoCantidadDTO;
import com.iii.model.ingredientes.cantidad.Unidades;
import com.iii.repositorios.InfoIngredientesRepositorio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.CriteriaBuilder;

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
        this.ingrediente = new Ingrediente(TipoIngrediente.CARNES, "Milanesa", new InfoCantidadDTO(1,Unidades.KG), 200);
    }

    @AfterEach
    void after(){
        servicio.deleteAll();
        this.infoIngredientesRepositorio.deleteAll();
    }

    @Test
    void save() {
        servicio.save(ingrediente);
        assertNotNull(servicio.findByNombre(ingrediente.getNombre()).orElse(null));
    }

    @Test
    void listAll() {
        servicio.save(ingrediente);
        assertNotEquals(0,servicio.findAll().size());

    }

    @Test
    void update() throws Exception {
        servicio.save(new Ingrediente(TipoIngrediente.CARNES,"MilanesaPrueba",new InfoCantidadDTO(2,Unidades.UNIDADES),0));
        servicio.save(new Ingrediente(TipoIngrediente.CARNES,"MilanesaPrueba2",new InfoCantidadDTO(2,Unidades.UNIDADES),0));
        String nombre_cambiado = "nombre_prueba";

        Ingrediente ingrediente_modif = servicio.findByNombre("MilanesaPrueba2").orElseThrow(Exception::new);
        ingrediente_modif.setNombre(nombre_cambiado);
        servicio.save(ingrediente_modif);
        assertNotNull(servicio.findByNombre(nombre_cambiado).orElse(null));


    }

    @Test
    void delete() throws Exception {
        servicio.save(new Ingrediente(TipoIngrediente.LEGUMBRES,"LentejasPrueba",new InfoCantidadDTO(0,Unidades.GR),0));
        Ingrediente ingredienteBuscado = servicio.findByNombre("LentejasPrueba").orElseThrow(Exception::new);
        servicio.delete(ingredienteBuscado);
        assertNull(servicio.findByNombre("LentejasPrueba").orElse(null));

    }

//    @Test
//    void deleteAll(){
//        servicio.deleteAll();
//    }
}

